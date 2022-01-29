package com.forerun.dec.core.services;

import java.util.List;

import org.apache.sling.api.resource.ResourceResolver;

public interface SQL2QueryService {
	
	public List<String> getResults(List<String> resultTitles, String parentPagePath, ResourceResolver resolver);

}
