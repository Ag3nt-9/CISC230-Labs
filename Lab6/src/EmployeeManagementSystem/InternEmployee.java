package EmployeeManagementSystem;

public class InternEmployee extends AbstractEmployee{
	public InternEmployee(String name, double salary)  {
		super(name, JobType.INTERN, salary);
	}
	
	public double calculateSalary() {
		return this.salary;
	}
}
