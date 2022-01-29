package com.forerun.dec.core.services.impl;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.forerun.dec.core.services.ConfigurationService;
import com.forerun.dec.core.services.ProductConfiguration;

@Component(service=ConfigurationService.class, immediate = true)
@Designate(ocd = ProductConfiguration.class)
public class ConfigurationServiceImpl implements ConfigurationService{
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	ProductConfiguration productConfig;
	
	@Activate
	public void activate(ProductConfiguration config) {
		logger.info("inside activate of Configuration Service"+config);
		productConfig = config;
	}
	
	
	@Override
	public String getProductUrl() {
		return productConfig.productUrl();
	}
}
