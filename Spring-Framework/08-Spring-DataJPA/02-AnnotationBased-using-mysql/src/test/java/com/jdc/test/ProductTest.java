package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.ApplicationConfig;
import com.jdc.entity.Product.Size;

@SpringJUnitConfig(classes = ApplicationConfig.class)

public class ProductTest extends FactoryTest{

	@Test
	@Order(1)
	void findById() {
		var p = productRepo.findById(1).get();
		
		assertAll(() -> {
			assertNotNull(p);
			assertEquals("Orange", p.getName());
			assertEquals(2000, p.getPrice());			
		});
	}
	
	@Test
	@Order(2)
	void findByName() {
		
		var list = productRepo.findByName("Orange");
		var p = list.stream().findFirst().get();
		
		assertAll(() -> {
			assertNotNull(p);
			assertEquals("Orange", p.getName());
			assertEquals(2000, p.getPrice());			
		});
	}
	
	@Test
	@Order(3)
	void findByCategory() {
		var list = productRepo.findByCategory_id(1);
		
		assertEquals(3, list.size());
	}
	
	@Test
	@Order(4)
	void findByCategoryField() {
		
		var list = productRepo.findByCategoryName("Fruits");
		
		assertEquals(3, list.size());
	}
	
	@Test
	@Order(5)
	void getByNameAndPrice() {
		var list = productRepo.getByNameAndPrice("Orange", 2000);
		var p = list.stream().findFirst().get();
		
		assertAll(() -> {
			assertNotNull(p);
			assertEquals("Orange", p.getName());
			assertEquals(2000, p.getPrice());			
		});
	}
	
	@Test
	@Order(6)
	void countBySize() {
		var count = productRepo.countBySize(Size.MEDIUM);
		
		assertEquals(3, count);
	}
	
	@Test
	@Order(7)
	void existsBy() {
		var exist = productRepo.existsByName("Orange");
		
		assertTrue(exist);
	}
	
	@Test
	@Order(8)
	void findFirst2By() {
		var list = productRepo.findFirst2BySize(Size.MEDIUM);
		
		assertEquals(2, list.size());
	}
	
//	@Test
//	@Order(9)
//	@Transactional
//	void deleteBy() {
//		productRepo.deleteBySize(Size.MEDIUM);
//		
//		assertEquals(2, productRepo.findAll().size());
//	}
	
	@Test
	@Order(10)
	void findByCategoryNameOrProductName() {
		var list1 = productRepo.findByNameOrCategoryName("Orange", "");
		assertEquals(1, list1.size());
		
		var list2 = productRepo.findByNameOrCategoryName("", "Fruits");
		assertEquals(3, list2.size());
		
		var list3 = productRepo.findByNameOrCategoryName("Orange", "Drinks");
		assertEquals(4, list3.size());
	}
	
	@Test
	@Order(11)
	void findByCategoryNameAndProductName() {
		var list1 = productRepo.findByNameAndCategoryName("Orange", "Fruits");
		assertEquals(1, list1.size());
		
		var list3 = productRepo.findByNameAndCategoryName("Orange", "Drinks");
		assertEquals(0, list3.size());
	}
	
	@Test
	@Order(12)
	void findByNameisExist() {
		var exist = productRepo.existsProductByName("Orange");
		assertTrue(exist);
	}
	
	@Test
	@Order(12)
	void findByNameLike() {
		var list = productRepo.findByNameLike("O%");
		assertEquals(1, list.size());
		
		var list2 = productRepo.findByNameLikeIgnoreCase("m%");
		assertEquals(1, list2.size());
		
		var list3 = productRepo.findByNameLikeAndCategoryNameLikeAllIgnoreCase("m%", "f%");
		assertEquals(1, list3.size());
	}
	
	@Test
	@Order(13)
	void findByNameNotLike() {
		var list = productRepo.findByNameNotLike("O%");
		assertEquals(4, list.size());
	}
	
	@Test
	@Order(14)
	void findWithStartWith() {
		var list = productRepo.findByNameStartsWith("O");
		assertEquals(1, list.size());
		
		var list2 = productRepo.findProductByNameStartingWith("A");
		assertEquals(1, list2.size());
	}
	
	@Test
	@Order(15)
	void findByGreaterThanAndLessThan() {
		
		var list1 = productRepo.findProductByPriceGreaterThanEqual(2000);
		assertEquals(3, list1.size());
		
		var list2 = productRepo.findProductByPriceLessThanEqual(1900);
		assertEquals(2, list2.size());
	}
	
	@Test
	@Order(16)
	void findByDate() {
		
		var list = productRepo.findProductByCreatedDateAfter(LocalDate.of(2022, 02, 15));
		
		assertEquals(4, list.size());
	}
	
	@Test
	@Order(17)
	void findProductByNameWithNotNull() {
		var list = productRepo.findProductByNameNotNull();
		assertEquals(5, list.size());
	}
}
