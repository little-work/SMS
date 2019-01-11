package com.alibaba.wms.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.wms.bean.BackResult;
import com.alibaba.wms.bean.Cost;
import com.alibaba.wms.bean.OpenCourse;
import com.alibaba.wms.bean.Supplier;
import com.alibaba.wms.services.impl.OpenCourseServiceImpl;
import com.alibaba.wms.util.MD5;

@Controller
public class OpenCourseController {
	
	private static final Logger logger = LoggerFactory.getLogger(OpenCourseController.class);
	
	@Autowired
	private OpenCourseServiceImpl  openCourseServiceImpl;
	
	
	/**
	 * �򿪿γ�¼�����
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/openCourse")
	public String openCourse() {
		return "/pages/openCourse";
	}
	
	/**
	 * ��ѯ���п���Ŀγ�
	 * @param limit
	 * @param offset
	 * @return
	 */
	
	@RequestMapping(value = "/queryAllOpenedCourse")
	@ResponseBody
	public BackResult<OpenCourse> queryAllSupplier(int limit,int offset) {
		
		//System.out.println(limit+"-"+((offset/limit)+1)+"-"+"-");
		List<OpenCourse> list=null;
		BackResult<OpenCourse> backResult=null;
		
		
		try {
			list=new ArrayList<OpenCourse>();
			backResult=new BackResult<OpenCourse>();
			list=openCourseServiceImpl.queryAllOpenedCourse();
			backResult.setTotal(list.size());
			backResult.setRows(list);
			return backResult;
		} catch (Exception e) {
			logger.error("��ѯ��Ӧ���쳣",e.toString());
			return backResult;
		}
	}
	
	
	
	/**
	 * ��ӿγ�
	 * @param openCourse
	 * @param cost
	 * @return
	 */
	@RequestMapping(value = "/addCourse")
	@ResponseBody
	public  Map<Boolean,String> addCourse(OpenCourse openCourse,Cost cost){
		
		Map<Boolean,String> result =new HashMap<Boolean,String>();
		try {
			String course_id=MD5.MD5Util();
			openCourse.setCourse_id(course_id);
			cost.setCourse_id(course_id);
			
			
			openCourseServiceImpl.addCourse(openCourse);
			openCourseServiceImpl.addCost(cost);
			result.put(true, "��ӳɹ�");
			return result;
		} catch (Exception e) {
			logger.error("��ӿγ�ʧ��",e);
			result.put(false, "���ʧ��");
			return result;
		
		}
	}
	
	
	
	
	
	
	

}
