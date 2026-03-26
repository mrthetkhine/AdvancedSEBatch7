package com.turing.advancese7.oop;

public class BankAccount {
	
	private long balance;

	public void credit(long amount)
	{
		if(amount >=0)
		{
			this.balance += amount;
		}
		else
		{
			throw new RuntimeException("Invalid amount "+amount +" in credit");
		}
	}
	public void debit(long amount)
	{
		if(balance >= amount && amount >0)
		{
			this.balance -= amount;
		}
		else
		{
			throw new RuntimeException("Invalid amount "+amount +" in debit");
		}
	}
	public long getBalance() {
		return balance;
	}
	
	
}
