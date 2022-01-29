package com.forerun.dec.core.workflows.process;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.replication.ReplicationActionType;
import com.day.cq.replication.Replicator;

@Component(immediate = true, service = WorkflowProcess.class, property= {
		"process.label=Dec Custom Process Step"
})
public class DecCustomProcess implements WorkflowProcess{
	

	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Reference
	private Replicator replicator;
	
	@Reference
	private ResourceResolverFactory resolverFactory;
	
	@Override
	public void execute(WorkItem workItem, WorkflowSession arg1, MetaDataMap arg2) throws WorkflowException {
		try {
			Session session = null;
			Map<String,Object> authenticationMap = new HashMap<>();
			authenticationMap.put(ResourceResolverFactory.SUBSERVICE, "dec-sub-service");
			ResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver(authenticationMap);
			session = resourceResolver.adaptTo(Session.class);
			String payload = workItem.getWorkflowData().getPayload().toString();
			logger.info(payload);
			replicator.replicate(session, ReplicationActionType.ACTIVATE, payload+"/jcr:content");
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

}
