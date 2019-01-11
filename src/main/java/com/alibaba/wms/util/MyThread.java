package com.alibaba.wms.util;

import com.alibaba.wms.dao.LoginRegistDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class MyThread implements Runnable {
	

	
	
	@Autowired
	LoginRegistDao loginRegistDao;
	

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"...."+loginRegistDao.countNum());
	}
	
	public void asdas(){
		System.out.println(Thread.currentThread().getName()+"...."+loginRegistDao.countNum());
	}

}
