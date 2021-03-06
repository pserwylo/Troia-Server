/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/
package com.datascience.datastoring.storages;

import com.datascience.core.base.AssignedLabel;
import com.datascience.core.base.LObject;
import com.datascience.core.base.Worker;
import com.datascience.datastoring.adapters.db.DBFullAdapter;
import com.datascience.datastoring.backends.db.DBInMemoryBackend;
import com.datascience.datastoring.datamodels.full.DBJobStorage;
import com.datascience.datastoring.datamodels.memory.InMemoryData;
import com.datascience.datastoring.datamodels.memory.InMemoryNominalData;
import com.datascience.datastoring.jobs.IJobStorage;
import com.datascience.datastoring.jobs.Job;
import com.datascience.datastoring.jobs.JobFactory;
import com.datascience.core.nominal.INominalData;
import com.datascience.core.nominal.NominalProject;
import com.datascience.core.results.IResults;
import com.datascience.serialization.json.GSONSerializer;
import com.google.gson.JsonObject;

import java.util.*;


import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import org.junit.Assert;
import org.junit.Test;

/**
*
* @author dana
*/
public class CachedAndDBJobStorageTest {

	private INominalData initializeNominalData() {
		ArrayList<Worker> workers;
		ArrayList<LObject<String>> objects;
		ArrayList<LObject<String>> goldObjects;
		ArrayList<AssignedLabel<String>> assigns;
		Set<String> categories;
		INominalData nominalData = new InMemoryNominalData();
		int nWorkers = 2;
		int nObjects = 4;
		int nGold = 2;
		int i;

		categories = new HashSet<String>();
		categories.add("cat1");
		categories.add("cat2");

		nominalData.initialize(categories, null, null);

		workers = new ArrayList<Worker>();
		for (i = 0; i < nWorkers; i++) {
			workers.add(new Worker("worker" + i));
		}

		objects = new ArrayList<LObject<String>>();
		for (i = 0; i < nObjects; i++) {
			objects.add(new LObject<String>("object" + i));
		}

		goldObjects = new ArrayList<LObject<String>>();
		for (i = 0; i < nGold; i++) {
			LObject<String> gold = new LObject<String>("gObject" + i);
			gold.setGoldLabel(categories.iterator().next().toString());
			goldObjects.add(gold);
		}

		objects.addAll(goldObjects);

		int nAssigns = nWorkers * (nObjects + nGold);
		assigns = new ArrayList<AssignedLabel<String>>();
		for (i = 0; i < nAssigns; i++) {
			assigns.add(new AssignedLabel<String>(workers.get(i % nWorkers),
					objects.get(i % (nObjects + nGold)),
					categories.iterator().next().toString()));
		}

		for (LObject<String> gold : goldObjects) {
			nominalData.addObject(gold);
		}

		for (AssignedLabel<String> assign : assigns) {
			nominalData.addAssign(assign);
		}
		return nominalData;
	}


	private JsonArray createCategoriesJsonArray(Collection<String> categories) {
		JsonArray cat = new JsonArray();
		Iterator<String> iterator = categories.iterator();
		while (iterator.hasNext()) {
			String category = iterator.next();
			cat.add(new JsonPrimitive(category));
		}
		return cat;
	}

//	private void checkResults(IResults expectedResults, IResults actualResults) {
//
//		Map expectedDatumResults = expectedResults.getDatumResults();
//		for (Iterator it = expectedDatumResults.entrySet().iterator(); it.hasNext();) {
//			Object obj  = it.next();
//			System.out.println(obj);
//		}
//	}

	@Test
	public void testMixedStorages() throws Exception {
		IJobStorage dbJobStorage = new DBJobStorage(new DBFullAdapter(new DBInMemoryBackend()), new GSONSerializer());
//		dbJobStorage.clear();
		dbJobStorage.initialize();

		JobFactory jobFactory = new JobFactory(new GSONSerializer(), dbJobStorage);
		JsonObject jo = new JsonObject();
		INominalData nominalData = initializeNominalData();
		jo.addProperty("algorithm", "BDS");
		jo.add("categories", createCategoriesJsonArray(nominalData.getCategories()));
		jo.addProperty(com.datascience.scheduler.Constants.SCHEDULER, com.datascience.scheduler.Constants.SCHEDULER_NORMAL);

		Job job1 = jobFactory.createNominalJob(jo, "job1");
		job1.getProject().setData(nominalData);
		job1.getProject().getAlgorithm().compute();
		String job1Kind = job1.getProject().getKind();
		IResults job1Results = job1.getProject().getResults();
                Assert.assertFalse(job1Results == null);

		Job job2 = jobFactory.createNominalJob(jo, "job2");
		job2.getProject().setData(nominalData);
		job2.getProject().getAlgorithm().compute();

		CachedJobStorage cachedJobStorage = new CachedJobStorage(dbJobStorage, 1);

		cachedJobStorage.add(job1);
		cachedJobStorage.add(job2);
		//at this point job1 should be removed from cache and added to db

		//check that the job received from the db storage has the same data as the original one
		Job<NominalProject> dbJob = dbJobStorage.get("job1");
		Assert.assertEquals("job1", dbJob.getId());

		NominalProject dbNominalProject = dbJob.getProject();
		Assert.assertEquals(job1Kind, dbNominalProject.getKind());
                System.out.println(dbNominalProject.getAlgorithm().getResults());
		//checkResults(job1Results, dbNominalProject.getAlgorithm().getResults());

		InMemoryData dbJobData = (InMemoryData)dbNominalProject.getData();
		Assert.assertEquals(nominalData.getAssigns(), dbJobData.getAssigns());
		Assert.assertEquals(nominalData.getGoldObjects(), dbJobData.getGoldObjects());
		Assert.assertEquals(nominalData.getEvaluationObjects(), dbJobData.getEvaluationObjects());
		Assert.assertEquals(nominalData.getObjects(), dbJobData.getObjects());
		Assert.assertEquals(nominalData.getWorkers(), dbJobData.getWorkers());
	}
}