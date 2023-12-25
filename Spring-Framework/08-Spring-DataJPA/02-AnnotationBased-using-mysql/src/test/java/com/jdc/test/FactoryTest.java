package com.jdc.test;

import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.ApplicationConfig;
import com.jdc.repo.MemberRepo;
import com.jdc.repo.ProductRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public abstract class FactoryTest {

	@Autowired
	MemberRepo memberRepo;
	
	@Autowired
	ProductRepo productRepo;
}
