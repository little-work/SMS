package com.alibaba.wms.util;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {
	
	public static void main(String[] args) {
		//System.out.println(System.currentTimeMillis());
		//System.out.println(MD5.MD5Util());
		System.out.println(DigestUtils.md5Hex("2018-10-31 22:56:00"));
	}
	
	public static  String MD5Util(){
		
		return DigestUtils.md5Hex(String.valueOf(System.currentTimeMillis()));
	}

}