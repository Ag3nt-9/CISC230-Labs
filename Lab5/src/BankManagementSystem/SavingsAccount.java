package BankManagementSystem;

public class SavingsAccount extends BankAccount {
	public SavingsAccount(String holderName, double balance) {
		super(holderName, balance, "SavingsAccount");
	}
	
	public boolean withdraw(double amount) {
		if (balance - amount >= 100) {
			balance -= amount;
			this.logTransaction("Withdrew $"+amount+"\nNew Balance: $"+balance);
			return true;
		}
		return false;
	}
	
	@Override
	public void generateInterest() {
		balance *= 1.003;
		this.logTransaction("Interest Generated. New Balance: $"+balance);
	}
}
