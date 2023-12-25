package com.jdc.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.service.IBusinessService;
import com.jdc.service.OtherService;

@SpringJUnitConfig(locations = "classpath:context.xml")
public class AOP_DemoTest {

	@Autowired
	private IBusinessService serviceBean;
	
	@Autowired
	private OtherService otherServiceBean;
	
	@Test
	void demo() {
		serviceBean.doBusiness();
		
		System.out.println();
		
		otherServiceBean.doService();
	}
}
