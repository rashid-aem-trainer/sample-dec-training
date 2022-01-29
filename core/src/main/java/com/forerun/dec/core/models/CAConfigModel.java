package com.forerun.dec.core.models;

import javax.annotation.PostConstruct;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.caconfig.ConfigurationBuilder;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;

import com.day.cq.wcm.api.Page;
import com.forerun.dec.core.configurations.CAConfig;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CAConfigModel {
	
	@ScriptVariable
	private Page currentPage;
	
	@ScriptVariable
	private ResourceResolver resolver;
	
	CAConfig caconfig;

	@PostConstruct
	protected void init() {
		caconfig = resolver.getResource(currentPage.getPath()).adaptTo(ConfigurationBuilder.class).as(CAConfig.class);
	}
	
	public String getHostName() {
		return caconfig.hostname();
	}
}
