package EmployeeManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
		
	public static void main(String[] args) {
		ArrayList<AbstractEmployee> employees = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		int subchoice = 1;
		String name;

		
		do {
			System.out.println("Welcome to Employee Database Management for Company Inc.");
			System.out.println("(1) Add Employees");
			System.out.println("(2) Employee Details");
			System.out.println("(3) Manage Employee");
			System.out.println("(4) Exit");
			choice = scanner.nextInt();
			System.out.println("\n\n");
			
			switch (choice) {
			case 1:
				System.out.println("Enter Name:");
				name = scanner.next();
				do {
					if (subchoice < 1 && subchoice > 3) {
						System.out.println("Not a valid option.\n");
					}
					System.out.println("Enter Job Type");
					System.out.println("(1) Full Time");
					System.out.println("(2) Part Time");
					System.out.println("(3) Intern");
					subchoice = scanner.nextInt();
				} while (subchoice < 1 && subchoice > 3);
				switch (subchoice) {
				case 2:
					double hourly_wage, hours;
					System.out.println("Enter Hourly Wage:");
					hourly_wage = scanner.nextDouble();
					System.out.println("Enter Hours:");
					hours = scanner.nextDouble();
					employees.add(new PartTimeEmployee(name, hourly_wage, hours));
					break;
				case 1:
					double salary;
					System.out.println("Enter Salary:");
					salary = scanner.nextDouble();
					employees.add(new FullTimeEmployee(name, salary));
					break;
				case 3:
					double stipend;
					System.out.println("Enter Stipend:");
					stipend = scanner.nextDouble();
					employees.add(new InternEmployee(name, stipend));
					break;
				}
				break;
			case 2:
				for (AbstractEmployee employee:employees) {
					employee.displayDetails();
				}
				break;
			case 3:
				System.out.println("Enter Employee:");
				name = scanner.next();
				for (AbstractEmployee employee:employees) {
					if (employee.getName() == name) {
						if (employee.getClass().getSimpleName() == "FullTimeEmployee") {
							
						}
					}
				}

				break;
			}
		} while (choice != 4);
		scanner.close();
	}

}
