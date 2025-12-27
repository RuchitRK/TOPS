package com.module_6;

import java.util.Scanner;

@SuppressWarnings("serial")
class InsufficientBalanceException extends Exception {
	public InsufficientBalanceException(String message) {
		super(message);
	}
}
public class BankWithdrawal {
	static double balance = 2000.00;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Account balance is: " + balance);
		System.out.print("Enter withdraw amount: ");
		double amount = scanner.nextDouble();
		try {
			checkBalanceAndWithdraw(amount); 
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
		}
		scanner.close();
	}
	public static void checkBalanceAndWithdraw(double amount) throws InsufficientBalanceException {
		if (amount > balance) {
			double needed = amount - balance;
			throw new InsufficientBalanceException("Sorry, insufficient balance, you need more " + needed + " Rs. To perform this transaction.");
		} else {
			balance = balance - amount;
			System.out.println("Transaction Successful. Remaining Balance: " + balance);
		}
 	}
}