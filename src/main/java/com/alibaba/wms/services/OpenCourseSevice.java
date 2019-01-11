package com.alibaba.wms.services;

import java.util.List;

import com.alibaba.wms.bean.Cost;
import com.alibaba.wms.bean.OpenCourse;

public interface OpenCourseSevice {

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
