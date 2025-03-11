package BankManagementSystem;

public class CheckingAccount extends BankAccount {
	public CheckingAccount(String holderName, double balance) {
		super(holderName, balance, "CheckingsAccount");
	}
	
	public boolean withdraw(double amount) {
		if (balance - amount >= -500) {
			balance -= amount;
			if (balance < 0) {
				System.out.println("Overdraft used. Fee applied.");
				balance -= 50;
			}
			return true;
		}
		return false;
	}
}
