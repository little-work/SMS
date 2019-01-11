package com.alibaba.wms.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddressMapping {

	public static Map<String,String> map=new LinkedHashMap<String, String>();
	
	static{
		map.put("/login", "去登陆界面");
		map.put("/getImage", "获取验证码");
		map.put("/main", "去主界面");
		map.put("/loginout", "退出当前系统");
		map.put("/toLogin", "登录请求");
		map.put("/queryAllGoodsType", "查询商品种类");
		map.put("/queryAllSupplier", "查询供应商");
		map.put("/addGoods", "添加商品");
		map.put("/editGoods", "编辑商品");
		map.put("/queryAllGoods", "查询所有商品");
		map.put("/order", "订单管理");
		map.put("/stock", "库存管理");
		map.put("/warehousing", "仓库管理");
		
	}
	
	
	
}
