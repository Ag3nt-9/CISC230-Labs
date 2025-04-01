package EmployeeManagementSystem;

public class FullTimeEmployee extends AbstractEmployee {
	private double bonus = 0.0;
	public FullTimeEmployee(String name, double salary)  {
		super(name, JobType.FULL_TIME, salary);
	}
	
	public double calculateSalary() {
		return this.salary + this.bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
}
