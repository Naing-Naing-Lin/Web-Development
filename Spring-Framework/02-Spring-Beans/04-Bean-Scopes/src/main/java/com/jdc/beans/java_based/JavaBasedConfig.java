package com.jdc.beans.java_based;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaBasedConfig {

	@Bean(initMethod = "initBean")
	@Scope // default scope is singleton scope
	@Lazy(true) // just to create object when call getBean(). Not to create object whenever refresh.
	public JavaBean javaBean() {
		return new JavaBean();
	}
}
