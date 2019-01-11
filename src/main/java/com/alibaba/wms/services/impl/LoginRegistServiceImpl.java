package com.alibaba.wms.services.impl;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.wms.bean.User;
import com.alibaba.wms.dao.LoginRegistDao;
import com.alibaba.wms.services.LoginRegistService;


@Service
public class LoginRegistServiceImpl implements LoginRegistService {
	
	@Autowired
	private LoginRegistDao loginRegistDao;
	

	@Override
	public void entryUser(String username, String password, String phone) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User checkUser(String username, String password) throws Exception {
		return loginRegistDao.checkUser(username, DigestUtils.md5Hex(password));
	}
	
	
	
}
