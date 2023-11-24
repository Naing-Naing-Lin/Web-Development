package com.jdc.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MyClient {

	@Autowired
	@Qualifier("serviceImpl")
	private MainService service;

	public void callService() {
		service.doService();
	}
}
