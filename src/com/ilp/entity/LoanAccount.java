package com.ilp.entity;

import java.util.ArrayList;
import java.util.Scanner;

public class LoanAccount extends Product {

	private final double chequeDepositCharge = 0.03;
	public LoanAccount(String productCode, String productName, ArrayList<Services> serviceList) {
		super(productCode, productName, serviceList);
		// TODO Auto-generated constructor
	}
	public double getChequeDepositCharge() {
		return chequeDepositCharge;
	}
	
	@Override
	public Account withdrawMoney(Account account) {
		System.out.println("You Cannot Withdraw Money From Loan Account ");
		return account;
	}

	@SuppressWarnings("resource")
	@Override
	public Account depositMoney(Account account) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("1)Cash\n2)Cheque\nWhat Kind Of Deposit (Enter Number) : ");
		int choice = scanner.nextInt();
		System.out.print("Enter Amount To Deposit : ");
		double money = scanner.nextDouble();
		if(choice==2)
			money=money-money* chequeDepositCharge ;
		account.setBalance(money+account.getBalance());
		return account;
	}
	
}
