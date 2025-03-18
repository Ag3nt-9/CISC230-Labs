package BankManagementSystem;

import java.util.ArrayList;

public class Bank {
	private ArrayList<BankAccount> bankAccounts = new ArrayList<>();
	public Bank() {
		
	}
	
	public void createAccount(String name, double balance, int accountType) {
		switch(accountType) {
		case 1:
			bankAccounts.add(new CheckingAccount(name, balance));
		case 2:
			bankAccounts.add(new SavingsAccount(name, balance));
		}
	}
	
	public BankAccount findBankAccount(int accountNumber) {
		for (BankAccount account:bankAccounts) {
			if (account.hasAccountNumber(accountNumber)) {
				return account;
			}
		}
		return null;
	}
	
	public void deposit(int accountNumber, double amount) {
		BankAccount account = this.findBankAccount(accountNumber);
		if (account.deposit(amount)) {
			System.out.println("Funds successfully deposited.");
		}
	}

	public void withdraw(int accountNumber, double amount) {
		BankAccount account = this.findBankAccount(accountNumber);
		if (account.withdraw(amount)) {
			System.out.println("Funds successfully withdrawn.");
		} else {
			System.out.println("Insufficient funds.");
		}
	}
	
	public void transferFunds(int fromAccount, int toAccount, double amount) {
		BankAccount fromBankAccount = this.findBankAccount(fromAccount);
		BankAccount toBankAccount = this.findBankAccount(toAccount);
		if (fromBankAccount.withdraw(amount)) {
			toBankAccount.deposit(amount);
			System.out.println("Transfer successful.");
		} else {
			System.out.println("Transfer unsuccessful.");
		}
	}
	
	public void generateInterest() {
		for (BankAccount account:bankAccounts) {
			account.generateInterest();
		}
	}
	
	public void viewTransactionHistory(int accountNumber) {
		BankAccount account = this.findBankAccount(accountNumber);
		account.printTransactionLog();
	}
	
	public void displayAllAccounts() {
		for (BankAccount account:bankAccounts) {
			account.displayAccountInfo();
		}
	}

}