package com.jdc;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.beans.MyClient;


@Configuration
public class MyConfigs {

	@Bean
	public MyClient getBean() {
		return new MyClient();
	}
	
	@Bean
	Date currentDate() {
		return new Date();
	}
}
