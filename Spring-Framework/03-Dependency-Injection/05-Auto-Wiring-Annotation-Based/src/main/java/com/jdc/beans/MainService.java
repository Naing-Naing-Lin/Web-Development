package com.jdc.beans;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("mainService")
//@Primary
public class MainService {

	public void doService() {
		System.out.println("Hello from Main Service");
	}
}
