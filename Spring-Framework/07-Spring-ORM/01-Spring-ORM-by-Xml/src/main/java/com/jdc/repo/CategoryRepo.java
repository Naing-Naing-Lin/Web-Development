package com.jdc.repo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jdc.entity.Category;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
@Transactional
public class CategoryRepo {
	
	//@PersistenceContext(name = "ORM-Demo") // the name of persistence.xml
	@PersistenceContext
	private EntityManager em;
	
	//@Transactional
	public Category create(Category category) {
	
		em.persist(category);
		return category;
	}

}
