package com.jdc.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return new Class<?>[] {};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		return new Class<?>[] {
			AppConfig.class
		};
	}

	@Override
	protected String[] getServletMappings() {

		return new String[] {"/"};
	}

}
