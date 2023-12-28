package com.ilp.entity;

import java.util.ArrayList;

public class Customer 
{
private String customerCode;
private String customerName;
private ArrayList<Account> account=new ArrayList<Account>();

public Customer(String customerCode, String customerName, ArrayList<Account> account) {
	
	this.customerCode = customerCode;
	this.customerName = customerName;
	this.account = account;
}

public String getCustomerCode() {
	return customerCode;
}

public void setCustomerCode(String customerCode) {
	this.customerCode = customerCode;
}

public String getCustomerName() {
	return customerName;
}

public void setCustomerName(String customerName) {
	this.customerName = customerName;
}

public ArrayList<Account> getAccount() {
	return account;
}

public void setAccount(ArrayList<Account> account) {
	this.account = account;
}


}
