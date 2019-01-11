package com.alibaba.wms.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EnterschoolController {
	
	private static final Logger logger = LoggerFactory.getLogger(EnterschoolController.class);

	
	/**
	 * 打开学生录入界面
	 */
	@RequestMapping(value = "/enterschool")
	public String enterschool() {
		logger.info("正在打开学生录入界面");
		return "/pages/enterschool";
	}
	
	
}
