package com.alibaba.wms.testBean;

public class User {

	
	private String username;
	private String password;
	private String age;
	
	public void say(){
		System.out.println("我是通过spring注册的");
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
