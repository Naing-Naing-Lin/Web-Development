package com.jdc.test;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.jdc.entity.Category;
import com.jdc.entity.Product;
import com.jdc.entity.Product.Size;
import com.jdc.service.ProductService;

public class ProductTestWithHibernateJPA {

	private static ProductService service;
	
	@BeforeAll
	static void init() {
		service = new ProductService();
	}
	
	@Test
	void create() {
		var c = new Category();
		c.setId(1);
		var p = new Product("Lemon", 500.0, c, LocalDate.now());
		p.setSize(Size.LARGE);
		service.create(p);
	}
	
	@Test
	void createQuery() {
		service.createWithQuery();
	}
}
