package com.jdc.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.jdc.ApplicationConfig;
import com.jdc.entity.Member;
import com.jdc.repo.MemberRepo;

@SpringJUnitConfig(classes = ApplicationConfig.class)
public class MemberTest {

	@Autowired
	MemberRepo repo;
	
	@ParameterizedTest
	@CsvSource("Andrew, admin, 123")
	void create(String name, String loginId, String password) {
		
		var m = repo.save(new Member(name, loginId, password));
		
		assertNotNull(m);
	}
}
