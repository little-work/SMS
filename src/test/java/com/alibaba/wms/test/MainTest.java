package com.alibaba.wms.test;

import java.lang.reflect.Method;

@MyAnnotation(value="213")
public class MainTest {

	
	
	
	public static void main(String[] args) {
		try {
			revosle();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static  void revosle() throws Exception, SecurityException{
		
		Method method = MainTest.class.getMethod("revosle",null);
		if(MainTest.class.isAnnotationPresent(MyAnnotation.class))  
		  {  
		   System.out.println(method.getAnnotation(MyAnnotation.class));  
		  }  
		
	}
	
	
}
