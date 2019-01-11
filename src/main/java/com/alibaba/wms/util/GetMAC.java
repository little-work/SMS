package com.alibaba.wms.util;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Formatter;
import java.util.Locale;



public class GetMAC {

	public static String  getMAC(){
		try{  
            InetAddress address = InetAddress.getLocalHost();  
            NetworkInterface ni = NetworkInterface.getByInetAddress(address);  
            //ni.getInetAddresses().nextElement().getAddress();  
            byte[] mac = ni.getHardwareAddress();  
           // String sIP = address.getHostAddress();  
            String sMAC = "";  
            Formatter formatter = new Formatter();  
            for (int i = 0; i < mac.length; i++) {  
                sMAC = formatter.format(Locale.getDefault(), "%02X%s", mac[i],  
                        (i < mac.length - 1) ? "-" : "").toString();  
  
            }  
            return sMAC;  
        }catch(Exception e){  
            e.printStackTrace();  
        }
		return null;  
		
		
	}
	
	
	
	
}
