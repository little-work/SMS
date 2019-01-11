package com.alibaba.wms.services;

import java.util.List;

import com.alibaba.wms.bean.Supplier;


public interface SupplierService {

	
	
	/**
	 * 查找所有的供应商
	 * @return
	 */
	public List<Supplier> queryAllSupplier() throws Exception;
	/**
	 * 添加供应商
	 * @param supplier
	 */
	public void addSupplier(String supplierName,String contacts,String contactsPhone);
	
	/**
	 * 编辑供应商
	 * @param supplier
	 */
	public void editSupplier(String supplierName, String contacts, String contactsPhone,String supplierID);
	
	/**
	 * 删除供应商
	 * @param supplierID
	 * @return
	 */
	public String deleteSupplier(String supplierID);
	
	/**
	 * 根据条件查询供应商
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<Supplier> querySupplierByCondition(String queryDate,String querycontacts, String querySupplier);
	
}
