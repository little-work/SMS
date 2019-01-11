package com.alibaba.wms.controller;

import com.alibaba.wms.bean.BackResult;
import com.alibaba.wms.bean.GoodsInfo;
import com.alibaba.wms.bean.GoodsType;
import com.alibaba.wms.bean.Supplier;
import com.alibaba.wms.services.impl.GoodsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class GoodsController {

	private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);
	
	@Autowired
	private GoodsServiceImpl goodsServiceImpl;
	
	
	/**
	 * �ҵĿ��
	 * @param locale
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/stock")
	public String stock(Locale locale, Model model) {
		return "/pages/stock";
	}
	
	
	
	@RequestMapping(value = "/queryAllGoodsType")
	@ResponseBody
	public BackResult<GoodsType> queryAllGoodsType(){
		
		List<GoodsType> list=null;
		BackResult<GoodsType> backResult=null;
		
		try {
			list=new ArrayList<GoodsType>();
			backResult=new BackResult<GoodsType>();
			list=goodsServiceImpl.queryAllGoodsType();
			backResult.setTotal(list.size());
			backResult.setRows(list);
			return backResult;
		} catch (Exception e) {
			logger.error("��ѯ��Ʒ�����쳣",e.toString());
			return backResult;
		}
		
	}
	
	@RequestMapping(value = "/queryAllSupplier")
	@ResponseBody
	public BackResult<Supplier> queryAllSupplier(){
		
		List<Supplier> list=null;
		BackResult<Supplier> backResult=null;
		try {
			list=new ArrayList<Supplier>();
			backResult=new BackResult<Supplier>();
			list=goodsServiceImpl.queryAllSupplier();
			backResult.setTotal(list.size());
			backResult.setRows(list);
			return backResult;
		} catch (Exception e) {
			logger.error("��ѯ��Ӧ���쳣",e.toString());
			return backResult;
		}
		
	}
	
	
	@RequestMapping(value = "/addGoods")
	@ResponseBody
	public Map<Boolean,String> addGoods(String goodsName,String goodsPrice,String goodsNumber,String goodsSupplier,String goodsTypeCode){
		Map<Boolean,String> result =null;
		
		try {
			result =new HashMap<Boolean, String>();
			goodsServiceImpl.addGoods(goodsName, goodsPrice, goodsNumber, goodsSupplier,goodsTypeCode);
			result.put(true, "�����Ʒ�ɹ�");
			return result;
		} catch (Exception e) {
			result.put(false, "�����Ʒ�쳣");
			logger.error("�����Ʒ�쳣",e.toString());
			return result;
		}
		
	}
	
	
	
	@RequestMapping(value = "/editGoods")
	@ResponseBody
	public String editGoods(String goodsNameEdit,String goodsPriceEdit,String goodsNumberEdit,
			String goodsSupplierEdit,String goodsTypeCodeEdit,String goodsID){
		try {
			goodsServiceImpl.editGoods(goodsNameEdit,goodsPriceEdit,goodsNumberEdit,
					goodsSupplierEdit,goodsTypeCodeEdit,goodsID);
			return "ok";
		} catch (Exception e) {
			logger.error("�༭�̻��쳣",e.getMessage());
			return "�༭�̻��쳣";
		}
		
	}
	
	@RequestMapping(value = "/deleteGoods")
	@ResponseBody
	public String deleteGoods(String goodsid){
		try {
			goodsServiceImpl.deleteGoods(goodsid);
			return "ok";
		} catch (Exception e) {
			logger.error("ɾ���쳣",e);
			return "ɾ��ʧ��";
		}
		
	}
	
	
	
	@RequestMapping(value = "/queryAllGoods")
	@ResponseBody
	public BackResult<GoodsInfo> queryAllGoods(String queryParamTest,int limit, int offset){
		
		BackResult<GoodsInfo> backresult=null;
		try {
			System.out.println("�õ��Ĳ����ǣ�"+limit+offset+queryParamTest);
			List<GoodsInfo> list =goodsServiceImpl.queryAllGoods();
			
			backresult=new BackResult<GoodsInfo>();
			backresult.setTotal(list.size());
			backresult.setRows(list);
			
			return backresult;
		} catch (Exception e) {
			logger.error("��ѯ��Ʒ��Ϣʧ��",e);
			return backresult;
		}
		
		
		
	}
	
	@RequestMapping(value = "/queryGoodsByCondition")
	@ResponseBody
	public BackResult<GoodsInfo> queryGoodsByCondition(String queryDate,String queryGoodsSupplier, String queryGoodsTypeCode){
		BackResult<GoodsInfo> backresult=null;
		
		try {
			System.out.println("ʱ�䣺"+queryDate+"-��Ӧ�̣�"+queryGoodsSupplier+"-��Ʒ�����룺"+queryGoodsTypeCode);
			List<GoodsInfo> list =goodsServiceImpl.queryGoodsByCondition(queryDate.trim(), queryGoodsSupplier.trim(), queryGoodsTypeCode.trim());
			backresult=new BackResult<GoodsInfo>();
			backresult.setTotal(list.size());
			backresult.setRows(list);
			return backresult;
		} catch (Exception e) {
			logger.error("��ѯ��Ʒ��Ϣʧ��",e);
			return backresult;
		}
	}
	
	
	
	
	
	
	
	/*@RequestMapping(value = "/banchInsert")
	@ResponseBody
	public void banchInsert(){
		goodsServiceImpl.batchInsertGoods();
	}
	*/
	
	
	
	
	
	
	
}
