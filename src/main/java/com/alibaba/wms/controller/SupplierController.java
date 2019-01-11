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
import com.alibaba.wms.bean.Supplier;
import com.alibaba.wms.services.impl.SupplierServiceImpl;

@Controller
public class SupplierController {

	
	private static final Logger logger = LoggerFactory.getLogger(SupplierController.class);
	
	@Autowired
	private SupplierServiceImpl supplierServiceImpl;
	

	/**
	 * 供应商管理
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/supplier")
	public String stock() {
		return "/pages/supplier";
	}
	
	@RequestMapping(value = "/queryAllSupplierInfo")
	@ResponseBody
	public BackResult<Supplier> queryAllSupplier(int limit,int offset,String queryParamTest) {
		
		System.out.println(limit+"-"+((offset/limit)+1)+"-"+"-"+queryParamTest);
		List<Supplier> list=null;
		BackResult<Supplier> backResult=null;
		
		try {
			list=new ArrayList<Supplier>();
			backResult=new BackResult<Supplier>();
			list=supplierServiceImpl.queryAllSupplier();
			backResult.setTotal(list.size());
			backResult.setRows(list);
			return backResult;
		} catch (Exception e) {
			logger.error("查询供应商异常",e.toString());
			return backResult;
		}
	}
	
	@RequestMapping(value = "/addSupplier")
	@ResponseBody
	public Map<Boolean,String> addSupplier(String supplierName,String contacts,String contactsPhone){
		Map<Boolean,String> result =null;
		
		try {
			result =new HashMap<Boolean, String>();
			supplierServiceImpl.addSupplier(supplierName,contacts,contactsPhone);
			result.put(true, "添加供应商成功");
			return result;
		} catch (Exception e) {
			result.put(false, "添加供应商异常");
			logger.error("添加供应商异常",e.toString());
			return result;
		}
		
	}
	
	
	@RequestMapping(value = "/editSupplier")
	@ResponseBody
	public String editSupplier(String supplierNameEdit,String contactsEdit,String contactsPhoneEdit,String supplierID){
		Map<Boolean,String> result =null;
		
		try {
			result =new HashMap<Boolean, String>();
			supplierServiceImpl.editSupplier(supplierNameEdit, contactsEdit, contactsPhoneEdit, supplierID);
			result.put(true, "修改供应商成功");
			return "ok";
		} catch (Exception e) {
			result.put(false, "修改供应商异常");
			logger.error("修改供应商异常",e.toString());
			return "修改供应商异常";
		}
		
	}
	
	
	@RequestMapping(value = "/deleteSupplier")
	@ResponseBody
	public String deleteSupplier(String supplierID){
		try {
			supplierServiceImpl.deleteSupplier(supplierID);
			return "ok";
		} catch (Exception e) {
			logger.error("删除异常",e);
			return "删除供应商异常";
		}
		
	}
	
	@RequestMapping(value = "/querySupplierByCondition")
	@ResponseBody
	public BackResult<Supplier> querySupplierByCondition(String queryDate,String querycontacts, String querySupplier){
		BackResult<Supplier> backresult=null;
		
		try {
			List<Supplier> list =supplierServiceImpl.querySupplierByCondition(queryDate, querycontacts, querySupplier);
			backresult=new BackResult<Supplier>();
			backresult.setTotal(list.size());
			backresult.setRows(list);
			return backresult;
		} catch (Exception e) {
			logger.error("查询供应商失败",e);
			return backresult;
		}
	}
	
}
