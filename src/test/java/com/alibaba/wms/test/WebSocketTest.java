package com.alibaba.wms.
test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.wms.util.MyThread;

//����spring�����������������
@RunWith(SpringJUnit4ClassRunner.class)
//�����ļ���λ��
//����ǰ�����ļ���=��ǰ��������-context.xml �Ϳ����ڵ�ǰĿ¼�в���@ContextConfiguration()
@ContextConfiguration("classpath:spring/servlet-context.xml")
public class WebSocketTest {
	
	@Autowired
	private MyThread myThread;
	
	
	@Test
	public  void test(){
		myThread.asdas();
		System.out.println("---------------------");
		if(myThread==null){
			System.out.println("Ϊ��");

			System.out.println("��ҪΪ��");
			Thread thread=new Thread(myThread);
			//thread.run();
			thread.start();
		}
	}
	

}
