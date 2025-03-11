package BankManagementSystem;

public class SavingsAccount extends BankAccount {
	public SavingsAccount(String holderName, double balance) {
		super(holderName, balance, "SavingsAccount");
	}
	
	public boolean withdraw(double amount) {
		if (balance - amount >= 100) {
			balance -= amount;
			return true;
		}
		return false;
	}
	
	public void generateInterest() {
		balance *= 1.003;
	}
}
