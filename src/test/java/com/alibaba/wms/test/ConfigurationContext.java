package com.alibaba.wms.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationContext {

	public ConfigurationContext(){
		System.out.println("Wryt����������");
	}
	
	public static void main(String[] args) {
		 ApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationContext.class);
	}
}
