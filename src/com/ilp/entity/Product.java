package com.ilp.entity;

import java.util.ArrayList;

import com.ilp.interfaces.CashTransactions;

public abstract class Product implements CashTransactions
{
	private String productCode;
	private String productName;
	private ArrayList<Services> serviceList=new ArrayList<Services>();
	public Product(String productCode, String productName, ArrayList<Services> serviceList) {
		
		this.productCode = productCode;
		this.productName = productName;
		this.serviceList = serviceList;
	}
	
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public ArrayList<Services> getServiceList() {
		return serviceList;
	}
	public void setServiceList(ArrayList<Services> serviceList) {
		this.serviceList = serviceList;
	}
	
	
}
