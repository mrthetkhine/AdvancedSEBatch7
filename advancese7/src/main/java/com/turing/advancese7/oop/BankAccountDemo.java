package com.turing.advancese7.oop;

public class BankAccountDemo {
	public static void main(String[]args)
	{
		BankAccount acc = new BankAccount();
		acc.credit(1000);
		acc.debit(1400);
		System.out.println("Balance "+acc.getBalance());
	}
}
