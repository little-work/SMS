package com.alibaba.wms.services;

import com.alibaba.wms.bean.User;


public interface LoginRegistService {

	
	public void entryUser(String username,String password,String phone) throws Exception;
	
	
	/**
	 * �����û�������������û��治����  ������ڻ�ȡ����û�����Ϣ
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(String username,String password)throws Exception;
	
	
}
