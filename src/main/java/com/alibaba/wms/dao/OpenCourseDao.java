package com.alibaba.wms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.wms.bean.Cost;
import com.alibaba.wms.bean.OpenCourse;

@Repository
public interface OpenCourseDao {

	
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
