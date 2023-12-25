package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.entity.Category;
import com.jdc.repo.CategoryRepo;

@SpringJUnitConfig(locations = "/application.xml")
public class CategoryTest {

	@Autowired
	private CategoryRepo repo;
	
	@ParameterizedTest
	@Order(1)
	@CsvSource("Fruits, true")
	void test1(String name, boolean active) {
		
		var cat = repo.create(new Category(name, active));
		
		assertNotNull(cat);
	}
}
