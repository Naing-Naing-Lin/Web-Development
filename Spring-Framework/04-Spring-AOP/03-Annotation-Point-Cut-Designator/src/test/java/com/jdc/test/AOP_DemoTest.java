package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.demo.service.AdminService;

@SpringJUnitConfig(locations = "classpath:/application.xml")
public class AOP_DemoTest {

	@Autowired
	private AdminService adminService;
	
	@Test
	void demo() {
		adminService.sayHello("Hello! AOP");
	}
}
