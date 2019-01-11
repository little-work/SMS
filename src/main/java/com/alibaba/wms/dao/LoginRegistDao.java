package com.alibaba.wms.dao;

import org.apache.ibatis.annotations.Param;

import com.alibaba.wms.bean.TestsssBean;
import com.alibaba.wms.bean.User;

public interface LoginRegistDao {
	

	
	/**
	 * 把用户注册的信息插入到数据库中  暂未实现该功能
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception 
	 */
	public void entryUser(String username,String password,String phone) throws Exception;
	
	/**
	 * 根据用户和密码检查这个用户存不存在  如果存在获取这个用户的信息
	 * @param username
	 * @param password
	 * @return
	 * @throws Exception
	 */
	public User checkUser(@Param("username")String username,@Param("password")String password)throws Exception;
	
	
	/**
	 * 这个方式是用来测试websocket实时获取数据的
	 * @return
	 */
	public TestsssBean websocketGetData();
	public int countNum();
	
	
	
}
