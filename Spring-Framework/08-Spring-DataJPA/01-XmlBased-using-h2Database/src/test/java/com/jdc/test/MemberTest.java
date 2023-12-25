package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.entity.Member;
import com.jdc.repo.MemberRepo;

@SpringJUnitConfig(locations = "/application.xml")
@TestMethodOrder(OrderAnnotation.class)
public class MemberTest {

	@Autowired
	MemberRepo repo;
	
	@ParameterizedTest
	@CsvSource("Andrew, admin, 123")
	@Order(1)
	void create(String name, String loginId, String password) {
		
		var m = repo.save(new Member(name, loginId, password));
		assertNotNull(m);
	}
	
	@ParameterizedTest
	@CsvSource("Mg Mg, admin, 123")
	@Order(2)
	void update(String name, String loginId, String password) {
		
		var m = repo.findById(1).get();
		assertNotNull(m);
		
		m.setName(name);
		m.setLoginId(loginId);
		m.setPassword(password);
		m = repo.save(m);
		assertEquals("Mg Mg", m.getName());
	}
	
	@Test
	@Sql(statements = {
			"insert into member (name, loginId, password) values ('aaa', 'aaa', '111')",
			"insert into member (name, loginId, password) values ('bbb', 'bbb', '222')",
			"insert into member (name, loginId, password) values ('ccc', 'ccc', '333')"
	})
	
	@Order(3)
	void findAll() {
		var list = repo.findAll();
		assertEquals(4, list.size());
		
		var listWithId = repo.findAllById(List.of(2,3,4));
		assertEquals(3, listWithId.size());
	}
	
	@Test
	@Order(4)
	void saveAll() {
		var list = repo.saveAll(List.of(
				new Member("Aye Aye", "User", "12345"),
				new Member("Bo Bo", "Admin", "67890")));
		
		assertEquals(2, list.size());
	}
	
	@Test
	@Order(5)
	void delete() {
		var m1 = new Member("ccc", "ccc", "333");
		m1.setId(4);
		repo.delete(m1);
		assertEquals(5, repo.findAll().size());
		
		repo.deleteById(3);
		assertEquals(4, repo.findAll().size());
		
		repo.deleteAllById(List.of(2,5,6));
		assertEquals(1, repo.findAll().size());
	}
}
