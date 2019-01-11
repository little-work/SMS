package com.alibaba.wms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.wms.bean.Cost;
import com.alibaba.wms.bean.OpenCourse;
import com.alibaba.wms.dao.OpenCourseDao;
import com.alibaba.wms.services.OpenCourseSevice;

@Service
public class OpenCourseServiceImpl implements OpenCourseSevice {
	
	
	@Autowired
	private OpenCourseDao  openCourseDao;

	@Override
	public List<OpenCourse> queryAllOpenedCourse()throws Exception {
		
		return openCourseDao.queryAllOpenedCourse();
	}

	@Override
	public void addCourse(OpenCourse openCourse)throws Exception {
		openCourseDao.addCourse(openCourse);
	}

	@Override
	public void addCost(Cost cost)throws Exception {
		openCourseDao.addCost(cost);
	}

}
