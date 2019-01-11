package com.alibaba.wms.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.GoodsType;
import com.alibaba.wms.bean.Log;
import com.alibaba.wms.bean.Supplier;
import com.alibaba.wms.bean.WebSession;



@Repository
public interface GoodsDao {

	
	
	/**
	 * �������е���Ʒ
	 * @return
	 */
	public List<GoodsInfo> queryAllGoods();
	
	/**
	 * ����������Ʒ
	 * @param list
	 */
	public void batchInsertGoods(List<HashMap> list);
	
	/**
	 * �����Ʒ���
	 * @param goodsInfo
	 */
	public void addGoods(GoodsInfo goodsInfo);
	
	/**
	 * ��ѯ���еĲ�Ʒ����
	 * @return
	 */
	public List<GoodsType> queryAllGoodsType();
	
	/**
	 * �������еĹ�Ӧ��
	 * @return
	 */
	public List<Supplier> queryAllSupplier();
	
	/**
	 * �༭��Ʒ
	 * @param goodsInfo
	 */
	public void editGoods(GoodsInfo goodsInfo);
	/**
	 * ɾ����Ʒ
	 * @param goodsid
	 */
	
	public void deleteGoods(String goodsid);
	
	/**
	 * ����������ѯ��Ʒ
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<GoodsInfo> queryGoodsByCondition(GoodsInfo goodsInfo);
	
	
	
	/**
	 * ��¼��¼״̬�Ự
	 * @param websession
	 */
	
	public void  insertWebSession(WebSession websession);
	
	public int countWebSession(String opname);
	
	public void deleteWebSession(String opname);
	
	public void insertLog(Log log);
	
	
}
