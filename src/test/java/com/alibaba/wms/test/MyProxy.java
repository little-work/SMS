package com.alibaba.wms.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.alibaba.wms.implement.PersonImpl;
import com.alibaba.wms.testInterface.Person;

public class MyProxy {
	
	private Object target;
	
	public MyProxy(Object target){
		this.target=target;
	}


	public Object getProxy(){
		return  Proxy.newProxyInstance(MyProxy.class.getClassLoader(), 
				target.getClass().getInterfaces(), new InvocationHandler(){

					@Override
					public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
						System.out.println("before");
						System.out.println(method.getName());
						Object result = method.invoke(target, args);  
						System.out.println("after");
						return result;
					}
			
		});
	}
	
	
	public static void main(String[] args) {
		MyProxy myProxy=new MyProxy(new PersonImpl());
		Person proxy=(Person)myProxy.getProxy();
		proxy.action();
	}
}
