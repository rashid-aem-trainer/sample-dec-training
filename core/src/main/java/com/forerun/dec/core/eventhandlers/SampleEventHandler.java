package com.forerun.dec.core.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;

import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.engine.EngineConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate = true, service=EventHandler.class, property = {
		EventConstants.EVENT_TOPIC+"="+SlingConstants.TOPIC_RESOURCE_ADDED,
		EventConstants.EVENT_FILTER+"="+"(path=/content/we-retail/language-masters/en/*)"
})
public class SampleEventHandler implements EventHandler{
	
	Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void handleEvent(Event event) {
		/*
		 * try { String path = event.getProperty("path").toString(); Map<String,Object>
		 * authenticationMap = new HashMap<>();
		 * authenticationMap.put(ResourceResolverFactory.SUBSERVICE, "courier-sub");
		 * ResourceResolver resourceResolver =
		 * resolverFactory.getServiceResourceResolver(authenticationMap);
		 * logger.info(path); if(path.endsWith("jcr:content")) { Node pageNode =
		 * resourceResolver.getResource(path).adaptTo(Node.class);
		 * pageNode.setProperty("new_prop", "new_val"); } resourceResolver.commit(); }
		 * catch(Exception e) {
		 * 
		 * }
		 * 
		 */}

}
