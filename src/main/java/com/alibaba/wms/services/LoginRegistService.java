package com.alibaba.wms.services;

import com.alibaba.wms.bean.User;


public interface LoginRegistService {

	
	public void entryUser(String username,String password,String phone) throws Exception;
	
	
	/**
	 * 根据用户和密码检查这个用户存不存在  如果存在获取这个用户的信息
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String username,String password)throws Exception;
	
	
}
