package com.alibaba.wms.test;

public class ClassForNameDemo {

	static{
		System.out.println("��̬�����ִ����");
	}
	
	{
		System.out.println("�Ǿ�̬�����ִ����");
	}
	
	
	public ClassForNameDemo(){
		System.out.println("���캯��ִ����");
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
