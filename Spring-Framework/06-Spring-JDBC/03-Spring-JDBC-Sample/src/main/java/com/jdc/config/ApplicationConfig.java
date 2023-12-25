package com.jdc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@PropertySource("datasource.properties")
public class ApplicationConfig {

	@Bean
	public DataSource dataSource(
			@Value("${db.driverClassName}") String driverClassName, 
			@Value("${db.url}") String url, 
			@Value("${db.username}") String username, 
			@Value("${db.password}") String password) {
		
		var dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public JdbcTemplate operations(DataSource dataSource) {
		return new JdbcTemplate(dataSource, true);
	}
	
	@Bean
	public SimpleJdbcInsert personInsert(JdbcTemplate template) {
		return new SimpleJdbcInsert(template).withTableName("person_tbl").usingGeneratedKeyColumns("id");
	}
}
