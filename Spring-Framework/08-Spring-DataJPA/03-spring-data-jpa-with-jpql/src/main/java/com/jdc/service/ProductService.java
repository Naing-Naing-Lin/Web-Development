package com.jdc.service;

import java.time.LocalDate;

import com.jdc.entity.Category;
import com.jdc.entity.Product;
import com.jdc.entity.Product.Size;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProductService {

	private EntityManagerFactory emf;
	
	public ProductService() {
		emf = Persistence.createEntityManagerFactory("JPQL");
	}
	
	public void create(Product product) {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(product);
		em.getTransaction().commit();
		em.close();
	}
	
	public void createWithQuery() {
		var em = emf.createEntityManager();
		em.getTransaction().begin();
		var c = new Category();
		c.setId(1);
		var query = em.createQuery("insert into Product p (p.name, p.price, p.category, p.size, p.createdDate) values (?1,?2,?3,?4,?5)");
		query.setParameter(1, "AAA");
		query.setParameter(2, 200.0);
		query.setParameter(3, c);
		query.setParameter(4, Size.MEDIUM);
		query.setParameter(5, LocalDate.now());
		
		query.executeUpdate();
		
		em.getTransaction().commit();
		em.close();
	}
}
