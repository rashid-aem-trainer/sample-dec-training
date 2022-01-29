package com.forerun.dec.core.servlets;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.mail.HtmlEmail;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.Designate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;
import com.forerun.dec.core.configurations.MailConfiguration;

@Component(immediate=true, service = Servlet.class, property = {
		"sling.servlet.paths=/bin/dec/custommailservlet",
		"sling.servlet.methods=POST",
		"sling.servlet.methods=GET"		
})
@Designate(ocd = MailConfiguration.class)
public class CustomMailServlet extends SlingAllMethodsServlet{

	private static final long serialVersionUID = -1485218549988601567L;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	MailConfiguration mailConfig;
	
	@Reference
	MessageGatewayService messageGateWayService;
	
	@Activate
	public void readConfiguration(MailConfiguration config) {
		mailConfig = config;
	}
	
	@Override
	protected void doPost(SlingHttpServletRequest request, SlingHttpServletResponse response)
			throws ServletException, IOException {
		try {
			String firstnameVal = request.getParameter("firstname");
			logger.info("firstnameVal "+firstnameVal);
			String lastnameVal = request.getParameter("lastname");
			logger.info("lastnameVal "+lastnameVal);	
			String addressVal = request.getParameter("address");
			logger.info("address "+addressVal);	
			HtmlEmail mail = new HtmlEmail();
			mail.addTo(mailConfig.toAddress());
			mail.setFrom(mailConfig.fromAddress());
			mail.setSubject(mailConfig.subject());
			mail.setContent("firstnameVal "+firstnameVal+"<br>"+"lastnameVal "+lastnameVal+"<br>"+"address "+addressVal, "text/html");
			MessageGateway<HtmlEmail> gateway = messageGateWayService.getGateway(HtmlEmail.class);
			gateway.send(mail);
			response.sendRedirect("/content/we-retail/language-masters/en/experience/arctic-surfing-in-lofoten.html?wcmmode=disabled");
		}
		catch(Exception e) {
			
		}
	
	}

}
