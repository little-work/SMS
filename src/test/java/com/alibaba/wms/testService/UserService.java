package com.alibaba.wms.testService;

import com.alibaba.wms.testBean.User;

public class UserService {

	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public void test(){
		System.out.println(user.getUsername());
	}
	
	
}
