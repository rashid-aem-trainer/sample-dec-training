package com.forerun.dec.core.configurations;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Dec Mail Configuration")
public @interface MailConfiguration {
	
	@AttributeDefinition(name = "To Address", description = "Enter to Address", type = AttributeType.STRING)
	public String toAddress();
	
	@AttributeDefinition(name= "from Address", description = "Enter the from Address", type = AttributeType.STRING)
	public String fromAddress();
	
	@AttributeDefinition(name= "subject", description = "Enter the subject", type = AttributeType.STRING)
	public String subject();

}
