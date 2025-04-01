package EmployeeManagementSystem;

public abstract class AbstractEmployee implements Employee{
	private String name;
	private JobType jobType;
	protected double salary;
	public AbstractEmployee(String name, JobType jobType, double salary) {
		this.name = name;
		this.jobType = jobType;
		this.salary = salary < 0 ? 0 : salary;
	}
	
	public void displayDetails() {
		System.out.println("Name: "+name+" Job Type: "+jobType+" Salary: $"+salary);
	}
	
	public String getName() {
		return name;
	}
}
