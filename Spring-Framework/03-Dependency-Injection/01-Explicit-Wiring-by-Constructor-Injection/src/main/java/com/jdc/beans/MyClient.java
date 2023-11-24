package com.jdc.beans;

public class MyClient {

	private MainService service;
	
	public MyClient(MainService service) {
		this.service = service;
	}
	
	public void callService() {
		service.doService();
	}
}
