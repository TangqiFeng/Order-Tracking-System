package com.sales.models;

import javax.validation.constraints.Min;

public class NewOrder {

	private String cId;
	private String pId;
	@Min(value=1)
	private int qty;
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	
}
