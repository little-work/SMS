package com.alibaba.wms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.Supplier;

@Repository
public interface SupplierDao {

	
	/**
	 * 查找所有的供应商
	 * @return
	 */
	public List<Supplier> queryAllSupplier();
	
	/**
	 * 添加供应商
	 * @param supplier
	 */
	public void addSupplier(Supplier supplier);
	
	/**
	 * 编辑供应商
	 * @param supplier
	 */
	public void editSupplier(Supplier supplier);
	
	/**
	 * 删除供应商
	 * @param supplierID
	 * @return
	 */
	public void deleteSupplier(String supplierID);
	
	/**
	 * 根据条件查询供应商
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<Supplier> querySupplierByCondition(Supplier supplier);
	
}
