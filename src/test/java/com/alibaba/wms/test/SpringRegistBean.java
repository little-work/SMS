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
        definition.setBeanClass(User.class);    //������
        definition.setScope("singleton");       //����scope
        definition.setLazyInit(false);          //�����Ƿ�������
        definition.setAutowireCandidate(true);  //�����Ƿ���Ա����������Զ�ע��
        registry.registerBeanDefinition("user", definition);
        
		
	}
	
	
	
}
