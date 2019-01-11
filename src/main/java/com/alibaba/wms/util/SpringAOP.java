package com.alibaba.wms.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.wms.bean.Log;
import com.alibaba.wms.dao.GoodsDao;

//��������һ������Bean
@Component
@Aspect
public class SpringAOP {
	
	
	
	@Autowired
	private GoodsDao goodsDao;

	@Pointcut("execution(* com.alibaba.wms.controller.*.*(..))")  
    private void anyMethod(){}//����һ�������  
      
    @Before("anyMethod() && args(name)")     //���Ҫ������������������淽������ִ��
    public void doAccessCheck(String name){  
        System.out.println(name);  
        System.out.println("ǰ��֪ͨ");  
    }  
      
    @AfterReturning("anyMethod()")  
    public void doAfter(){  
        System.out.println("����֪ͨ");  
    }  
      
    @After("anyMethod()")  
    public void after(){  
        System.out.println("����֪ͨ");  
    }  
      
    @AfterThrowing("anyMethod()")  
    public void doAfterThrow(){  
        System.out.println("����֪ͨ");  
    }  
      
    @Around("anyMethod()")  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{ 
    	
    	 Object object = pjp.proceed();//ִ�и÷���  
    	 HttpServletRequest request = 
    			 ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
    	 
    	 //�������·��
    	 String path=request.getServletPath();
    	 String ip=request.getRemoteAddr();
    	 
    	 HttpSession session = request.getSession(); 
    	 //��¼���û���
    	 String username=(String) session.getAttribute("username");
    	 
    	 if(username==null){
    		 return object;
    	 }else{
    		 Log log=new Log();
        	 
    	    	log.setLog_serial(MD5.MD5Util());
    	    	log.setUser_name(username);
    	    	log.setUser_ip(ip);
    	    	log.setRecord_time(TimeUtil.getformatCurrentTime(TimeUtil.DATE_TIME_PATTERN,new Date()));
    	    	log.setRecord_status(0);
    	    	log.setOp_name(AddressMapping.map.get(path));
    	    	
    	    	goodsDao.insertLog(log);
    	    	
    	       
    	        return object; 
    	 }
    	 
    	 
    	 
    	 
    }  
}
