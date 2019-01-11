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

//告诉spring容器运行在虚拟机中
@RunWith(SpringJUnit4ClassRunner.class)
//配置文件的位置
//若当前配置文件名=当前测试类名-context.xml 就可以在当前目录中查找@ContextConfiguration()
@ContextConfiguration("classpath:spring/servlet-context.xml")
public class WebSocketTest {
	
	@Autowired
	private MyThread myThread;
	
	
	@Test
	public  void test(){
		myThread.asdas();
		System.out.println("---------------------");
		if(myThread==null){
			System.out.println("为空");

			System.out.println("不要为空");
			Thread thread=new Thread(myThread);
			//thread.run();
			thread.start();
		}
	}
	

}
