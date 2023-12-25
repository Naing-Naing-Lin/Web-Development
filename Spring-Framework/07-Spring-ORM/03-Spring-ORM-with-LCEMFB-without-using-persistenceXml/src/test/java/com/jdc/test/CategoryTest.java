package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.config.ApplicationConfig;
import com.jdc.entity.Category;
import com.jdc.repo.CategoryRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class CategoryTest {

	@Autowired
	CategoryRepo repo;
	
	@ParameterizedTest
	@ValueSource(strings = "Fruits")
	void create(String name) {
		var c = repo.create(new Category(name));
		
		assertNotNull(c);
	}
}
