package com.alibaba.wms.util;

import java.util.LinkedHashMap;
import java.util.Map;

public class AddressMapping {

	public static Map<String,String> map=new LinkedHashMap<String, String>();
	
	static{
		map.put("/login", "ȥ��½����");
		map.put("/getImage", "��ȡ��֤��");
		map.put("/main", "ȥ������");
		map.put("/loginout", "�˳���ǰϵͳ");
		map.put("/toLogin", "��¼����");
		map.put("/queryAllGoodsType", "��ѯ��Ʒ����");
		map.put("/queryAllSupplier", "��ѯ��Ӧ��");
		map.put("/addGoods", "�����Ʒ");
		map.put("/editGoods", "�༭��Ʒ");
		map.put("/queryAllGoods", "��ѯ������Ʒ");
		map.put("/order", "��������");
		map.put("/stock", "������");
		map.put("/warehousing", "�ֿ����");
		
	}
	
	
	
}
