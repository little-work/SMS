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
	
	//������¼��Ҫʵʱ��ȡ���ݿ�������ݵļ�¼��
	private int num;
	private int new_num;
	private boolean flag=true;
	
	public void stopThread(){
		flag=false;
	}
	
	@Override
	public void run(){
			
		if(loginRegistDao==null){
			System.out.println("Ϊ��");
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
					mws.sendMessage("���ݿ������"+String.valueOf(new_num));
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
