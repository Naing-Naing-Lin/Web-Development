package com.jdc.service;

import org.springframework.lang.Nullable;

public class BusinessService implements IBusinessService {

	@Override
	public void doBusiness(@Nullable String...args) {
		
		System.out.println("Hello from business service");
	}

}
