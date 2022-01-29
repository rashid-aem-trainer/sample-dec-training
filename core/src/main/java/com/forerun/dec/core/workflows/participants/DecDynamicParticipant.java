package com.forerun.dec.core.workflows.participants;

import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.ParticipantStepChooser;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.metadata.MetaDataMap;

@Component(immediate=true, service = ParticipantStepChooser.class, property = {
		"chooser.label=Dec Dynamic Participant Step Chooser"
})
public class DecDynamicParticipant implements ParticipantStepChooser{

	@Override
	public String getParticipant(WorkItem workItem, WorkflowSession wfSession, MetaDataMap metadataMap) throws WorkflowException {
		String payload = workItem.getWorkflowData().getPayload().toString();
		if(null != payload && !payload.equalsIgnoreCase("")) {
			if(payload.startsWith("/content/we-retail/language-masters/en/products")) {
				return "demo-finance-user-1";
			}
		}
		return "demo-business-user-1";
	}

}
