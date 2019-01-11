package com.alibaba.wms.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

import com.alibaba.wms.testBean.User;


public class SpringRegistBean implements BeanDefinitionRegistryPostProcessor{

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
		GenericBeanDefinition definition = new GenericBeanDefinition();
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition(User.class);
        definition.setBeanClass(User.class);    //设置类
        definition.setScope("singleton");       //设置scope
        definition.setLazyInit(false);          //设置是否懒加载
        definition.setAutowireCandidate(true);  //设置是否可以被其他对象自动注入
        registry.registerBeanDefinition("user", definition);
        
		
	}
	
	
	
}
