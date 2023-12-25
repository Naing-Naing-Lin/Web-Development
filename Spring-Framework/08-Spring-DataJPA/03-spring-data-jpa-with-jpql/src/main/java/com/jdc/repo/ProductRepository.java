package com.jdc.repo;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.jdc.entity.Category;
import com.jdc.entity.Product;
import com.jdc.entity.Product.Size;

public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Modifying
	@Query(value = "Update Product p set p.name = ?1, p.price = ?2, p.category = ?3, p.size = ?4, p.date = ?5 where p.id = ?6")
	void updateByProductId(String name, double price, Category category, Size size, LocalDate date, int productId);
}
