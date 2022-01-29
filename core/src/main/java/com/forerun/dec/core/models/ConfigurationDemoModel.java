package com.forerun.dec.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.forerun.dec.core.services.ConfigurationService;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class ConfigurationDemoModel {
	
	@OSGiService
	ConfigurationService configService;
	
	public String getValueofProductURL() {
		return configService.getProductUrl();
	}

}
