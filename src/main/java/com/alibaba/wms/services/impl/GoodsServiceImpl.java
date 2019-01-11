package com.alibaba.wms.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.GoodsType;
import com.alibaba.wms.bean.Supplier;
import com.alibaba.wms.dao.GoodsDao;
import com.alibaba.wms.services.GoodsService;
import com.alibaba.wms.util.MD5;

@Service
public class GoodsServiceImpl implements GoodsService {

	private static final Logger logger = LoggerFactory.getLogger(GoodsServiceImpl.class);
	
	
	@Autowired
	private GoodsDao goodsDao;
	
	
	@Override
	public List<GoodsInfo> queryAllGoods() throws Exception {
		return  goodsDao.queryAllGoods();
	}


	@Override
	public void batchInsertGoods() {
		List<HashMap> list=new ArrayList<HashMap>();
		goodsDao.batchInsertGoods(list);
	}


	@Override
	public void addGoods(String goodsName,String goodsPrice,String goodsNumber,String goodsSupplier,String goodsTypeCode) throws Exception {
		GoodsInfo goodsInfo=new GoodsInfo();
		goodsInfo.setGoods_id(MD5.MD5Util());
		goodsInfo.setGoods_name(goodsName);
		goodsInfo.setGoods_price(Double.parseDouble(goodsPrice));
		goodsInfo.setGoods_number(Integer.parseInt(goodsNumber));
		goodsInfo.setGoods_supplier(goodsSupplier);
		goodsInfo.setGoods_type_code(Integer.parseInt(goodsTypeCode));
		goodsDao.addGoods(goodsInfo);
	}


	@Override
	public List<Supplier> queryAllSupplier() throws Exception {
		return goodsDao.queryAllSupplier();
	}

	@Override
	public List<GoodsType> queryAllGoodsType() throws Exception {
		return goodsDao.queryAllGoodsType();
	}


	@Override
	public void editGoods(String goodsNameEdit,String goodsPriceEdit,String goodsNumberEdit,
			String goodsSupplierEdit,String goodsTypeCodeEdit,String goodsID) throws Exception {
		
		GoodsInfo goodsInfo=new GoodsInfo();
		
		goodsInfo.setGoods_id(goodsID);
		goodsInfo.setGoods_name(goodsNameEdit);
		goodsInfo.setGoods_price(Double.parseDouble(goodsPriceEdit));
		goodsInfo.setGoods_number(Integer.parseInt(goodsNumberEdit));
		goodsInfo.setGoods_supplier(goodsSupplierEdit);
		goodsInfo.setGoods_type_code(Integer.parseInt(goodsTypeCodeEdit));
		
		goodsDao.editGoods(goodsInfo);
			
		
	}


	@Override
	public void deleteGoods(String goodsid) throws Exception {
		goodsDao.deleteGoods(goodsid);
	}


	@Override
	public List<GoodsInfo> queryGoodsByCondition(String queryDate,String queryGoodsSupplier, String queryGoodsTypeCode) throws Exception {
		
		GoodsInfo goodsInfo=new GoodsInfo();
		
		goodsInfo.setStore_time(queryDate);
		goodsInfo.setGoods_supplier((queryGoodsSupplier.equals("«Î—°‘Ò")) ? "" : queryGoodsSupplier);
		goodsInfo.setGoods_type_code(Integer.parseInt(queryGoodsTypeCode.equals("") ? "000":queryGoodsTypeCode));
		System.out.println(goodsInfo);
		return goodsDao.queryGoodsByCondition(goodsInfo);
	}


	

}
