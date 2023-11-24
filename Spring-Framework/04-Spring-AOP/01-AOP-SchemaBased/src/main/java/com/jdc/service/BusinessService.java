package com.jdc.service;

public class BusinessService implements IBusinessService {

	@Override
	public void doBusiness(String...args) {
		
		System.out.println("Hello from business service");
	}

}
