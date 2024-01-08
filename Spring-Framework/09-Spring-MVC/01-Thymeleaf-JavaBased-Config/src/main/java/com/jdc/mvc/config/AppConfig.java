package com.jdc.mvc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan("com.jdc.mvc.controller")
public class AppConfig implements WebMvcConfigurer{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setPrefix("/views/");
		templateResolver.setSuffix(".html");
		templateResolver.setCacheable(false);
		
		return templateResolver;
	}
	
	@Bean
	SpringTemplateEngine templateEngine(SpringResourceTemplateResolver templateResolver) {
		var templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		
		return templateEngine;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine templateEngine) {
		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine);
		
		return viewResolver;
	}
}
