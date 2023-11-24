package com.jdc.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyClient {

	@Autowired
	@Qualifier("mainService")
	private MainService service;

	public void callService() {
		service.doService();
	}
}
