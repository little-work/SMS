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

//声明这是一个切面Bean
@Component
@Aspect
public class SpringAOP {
	
	
	
	@Autowired
	private GoodsDao goodsDao;

	@Pointcut("execution(* com.alibaba.wms.controller.*.*(..))")  
    private void anyMethod(){}//定义一个切入点  
      
    @Before("anyMethod() && args(name)")     //这个要满足两个条件这个切面方法才能执行
    public void doAccessCheck(String name){  
        System.out.println(name);  
        System.out.println("前置通知");  
    }  
      
    @AfterReturning("anyMethod()")  
    public void doAfter(){  
        System.out.println("后置通知");  
    }  
      
    @After("anyMethod()")  
    public void after(){  
        System.out.println("最终通知");  
    }  
      
    @AfterThrowing("anyMethod()")  
    public void doAfterThrow(){  
        System.out.println("例外通知");  
    }  
      
    @Around("anyMethod()")  
    public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable{ 
    	
    	 Object object = pjp.proceed();//执行该方法  
    	 HttpServletRequest request = 
    			 ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest(); 
    	 
    	 //请求相对路径
    	 String path=request.getServletPath();
    	 String ip=request.getRemoteAddr();
    	 
    	 HttpSession session = request.getSession(); 
    	 //登录的用户名
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
