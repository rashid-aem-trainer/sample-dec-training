package com.forerun.dec.core.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.jcr.query.Query;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.forerun.dec.core.services.SQL2QueryService;


@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class SearchModel {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@ValueMapValue(name = "parentpagepath")
	private String parentPagePath;
	
	@ScriptVariable
	private ResourceResolver resolver;
	
	@OSGiService
	SQL2QueryService queryService;
	
	@PostConstruct
	public void init() {
		logger.info("parentPagePath "+parentPagePath);
	}
	
	public List<String> getResultsTitle(){
		List<String> resultTitles = new ArrayList<>();
		queryService.getResults(resultTitles, parentPagePath, resolver);
		return resultTitles;
	}

}
