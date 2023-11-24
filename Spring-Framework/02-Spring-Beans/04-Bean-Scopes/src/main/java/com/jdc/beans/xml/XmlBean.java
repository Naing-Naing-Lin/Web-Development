package com.jdc.beans.xml;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class XmlBean implements InitializingBean, DisposableBean {

	// 3 Ways to initialize bean
	// 1
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Xml afterPropertiesSet()");

	}

	// 2
	@PostConstruct
	public void postConstruct() {
		System.out.println();
		System.out.println("Xml postConstruct()");
	}

	// 3
	public void initBean() {
		System.out.println("Xml Custom Init Method");
	}

	// 3 Ways to destroy bean
	// *** Cannot destroy bean in Prototype Scope
	// 1
	@Override
	public void destroy() throws Exception {
		System.out.println("Destroy by Disposable");
	}

	// 2
	@PreDestroy
	void preDestroy() {
		System.out.println("Destory by Pre-Destroy");
	}

	void destroyBean() {
		System.out.println("Custom Destroy Method");
		System.out.println();
		System.out.println("----------------------------------------------");
	}
}
