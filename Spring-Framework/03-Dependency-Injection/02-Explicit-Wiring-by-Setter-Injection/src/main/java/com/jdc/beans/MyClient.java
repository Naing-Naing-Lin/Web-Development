package com.jdc.beans;

public class MyClient {

	private MainService service;
	
	public void setService(MainService service) {
		this.service = service;
	}
	
	public void callService() {
		service.doService();
	}
}
