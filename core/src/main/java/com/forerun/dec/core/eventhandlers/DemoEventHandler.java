package com.forerun.dec.core.eventhandlers;

import java.util.HashMap;
import java.util.Map;

import javax.jcr.Node;
import javax.jcr.Session;

import org.apache.sling.api.SlingConstants;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component(immediate=true, service=EventHandler.class, property= {
		"event.topics=org/apache/sling/api/resource/Resource/ADDED",
		"event.filter=(path=/content/we-retail/language-masters/en/women/*)"
})
public class DemoEventHandler implements EventHandler{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	
	@Reference
	private ResourceResolverFactory resolverFactory;

	@Override
	public void handleEvent(Event event) {
		try {
			String path = event.getProperty("path").toString();
			logger.info(path);	
			if(path.endsWith("jcr:content")) {
				Session session = null;
				Map<String,Object> authenticationMap = new HashMap<>();
				authenticationMap.put(ResourceResolverFactory.SUBSERVICE, "dec-sub-service");
				ResourceResolver resourceResolver = resolverFactory.getServiceResourceResolver(authenticationMap);
				session = resourceResolver.adaptTo(Session.class);
				Node node = session.getNode(path);
				node.setProperty("demo_prop", "demo_value");
				session.save();
			}			
		}
		catch(Exception e) {
			logger.error(e.getMessage());
		}
	}

}
