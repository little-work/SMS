package com.alibaba.wms.bean;

import java.util.List;

public class BackResult<T> {

	
	public int total;     //�ܼ�¼��  
    public List<T> rows;  //�����б�  
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
    
    
}
