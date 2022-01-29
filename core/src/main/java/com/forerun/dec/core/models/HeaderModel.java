package com.forerun.dec.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jcr.Node;
import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ValueMap;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.forerun.dec.core.datatype.HeaderLink;
import com.forerun.dec.core.util.Mobile;
import com.forerun.dec.core.util.impl.Apple;
import com.forerun.dec.core.util.impl.Samsung;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderModel {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@OSGiService(filter = "(type=Samsung)")
	Mobile mobile1;
	
	@OSGiService(filter = "(type=Apple)")
	Mobile mobile2;
	
	@PostConstruct
	public void init() {
		logger.info("inside post construct");
	}
	
	public String getSamsungCallData() {
		return mobile1.makeCall();
	}
	
	public String getAppleCallData() {
		return mobile2.makeCall();
	}
	
}
