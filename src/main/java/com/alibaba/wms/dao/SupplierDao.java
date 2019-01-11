package com.alibaba.wms.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.Supplier;

@Repository
public interface SupplierDao {

	
	/**
	 * �������еĹ�Ӧ��
	 * @return
	 */
	public List<Supplier> queryAllSupplier();
	
	/**
	 * ��ӹ�Ӧ��
	 * @param supplier
	 */
	public void addSupplier(Supplier supplier);
	
	/**
	 * �༭��Ӧ��
	 * @param supplier
	 */
	public void editSupplier(Supplier supplier);
	
	/**
	 * ɾ����Ӧ��
	 * @param supplierID
	 * @return
	 */
	public void deleteSupplier(String supplierID);
	
	/**
	 * ����������ѯ��Ӧ��
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<Supplier> querySupplierByCondition(Supplier supplier);
	
}
