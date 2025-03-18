package BankManagementSystem;

import java.util.ArrayList;

public abstract class BankAccount implements TransactionLogger {
	protected int accountNumber;
	protected String holderName, accountType;
	protected double balance;
	protected ArrayList<String> transactionLog = new ArrayList<>();
	
	public BankAccount(String holderName, double balance, String accountType) {
		this.holderName = holderName;
		this.balance = balance;
		this.accountType = accountType;
		this.accountNumber = 800000+(int)(100000.0*Math.random());
		this.logTransaction("Created Account\nNumber: "+accountNumber+"\nHolder: "+holderName+"\nType: "+accountType+"\nInitial Balance: $"+balance);
	}
	
	public void generateInterest() {}
	
	public boolean deposit(double amount) {
		balance += amount;
		this.logTransaction("Deposited $"+amount+"\nNew Balance: $"+balance);
		return true;
	}
	
	public abstract boolean withdraw(double amount);
	
	public double getBalance() {
		return balance;
	}
	
	public void displayAccountInfo() {
		System.out.println("Name: " + holderName + " Balance: " + balance + " Account Type: " + accountType);
	}
	
	public boolean hasAccountNumber(int num) {
		return num == accountNumber;
	}

	@Override
	public void logTransaction(String message) {
		transactionLog.add(message);
	}
	
	@Override
	public void printTransactionLog() {
		for (String transaction:transactionLog) {
			System.out.println(transaction);
		}
	}
}

