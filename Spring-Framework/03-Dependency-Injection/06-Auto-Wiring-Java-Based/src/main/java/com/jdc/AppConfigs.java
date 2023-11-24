package com.jdc;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jdc.beans.MainService;
import com.jdc.beans.MyClient;
import com.jdc.beans.ServiceImpl;

@Configuration
public class AppConfigs {

	@Bean
	MyClient myClient() {
		return new MyClient();
	}
	
	@Bean
	@Qualifier("mainService")
	//@Primary
	MainService mainService() {
		return new MainService();
	}
	
	@Bean
	@Qualifier("serviceImpl")
	ServiceImpl serviceImpl() {
		return new ServiceImpl();
	}
}
