package com.jdc.beans.annotation;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Scope ("prototype")
public class AnnotationBean implements InitializingBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Annotation afterPropertiesSet");
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Annotation postConstruct");
	}
}
