package com.alibaba.wms.services.impl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.alibaba.wms.bean.TestsssBean;
import com.alibaba.wms.controller.MyWebSocket;
import com.alibaba.wms.dao.LoginRegistDao;

@Service
public class GetLatestData extends Thread{

	
	@Autowired
	private LoginRegistDao loginRegistDao;
	
	TestsssBean tb=null;
	
	//用来记录需要实时获取数据库表中数据的记录数
	private int num;
	private int new_num;
	private boolean flag=true;
	
	public void stopThread(){
		flag=false;
	}
	
	@Override
	public void run(){
			
		if(loginRegistDao==null){
			System.out.println("为空");
			return;
		}
		
		num=loginRegistDao.countNum();
		MyWebSocket mws=new MyWebSocket();
		while(flag){
			new_num=loginRegistDao.countNum();
			
			if(num!=new_num){
				num=new_num;
				//tb=loginRegistDao.websocketGetData();
				try {
					mws.sendMessage("数据库更新了"+String.valueOf(new_num));
					try {
						this.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
}
