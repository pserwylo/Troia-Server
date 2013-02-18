package com.datascience.galc.commands;

import java.util.Collection;

import com.datascience.core.base.AssignedLabel;
import com.datascience.core.base.ContValue;
import com.datascience.core.base.Data;
import com.datascience.core.base.LObject;
import com.datascience.core.base.Label;
import com.datascience.core.base.Worker;
import com.datascience.core.storages.DataJSON.ShallowAssign;
import com.datascience.core.storages.DataJSON.ShallowAssignCollection;
import com.datascience.galc.ContinuousProject;


/**
 *
 * @author artur
 */
public class AssignsCommands {
	
	static public class AddAssigns extends GALCommandBase<Object> {

		ShallowAssignCollection<ContValue> assigns;
		
		public AddAssigns(ContinuousProject cp, ShallowAssignCollection<ContValue> assigns){
			super(cp, true);
			this.assigns = assigns;
		}
		
		@Override
		protected void realExecute() {
			for (ShallowAssign<ContValue> al : assigns.assigns){
				Data<ContValue> data = project.getData();
				Worker<ContValue> worker = data.getOrCreateWorker(al.worker);
				LObject<ContValue> object = data.getOrCreateObject(al.object);
				data.addAssign(new AssignedLabel<ContValue>(worker, object, new Label<ContValue>(al.label)));
				setResult("Assigns added");
			}
		}
	}
	
	static public class GetAssigns extends GALCommandBase<Collection<AssignedLabel<ContValue>>> {
		
		public GetAssigns(ContinuousProject cp){
			super(cp, false);
		}
		
		@Override
		protected void realExecute() {
			setResult(project.getData().getAssigns());
		}
	}
	
	static public class GetWorkerAssigns extends GALCommandBase<Collection<AssignedLabel<ContValue>>> {
		
		String workerId;
		public GetWorkerAssigns(ContinuousProject cp, String workerId){
			super(cp, false);
			this.workerId = workerId;
		}
		
		@Override
		protected void realExecute() {
			Worker w = ParamChecking.worker(project.getData(), workerId);
			setResult(w.getAssigns());
		}
	}
}