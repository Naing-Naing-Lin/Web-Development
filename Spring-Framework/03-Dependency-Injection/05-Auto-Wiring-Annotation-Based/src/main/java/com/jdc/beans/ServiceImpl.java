package com.jdc.beans;

import org.springframework.stereotype.Component;

/*
 * 
 */

@Component("serviceImpl")
//@Qualifier("serviceImpl")
public class ServiceImpl extends MainService{

	@Override
	public void doService() {
		System.out.println("Hello from Service Impl");
	}
}
