package com.jdc.beans;

public class MyClient {

	private MainService service;

	// Setter Method
	public void setMainService(MainService service) {
		this.service = service;
	}

	public void callService() {
		service.doService();
	}
}
