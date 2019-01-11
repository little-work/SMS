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
	 * 查找所有的商品
	 * @return
	 */
	public List<GoodsInfo> queryAllGoods();
	
	/**
	 * 批量插入商品
	 * @param list
	 */
	public void batchInsertGoods(List<HashMap> list);
	
	/**
	 * 添加商品入库
	 * @param goodsInfo
	 */
	public void addGoods(GoodsInfo goodsInfo);
	
	/**
	 * 查询所有的产品种类
	 * @return
	 */
	public List<GoodsType> queryAllGoodsType();
	
	/**
	 * 查找所有的供应商
	 * @return
	 */
	public List<Supplier> queryAllSupplier();
	
	/**
	 * 编辑商品
	 * @param goodsInfo
	 */
	public void editGoods(GoodsInfo goodsInfo);
	/**
	 * 删除商品
	 * @param goodsid
	 */
	
	public void deleteGoods(String goodsid);
	
	/**
	 * 根据条件查询商品
	 * @param queryDate
	 * @param queryGoodsSupplier
	 * @param queryGoodsType
	 * @return
	 * @throws Exception
	 */
	
	public List<GoodsInfo> queryGoodsByCondition(GoodsInfo goodsInfo);
	
	
	
	/**
	 * 记录登录状态会话
	 * @param websession
	 */
	
	public void  insertWebSession(WebSession websession);
	
	public int countWebSession(String opname);
	
	public void deleteWebSession(String opname);
	
	public void insertLog(Log log);
	
	
}
