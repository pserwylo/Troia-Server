package com.datascience.core.results;

import com.datascience.core.base.LObject;
import com.datascience.core.base.Worker;

import java.util.HashMap;
import java.util.Map;

/**
 * User: artur
 */
public class Results<T, U, V> {

	protected Map<LObject<T>, U> datumResults;
	protected Map<Worker<T>, V> workerResults;
	protected ResultsFactory.IDatumResultCreator datumCreator;
	protected ResultsFactory.IWorkerResultCreator workerCreator;

	public Results(ResultsFactory.IDatumResultCreator datumCreator, ResultsFactory.IWorkerResultCreator workerCreator){
		this.datumCreator = datumCreator;
		this.workerCreator = workerCreator;
		datumResults = new HashMap<LObject<T>, U>();
		workerResults = new HashMap<Worker<T>, V>();
	}

	public Map<Worker<T>, V> getWorkerResults(){
		return workerResults;
	}

	public Map<LObject<T>, U> getDatumResults(){
		return datumResults;
	}

	public U getOrCreateDatumResult(LObject<T> obj){
		U ret = datumResults.get(obj);
		if (ret == null){
			ret = (U) datumCreator.create(obj);
			datumResults.put(obj, ret);
		}
		return ret;

	}

	public U getDatumResult(LObject<T> obj){
		U ret = datumResults.get(obj);
		if (ret == null)
			throw new IllegalArgumentException("You have not run compute or there is no object named " + obj.getName());
		return ret;
	}

	public void addDatumResult(LObject<T> obj, U result){
		datumResults.put(obj, result);
	}

	public V getOrCreateWorkerResult(Worker<T> wor){
		V ret = workerResults.get(wor);
		if (ret == null){
			ret = (V) workerCreator.create(wor);
			workerResults.put(wor, ret);
		}
		return ret;
	}

	public V getWorkerResult(Worker<T> worker){
		V ret = workerResults.get(worker);
		if (ret == null)
			throw new IllegalArgumentException("You have not run compute or there is no worker named " + worker.getName());
		return ret;
	}

	public void addWorkerResult(Worker<T> worker, V result){
		workerResults.put(worker, result);
	}
}