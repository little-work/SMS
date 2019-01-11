package com.alibaba.wms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.wms.bean.Cost;
import com.alibaba.wms.bean.OpenCourse;

@Repository
public interface OpenCourseDao {

	
	/**
	 * �������п���Ŀγ�
	 * @return
	 */
	public List<OpenCourse> queryAllOpenedCourse() throws Exception;
	
	
	/**
	 * ��ӿγ���Ϣ���γ̱���
	 * @param openCourse
	 */
	public void addCourse(OpenCourse openCourse) throws Exception;
	
	
	/**
	 * ��ӷ�����Ϣ�����ñ���
	 * @param cost
	 */
	public void addCost(Cost cost) throws Exception;
	
	
	
}
