package com.jdc.test;

import java.time.LocalDate;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.ApplicationConfig;
import com.jdc.entity.Category;
import com.jdc.entity.Product;
import com.jdc.entity.Product.Size;
import com.jdc.repo.ProductRepository;

@SpringJUnitConfig(classes = ApplicationConfig.class)
@TestMethodOrder(OrderAnnotation.class)
public class ProductTestWithSpringDataJPA {

	@Autowired
	private ProductRepository repo;
	
	@Test
	@Order(1)
	void create() {
		var c = new Category();
		c.setId(1);
		
		var p = new Product("Tomato", 1000.0, c, LocalDate.now());
		p.setSize(Size.SMALL);
		
		repo.save(p);
	}
	
	@Test
	@Order(2)
	void update() {
		var c = new Category();
		c.setId(2);
		repo.updateByProductId("Yogurt", 2300.0, c, Size.MEDIUM, LocalDate.now(), 6);
	}
}
