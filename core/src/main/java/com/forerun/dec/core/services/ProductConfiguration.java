package com.forerun.dec.core.services;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Product Configuration")
public @interface ProductConfiguration {
	
	@AttributeDefinition(name = "product URL", description = "Please Enter the product URL", type = AttributeType.STRING)
	public String productUrl();

}
