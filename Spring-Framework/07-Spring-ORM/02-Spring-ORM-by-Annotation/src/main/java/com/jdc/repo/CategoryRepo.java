package com.jdc.repo;


import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class CategoryRepo {
	
	//@PersistenceContext(name = "ORM-Demo")
	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public Category create(Category category) {
		
		em.persist(category);
		return category;
	}

}
