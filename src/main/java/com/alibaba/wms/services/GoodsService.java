package com.alibaba.wms.services;

import java.util.List;

import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.GoodsType;
import com.alibaba.wms.bean.Supplier;


public interface GoodsService {

	/**
	 * �������е���Ʒ
	 * @return
	 * @throws Exception 
	 */
	public List<GoodsInfo> queryAllGoods() throws Exception;
	
	/**
	 * ����������Ʒ
	 * @param list
	 */
	public void batchInsertGoods();
		
	/**
	 * �����Ʒ���
	 * @param goodsInfo
	 * @throws Exception 
	 */
	public void addGoods(String goodsName,String goodsPrice,String goodsNumber,String goodsSupplier,String goodsType) throws Exception;
	
	/**
	 * �������еĹ�Ӧ��
	 * @return
	 * @throws Exception 
	 */
	public List<Supplier> queryAllSupplier() throws Exception;
	
	/**
	 * ��ѯ���еĲ�Ʒ����
	 * @return
	 * @throws Exception 
	 */
	public List<GoodsType> queryAllGoodsType() throws Exception;
	
	
	/**
	 * �༭��Ʒ
	 * @param goodsInfo
	 * @throws Exception 
	 */
	public void editGoods(String goodsNameEdit,String goodsPriceEdit,String goodsNumberEdit,
			String goodsSupplierEdit,String goodsTypeCodeEdit,String goodsID) throws Exception;
	
	/**
	 * ɾ����Ʒ
	 * @param goodsid
	 * @throws Exception 
	 */
	
	public void deleteGoods(String goodsid) throws Exception;
	
	/**
	 * ����������ѯ��Ʒ
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<GoodsInfo> queryGoodsByCondition(String queryDate,String queryGoodsSupplier, String queryGoodsTypeCode) throws Exception;
	
	
	
	
	
}
