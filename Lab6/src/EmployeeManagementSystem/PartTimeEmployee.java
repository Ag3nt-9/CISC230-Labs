package EmployeeManagementSystem;

public class PartTimeEmployee extends AbstractEmployee {
	private double hourly_wage, hours;
	public PartTimeEmployee(String name, double hourly_wage, double hours)  {
		super(name, JobType.PART_TIME, hourly_wage*hours);
		this.hourly_wage = hourly_wage < 7.25 ? 7.25 : hourly_wage;
		this.hours = hours;
		calculateSalary();
	}
	
	public double calculateSalary() {
		this.salary = hourly_wage * hours;
		return this.salary;
	}
	
	public void setHours(double hours) {
		this.hours = hours < 0 ? 0 : hours;
		calculateSalary();
	}
}
