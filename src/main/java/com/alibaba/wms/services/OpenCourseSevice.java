package com.alibaba.wms.services;

import java.util.List;

import com.alibaba.wms.bean.Cost;
import com.alibaba.wms.bean.OpenCourse;

public interface OpenCourseSevice {

	/**
	 * 查找所有开设的课程
	 * @return
	 */
	public List<OpenCourse> queryAllOpenedCourse() throws Exception;
	
	/**
	 * 添加课程信息到课程表中
	 * @param openCourse
	 */
	public void addCourse(OpenCourse openCourse) throws Exception;
	
	
	/**
	 * 添加费用信息到费用表中
	 * @param cost
	 */
	public void addCost(Cost cost) throws Exception;
}
