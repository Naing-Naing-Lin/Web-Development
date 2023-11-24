package com.jdc.demo.configs;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan({
	"com.jdc.demo.service",
	"com.jdc.demo.aspects"
})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class MyConfig {

}
