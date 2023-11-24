package com.jdc;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jdc.beans")
public class MyConfig {

	@Bean
	Date currentDate() {
		return new Date();
	}
}
