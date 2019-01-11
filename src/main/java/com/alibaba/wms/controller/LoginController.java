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
	 * ��������  �����¼����
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	
	
	/**
	 * ��������������֤��ͼƬ
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value ="/getImage")  
    public void createCode(HttpServletRequest request, HttpServletResponse response){ 
		
		try {
			logger.info("����������֤�롣������");
	        // ֪ͨ�������Ҫ����  
	        response.setHeader("Expires", "-1");  
	        response.setHeader("Cache-Control", "no-cache");  
	        response.setHeader("Pragma", "-1");  
	        CaptchaUtil util = CaptchaUtil.Instance();  
	        // ����֤�����뵽session�У�������֤  
	        String code = util.getString();
	        AUTH_CODE=code;
	        request.getSession().setAttribute("code", code);
	        System.out.println("�õ�����֤Ҫ�ǣ�"+code+"����");
	        // �����webҳ��  
	        ImageIO.write(util.getImage(), "jpg", response.getOutputStream());
		} catch (IOException e) {
			logger.error("������֤���쳣",e);
		}
		
		  
    }  
	/**
	 * ��ת����ҳ��
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
	 * ��ȡҳ����������ݽ��е�¼����
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/toLogin")
	@ResponseBody
	public Map<Boolean,String> toLogin(HttpSession session,HttpServletRequest request,String username,String password,String code) {
		
		Map<Boolean,String> result =new HashMap<Boolean, String>();
		User user=null;
		try {
			logger.info("���ڵ�½��������");
			logger.debug("��¼�С�������");
			//�鿴��֤���ǲ�����ȷ
			if(AUTH_CODE.equalsIgnoreCase(code)){
				//�����¼�ɹ�  ���û�������sesion��
				
				user=loginRegistServiceImpl.checkUser(username, password);
					   if(user!=null){
						   System.out.println(username+"..."+password);
						   //��¼�ɹ����û���Ϣ��sessionID����session��
						   String sessionID=session.getId();
						   session.setAttribute("username",username);
						   session.setAttribute("sessionID", sessionID);
						   
						/*  //��¼��webSession
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
							   result.put(true, "��¼�ɹ�");
								return result;
						   }else{
							   result.put(false, "���û��Ѿ���¼");
								return result;
						   }*/
						   result.put(true, "��¼�ɹ�");
							return result;
						   
					   }else{
						   result.put(false, "�û��������������");
							return result;
					   }
			}else{
				result.put(false, "��֤�����");
				return result;
			}
		} catch (Exception e) {
			logger.error("��¼ʧ��",e.toString());
			result.put(false, "��¼�쳣");
			return result;
		}
		
	
		
		
		
		
	}   
	
	
	
	
}
