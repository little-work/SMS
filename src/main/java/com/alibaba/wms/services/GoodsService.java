package com.alibaba.wms.services;

import java.util.List;

import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.GoodsType;
import com.alibaba.wms.bean.Supplier;


public interface GoodsService {

	/**
	 * 查找所有的商品
	 * @return
	 * @throws Exception 
	 */
	public List<GoodsInfo> queryAllGoods() throws Exception;
	
	/**
	 * 批量插入商品
	 * @param list
	 */
	public void batchInsertGoods();
		
	/**
	 * 添加商品入库
	 * @param goodsInfo
	 * @throws Exception 
	 */
	public void addGoods(String goodsName,String goodsPrice,String goodsNumber,String goodsSupplier,String goodsType) throws Exception;
	
	/**
	 * 查找所有的供应商
	 * @return
	 * @throws Exception 
	 */
	public List<Supplier> queryAllSupplier() throws Exception;
	
	/**
	 * 查询所有的产品种类
	 * @return
	 * @throws Exception 
	 */
	public List<GoodsType> queryAllGoodsType() throws Exception;
	
	
	/**
	 * 编辑商品
	 * @param goodsInfo
	 * @throws Exception 
	 */
	public void editGoods(String goodsNameEdit,String goodsPriceEdit,String goodsNumberEdit,
			String goodsSupplierEdit,String goodsTypeCodeEdit,String goodsID) throws Exception;
	
	/**
	 * 删除商品
	 * @param goodsid
	 * @throws Exception 
	 */
	
	public void deleteGoods(String goodsid) throws Exception;
	
	/**
	 * 根据条件查询商品
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<GoodsInfo> queryGoodsByCondition(String queryDate,String queryGoodsSupplier, String queryGoodsTypeCode) throws Exception;
	
	
	
	
	
}
