package com.alibaba.wms.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.wms.bean.Supplier;
import com.alibaba.wms.dao.SupplierDao;
import com.alibaba.wms.services.SupplierService;
import com.alibaba.wms.util.MD5;

@Service
public class SupplierServiceImpl implements SupplierService {
	
	
	@Autowired
	private SupplierDao supplierDao;

	@Override
	public List<Supplier> queryAllSupplier() throws Exception {
		return supplierDao.queryAllSupplier();
	}

	@Override
	public void addSupplier(String supplierName,String contacts,String contactsPhone) {
		Supplier supplier=new Supplier();
		supplier.setContacts(contacts);
		supplier.setContacts_phone(contactsPhone);
		supplier.setSupplier_name(supplierName);
		supplier.setSupplier_id(MD5.MD5Util());
		supplierDao.addSupplier(supplier);
		
	}

	@Override
	public void editSupplier(String supplierName, String contacts, String contactsPhone,String supplierID) {
		Supplier supplier=new Supplier();
		supplier.setContacts(contacts);
		supplier.setContacts_phone(contactsPhone);
		supplier.setSupplier_name(supplierName);
		supplier.setSupplier_id(supplierID);
		supplierDao.editSupplier(supplier);
		
	}

	@Override
	public String deleteSupplier(String supplierID) {
		supplierDao.deleteSupplier(supplierID);
		return null;
	}

	@Override
	public List<Supplier> querySupplierByCondition(String queryDate,String querycontacts, String querySupplier) {
		Supplier supplier=new Supplier();
		
		supplier.setEntry_time(queryDate);
		supplier.setContacts(querycontacts);
		supplier.setSupplier_name((querySupplier.equals("«Î—°‘Ò")) ? "" : querySupplier);
		supplierDao.querySupplierByCondition(supplier);
		return supplierDao.querySupplierByCondition(supplier);
	}

}
