package com.alibaba.wms.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeUtil {

	
	public static final String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    public static final String HOUR_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_PATTERN = "yyyy-MM-dd";
    public static final String MONTH_PATTERN = "yyyy-MM";
    public static final String YEAR_PATTERN = "yyyy";
    public static final String MINUTE_ONLY_PATTERN = "mm";
    public static final String HOUR_ONLY_PATTERN = "HH";
	 
   
    public static String getformatCurrentTime(String format,Date date){
        SimpleDateFormat format0 = new SimpleDateFormat(format);  
        String time = format0.format(date.getTime());//这个就是把时间戳经过处理得到期望格式的时间  
        return time;
    }
    
    
    
	 public static void main(String[] args) {
		 System.out.println(getformatCurrentTime(DATE_TIME_PATTERN,new Date()));
	}
	
}
