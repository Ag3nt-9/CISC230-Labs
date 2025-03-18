package BankManagementSystem;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Bank bank = new Bank();
		int choice = 0;
		int accountNumber;
		double amount;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Welcome to the Secure Bank Mainframe");
			System.out.println("What would you like to do?");
			System.out.println("(1) View Accounts");
			System.out.println("(2) Create an Account");
			System.out.println("(3) Deposit Funds");
			System.out.println("(4) Withdraw Funds");
			System.out.println("(5) Transfer Funds");
			System.out.println("(6) View Account Transaction History");
			System.out.println("(7) Generate Interest on All Accounts");
			System.out.println("(8) Exit");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1:
				bank.displayAllAccounts();
			case 2:
				System.out.println("Enter your name: ");
				String name = scanner.nextLine();
				System.out.println("Enter Initial Balance: ");
				double balance = scanner.nextDouble();
				System.out.println("(1) Checking Account");
				System.out.println("(2) Savings Account");
				System.out.println("Enter Account Type: ");
				int accountType = scanner.nextInt();
				bank.createAccount(name, balance, accountType);
			case 3:
				System.out.println("Enter Account Number: ");
				accountNumber = scanner.nextInt();
				System.out.println("Enter $ Amount: ");
				amount = scanner.nextDouble();
				bank.deposit(accountNumber, amount);

			case 4:
				System.out.println("Enter Account Number: ");
				accountNumber = scanner.nextInt();
				System.out.println("Enter $ Amount: ");
				amount = scanner.nextDouble();
				bank.withdraw(accountNumber, amount);

			case 5:
				System.out.println("Enter Account Number Gaining Funds: ");
				int toAccountNumber = scanner.nextInt();
				
				System.out.println("Enter Account Number Losing Funds: ");
				int fromAccountNumber = scanner.nextInt();
				
				System.out.println("Enter $ Amount: ");
				amount = scanner.nextDouble();
				bank.transferFunds(fromAccountNumber, toAccountNumber, amount);

			case 6:
				System.out.println("Enter Account Number: ");
				accountNumber = scanner.nextInt();
				bank.viewTransactionHistory(accountNumber);
			case 7:
				bank.generateInterest();
			}
		} while (choice != 8);
		scanner.close();
	}

}
