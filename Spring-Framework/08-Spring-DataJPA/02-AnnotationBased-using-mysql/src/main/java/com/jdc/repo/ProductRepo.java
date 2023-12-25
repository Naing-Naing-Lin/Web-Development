package com.jdc.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jdc.entity.Product;
import com.jdc.entity.Product.Size;

public interface ProductRepo extends JpaRepository<Product, Integer>{

	List<Product> findByName(String name);
	List<Product> findByCategory_id(int category);
	List<Product> findByCategoryName(String name);
	List<Product> findByNameOrCategoryName(String pName, String cName);
	List<Product> findByNameAndCategoryName(String pName, String cName);
	
	boolean existsProductByName(String name);
	
	List<Product> findByNameNotLike(String string);
	List<Product> findByNameLike(String name);
	List<Product> findByNameLikeIgnoreCase(String name);
	List<Product> findByNameLikeAndCategoryNameLikeAllIgnoreCase(String pName, String cName);
	
	List<Product> findByNameStartsWith(String string);
	List<Product> findProductByNameStartingWith(String string);
	List<Product> findProductByPriceGreaterThanEqual(int price);
	List<Product> findProductByPriceLessThanEqual(int price);
	
	List<Product> getByNameAndPrice(String name, double price);
	
	Long countBySize(Size size);
	
	boolean existsByName(String name);
	
	List<Product> findFirst2BySize(Size size);
	
	void deleteBySize(Size size);
	
	// null & empty
	List<Product> findProductByNameNotNull();
	
	// Date
	List<Product> findProductByCreatedDateAfter(LocalDate date);
	
	
	
}
