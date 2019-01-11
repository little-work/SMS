package com.alibaba.wms.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.wms.testBean.User;


public class StartSpringContext {

	
	public static void main(String[] args) {
		ApplicationContext  ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		User user=ac.getBean(User.class);
		user.say();
	}
}
