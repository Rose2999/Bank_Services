package com.ilp.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class SavingsMaxAccount extends Product {
	
	private double minimumBalance;

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public SavingsMaxAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor stub
	}
	@SuppressWarnings("resource")
	@Override
	public Account withdrawMoney(Account account) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Amount To Withdraw : ");
		double money = scanner.nextDouble();
		if(money>account.getBalance())
			System.out.println("Not Enough Balance");
		else if(account.getBalance()-money<1000)
			System.out.println("Balance Cannot Go Below Minimum");
		else 
			account.setBalance(account.getBalance()-money);
		return account;
	}
	@SuppressWarnings("resource")
	@Override
	public Account depositMoney(Account account) {
		Scanner scanner1 = new Scanner(System.in);
		System.out.print("Enter Amount To Deposit : ");
		double money = scanner1.nextDouble();
		account.setBalance(money+account.getBalance());
		return account;
	}


}
