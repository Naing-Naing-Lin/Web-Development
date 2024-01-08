package com.jdc.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

@Configuration
public class DatabaseConfig {

//	@Bean
//	JdbcOperations operation(DataSource dataSource) {
//		return new JdbcTemplate(dataSource);
//	}
	
	@Bean
	SimpleJdbcInsert jdbcInsert(DataSource dataSource) {
		return new SimpleJdbcInsert(dataSource);
	}
}
