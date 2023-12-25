package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.entity.Category;
import com.jdc.repo.CategoryRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class CategoryTest {

	@Autowired
	private CategoryRepo repo;
	
	@ParameterizedTest
	@Order(1)
	@ValueSource(strings = "Fruits")
	void test1(String name) {
		
		var cat = repo.create(new Category(name));
		
		assertNotNull(cat);
	}
}
