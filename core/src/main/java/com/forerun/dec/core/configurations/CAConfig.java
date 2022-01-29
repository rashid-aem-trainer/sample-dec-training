package com.forerun.dec.core.configurations;

import org.apache.sling.caconfig.annotation.Configuration;
import org.apache.sling.caconfig.annotation.Property;

@Configuration(label = "CAConfig")
public @interface CAConfig {

	@Property(label = "hostname")
	public String hostname();
}
