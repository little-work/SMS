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
	 * ��Ӧ�̹���
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
			logger.error("��ѯ��Ӧ���쳣",e.toString());
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
			result.put(true, "��ӹ�Ӧ�̳ɹ�");
			return result;
		} catch (Exception e) {
			result.put(false, "��ӹ�Ӧ���쳣");
			logger.error("��ӹ�Ӧ���쳣",e.toString());
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
			result.put(true, "�޸Ĺ�Ӧ�̳ɹ�");
			return "ok";
		} catch (Exception e) {
			result.put(false, "�޸Ĺ�Ӧ���쳣");
			logger.error("�޸Ĺ�Ӧ���쳣",e.toString());
			return "�޸Ĺ�Ӧ���쳣";
		}
		
	}
	
	
	@RequestMapping(value = "/deleteSupplier")
	@ResponseBody
	public String deleteSupplier(String supplierID){
		try {
			supplierServiceImpl.deleteSupplier(supplierID);
			return "ok";
		} catch (Exception e) {
			logger.error("ɾ���쳣",e);
			return "ɾ����Ӧ���쳣";
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
			logger.error("��ѯ��Ӧ��ʧ��",e);
			return backresult;
		}
	}
	
}
