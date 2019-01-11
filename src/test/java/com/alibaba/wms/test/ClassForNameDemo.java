package com.alibaba.wms.test;

public class ClassForNameDemo {

	static{
		System.out.println("静态代码块执行了");
	}
	
	{
		System.out.println("非静态代码块执行了");
	}
	
	
	public ClassForNameDemo(){
		System.out.println("构造函数执行了");
	}
	
	
	public static void main(String[] args) throws IllegalAccessException {
		try {
			Class z=Class.forName("com.alibaba.wms.test.ClassForNameDemo");
			System.out.println(z.getName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
