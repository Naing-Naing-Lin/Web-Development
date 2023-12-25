package com.jdc.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.jdc.dao", "com.jdc.factory"})
@PropertySource({"classpath:/database.properties", "/query.properties"})
public class ApplicationConfig {
	
	@Value("${db.driverClassName}")
	private String driverClassName;
	@Value("${db.url}")
	private String url;
	@Value("${db.user}")
	private String user;
	@Value("${db.password}")
	private String password;
	
	
//	@Bean
//	public DataSource dataSource() {
//		
//		var dataSource = new BoneCPDataSource();
//		dataSource.setJdbcUrl(url);
//		dataSource.setUsername(user);
//		dataSource.setPassword(password);
//		
//		return dataSource;
//	}
	
	@Bean
	public DataSource dataSource() {
		
		var dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		
		return dataSource;
	}
	
	@Bean
	public JdbcOperations template(DataSource ds) {
				
		return new JdbcTemplate(ds, true);
	}

}
