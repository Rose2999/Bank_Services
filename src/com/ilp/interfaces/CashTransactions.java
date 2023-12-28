package com.ilp.interfaces;

import com.ilp.entity.Account;

public interface CashTransactions 
{
	public Account withdrawMoney(Account account);
	public Account depositMoney(Account account);
}
