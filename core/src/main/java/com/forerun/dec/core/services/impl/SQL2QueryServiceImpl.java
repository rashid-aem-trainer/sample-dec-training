package com.forerun.dec.core.services.impl;

import java.util.Iterator;
import java.util.List;

import javax.jcr.query.Query;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Component;

import com.forerun.dec.core.services.SQL2QueryService;
@Component(immediate=true, service = SQL2QueryService.class)
public class SQL2QueryServiceImpl implements SQL2QueryService{

	@Override
	public List<String> getResults(List<String> resultTitles, String parentPagePath, ResourceResolver resolver) {
		Iterator<Resource> resourceItr = resolver.findResources("SELECT * FROM [cq:Page] AS s WHERE ISDESCENDANTNODE(["+parentPagePath+"]) and CONTAINS(s.*, 'men')", Query.JCR_SQL2);
		while(resourceItr.hasNext()) {
			Resource searchRes = resourceItr.next();
			Resource childRes = searchRes.getChild("jcr:content");
			String title = childRes.getValueMap().get("jcr:title", "");
			resultTitles.add(title);
		}
		return resultTitles;
	}

}
