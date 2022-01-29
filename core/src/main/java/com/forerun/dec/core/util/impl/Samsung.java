package com.forerun.dec.core.util.impl;

import org.osgi.service.component.annotations.Component;

import com.forerun.dec.core.util.Mobile;

@Component(immediate=true,service=Mobile.class,property= {
		"type=Samsung"
})
public class Samsung implements Mobile{

	@Override
	public String makeCall() {
		// TODO Auto-generated method stub
		return "Making call from Samsung Mobile";
	}

	@Override
	public String sendSms() {
		// TODO Auto-generated method stub
		return "Sending SMS from Samsung Mobile";
	}

}
