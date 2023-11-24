package com.jdc.fileSystemXml.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.jdc.beans.HelloBean;



public class FileSystemXmlTest {

	@Test
	void filePathTest() {
		
		// FileSystemXmlApplicationContext supports multiple refresh
		// it is used when xml configuration file exists in file path not in class path('src/main/resources')
		
		try(var context = new FileSystemXmlApplicationContext("file:context1.xml")){
			
			var bean = context.getBean(HelloBean.class);
			bean.greet();
		}
	}
}
