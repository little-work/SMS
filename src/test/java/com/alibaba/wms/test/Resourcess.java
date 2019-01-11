package com.alibaba.wms.test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;

public class Resourcess {

	public static void main(String[] args) throws IOException, URISyntaxException {
		
		System.out.println(Resourcess.class.getResource(""));
		System.out.println(Resourcess.class.getResource("/"));
		System.out.println(Resourcess.class.getResource("rwe.class"));
		System.out.println(Resourcess.class.getResource("/com/alibaba/wms/test/Resourcess.class"));
		System.out.println(Resourcess.class.getResource("/com/alibaba/wms/util/Test.txt"));
		
		System.out.println(Resourcess.class.getClassLoader().getResource("com/alibaba/wms/util/Test.txt"));
		
		/*InputStream is=Resourcess.class.getResourceAsStream("Test.txt");
		
		ByteArrayOutputStream bot=new ByteArrayOutputStream();
		
		int i=0;
		byte[] arr=new byte[1024];
		while((i=is.read(arr))!=-1){
			bot.write(arr, 0, i);
		}
		System.out.println(bot.toString("UTF-8"));*/
	}
	
}
