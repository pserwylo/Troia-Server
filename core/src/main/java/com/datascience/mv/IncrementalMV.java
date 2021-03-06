package com.datascience.mv;

import com.datascience.core.algorithms.INewDataObserver;
import com.datascience.core.base.AssignedLabel;
import com.datascience.core.base.LObject;
import com.datascience.core.base.Worker;
import com.datascience.core.nominal.IIncrementalNominalModel;
import com.datascience.datastoring.datamodels.memory.IncrementalNominalModel;
import com.datascience.core.nominal.CategoryPriorCalculators;
import com.datascience.core.stats.ErrorRateCalculators;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

/**
 * @Author: konrad
 */
public class IncrementalMV extends MajorityVote implements INewDataObserver {

	private IIncrementalNominalModel model;

	public IncrementalMV(){
		super(
			new ErrorRateCalculators.BatchErrorRateCalculator(),
			new CategoryPriorCalculators.IncrementalCategoryPriorCalculator());
		model = new IncrementalNominalModel();
	}

	@Override
	public IIncrementalNominalModel getModel() {
		return model;
	}

	@Override
	public Type getModelType() {
		return new TypeToken<IncrementalNominalModel>() {} .getType();
	}

	@Override
	public void setModel(Object o){
		model = (IIncrementalNominalModel) o;
	}

	@Override
	public void compute() {
		//There is nothing that we would make sense to do here
	}

	public void computeForNewAssign(AssignedLabel<String> assign){
		computeResultsForObject(assign.getLobject());
		for (AssignedLabel<String> al: getData().getAssignsForObject(assign.getLobject())){
			computeWorkersConfusionMatrix(al.getWorker());
		}
		if (!data.arePriorsFixed()){
			model.setPriorDenominator(model.getPriorDenominator()+1);
			Map<String, Double> priors = model.getCategoryPriors();
			priors.put(assign.getLabel(), model.getCategoryPriors().get(assign.getLabel()) + 1);
			model.setCategoryPriors(priors);
		}
	}

	@Override
	public void newAssign(AssignedLabel assign) {
		computeForNewAssign(assign);
	}

	@Override
	public void newGoldObject(LObject object) {
		computeResultsForObject(object);
	}

	@Override
	public void newObject(LObject object) {
		computeResultsForObject(object);
	}

	@Override
	public void newWorker(Worker worker) {
	}
}
