package com.alibaba.wms.dao;

import org.apache.ibatis.annotations.Param;

import com.alibaba.wms.bean.TestsssBean;
import com.alibaba.wms.bean.User;

public interface LoginRegistDao {
	

	
	/**
	 * ���û�ע�����Ϣ���뵽���ݿ���  ��δʵ�ָù���
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	public void entryUser(String username,String password,String phone) throws Exception;
	
	/**
	 * �����û�������������û��治����  ������ڻ�ȡ����û�����Ϣ
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(@Param("username")String username,@Param("password")String password)throws Exception;
	
	
	/**
	 * �����ʽ����������websocketʵʱ��ȡ���ݵ�
	 * @return
	 */
	public TestsssBean websocketGetData();
	public int countNum();
	
	
	
}
