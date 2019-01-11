package com.alibaba.wms.services;

import java.util.List;

import com.alibaba.wms.bean.Supplier;


public interface SupplierService {

	
	
	/**
	 * �������еĹ�Ӧ��
	 * @return
	 */
	public List<Supplier> queryAllSupplier() throws Exception;
	/**
	 * ��ӹ�Ӧ��
	 * @param supplier
	 */
	public void addSupplier(String supplierName,String contacts,String contactsPhone);
	
	/**
	 * �༭��Ӧ��
	 * @param supplier
	 */
	public void editSupplier(String supplierName, String contacts, String contactsPhone,String supplierID);
	
	/**
	 * ɾ����Ӧ��
	 * @param supplierID
	 * @return
	 */
	public String deleteSupplier(String supplierID);
	
	/**
	 * ����������ѯ��Ӧ��
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<Supplier> querySupplierByCondition(String queryDate,String querycontacts, String querySupplier);
	
}
