package com.alibaba.wms.bean;

public class GoodsInfo {

	private String goods_id;
	private String goods_name;
	private int goods_type_code;
	private String goods_type_name;
	private int goods_number;
	private Double goods_price;
	private String goods_supplier;
	private String store_time;
	private String update_time;
	public String getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getGoods_type_code() {
		return goods_type_code;
	}
	public void setGoods_type_code(int goods_type_code) {
		this.goods_type_code = goods_type_code;
	}
	public String getGoods_type_name() {
		return goods_type_name;
	}
	public void setGoods_type_name(String goods_type_name) {
		this.goods_type_name = goods_type_name;
	}
	public int getGoods_number() {
		return goods_number;
	}
	public void setGoods_number(int goods_number) {
		this.goods_number = goods_number;
	}
	public Double getGoods_price() {
		return goods_price;
	}
	public void setGoods_price(Double goods_price) {
		this.goods_price = goods_price;
	}
	public String getGoods_supplier() {
		return goods_supplier;
	}
	public void setGoods_supplier(String goods_supplier) {
		this.goods_supplier = goods_supplier;
	}
	public String getStore_time() {
		return store_time;
	}
	public void setStore_time(String store_time) {
		this.store_time = store_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	@Override
	public String toString() {
		return "GoodsInfo [goods_id=" + goods_id + ", goods_name=" + goods_name + ", goods_type_code=" + goods_type_code
				+ ", goods_type_name=" + goods_type_name + ", goods_number=" + goods_number + ", goods_price="
				+ goods_price + ", goods_supplier=" + goods_supplier + ", store_time=" + store_time + ", update_time="
				+ update_time + "]";
	}
	
	
	
	
}
