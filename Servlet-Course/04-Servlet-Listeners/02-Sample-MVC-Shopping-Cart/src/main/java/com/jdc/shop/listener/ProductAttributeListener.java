package com.jdc.shop.listener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.jdc.shop.model.ProductModel;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class ProductAttributeListener implements ServletContextAttributeListener{

	@Override
	public void attributeAdded(ServletContextAttributeEvent event) {
		var value = event.getValue();
		
		if(value instanceof ProductModel) {
			var name = event.getName();
			
			event.getServletContext().log(String.format("Product Model is created at %s", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:MM:SS"))));
			event.getServletContext().log(String.format("Attribute name is %s", name));
			
			ProductModel model = (ProductModel)value;
			event.getServletContext().log(String.format("Product count is %s", model.getList().size()));
		}
	}
	
	@Override
	public void attributeRemoved(ServletContextAttributeEvent event) {
		
	}
	
	@Override
	public void attributeReplaced(ServletContextAttributeEvent event) {
		
	}
}
