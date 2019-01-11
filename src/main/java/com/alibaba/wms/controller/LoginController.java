package com.alibaba.wms.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.wms.bean.User;
import com.alibaba.wms.dao.GoodsDao;
import com.alibaba.wms.services.impl.LoginRegistServiceImpl;
import com.alibaba.wms.util.CaptchaUtil;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	private String AUTH_CODE;
	
	@Autowired
	private LoginRegistServiceImpl loginRegistServiceImpl;
	
	@Autowired
	private GoodsDao goodsDao;
	
	/**
	 * 程序的入口  进入登录界面
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	
	
	/**
	 * 服务器端生成验证码图片
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value ="/getImage")  
    public void createCode(HttpServletRequest request, HttpServletResponse response){ 
		
		try {
			logger.info("正在生成验证码。。。。");
	        // 通知浏览器不要缓存  
	        response.setHeader("Expires", "-1");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setHeader("Pragma", "-1");  
	        CaptchaUtil util = CaptchaUtil.Instance();  
	        // 将验证码输入到session中，用来验证  
	        String code = util.getString();
	        AUTH_CODE=code;
	        request.getSession().setAttribute("code", code);
	        System.out.println("得到的验证要是："+code+"才行");
	        // 输出打web页面  
	        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
		} catch (IOException e) {
			logger.error("生成验证码异常",e);
		}
		
		  
    }  
	/**
	 * 跳转到主页面
	 * @return
	 */
	@RequestMapping(value = "/main")
	public String main() {
		return "main";
		
	}   
	/**
	 * 
	 */
	@RequestMapping(value = "/loginout")
	public String loginout(HttpSession session) {
		
		goodsDao.deleteWebSession((String)session.getAttribute("username"));
		
		return "loginout";
		
	}   
	
	/**
	 * 获取页面表单传来数据进行登录请求
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/toLogin")
	@ResponseBody
	public Map<Boolean,String> toLogin(HttpSession session,HttpServletRequest request,String username,String password,String code) {
		
		Map<Boolean,String> result =new HashMap<Boolean, String>();
		User user=null;
		try {
			logger.info("正在登陆。。。。");
			logger.debug("登录中。。。。");
			//查看验证码是不是正确
			if(AUTH_CODE.equalsIgnoreCase(code)){
				//如果登录成功  把用户名放在sesion中
				
				user=loginRegistServiceImpl.checkUser(username, password);
					   if(user!=null){
						   System.out.println(username+"..."+password);
						   //登录成功把用户信息和sessionID放在session中
						   String sessionID=session.getId();
						   session.setAttribute("username",username);
						   session.setAttribute("sessionID", sessionID);
						   
						/*  //登录的webSession
						   WebSession websession=new WebSession();
						   websession.setIP(request.getRemoteAddr());
						   websession.setLogin_time(TimeUtil.getformatCurrentTime(TimeUtil.DATE_TIME_PATTERN,new Date()));
						   websession.setSession_id(sessionID);
						   websession.setOp_name(username);
						   websession.setTimeout(30);
						   int num=goodsDao.countWebSession(username);
						   
						   System.out.println(";;;;"+num);
						   
						   if(num==0){
							   goodsDao.insertWebSession(websession);
							   result.put(true, "登录成功");
								return result;
						   }else{
							   result.put(false, "该用户已经登录");
								return result;
						   }*/
						   result.put(true, "登录成功");
							return result;
						   
					   }else{
						   result.put(false, "用户名或者密码错误");
							return result;
					   }
			}else{
				result.put(false, "验证码错误");
				return result;
			}
		} catch (Exception e) {
			logger.error("登录失败",e.toString());
			result.put(false, "登录异常");
			return result;
		}
		
	
		
		
		
		
	}   
	
	
	
	
}
