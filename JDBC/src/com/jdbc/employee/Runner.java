package com.jdbc.employee;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		String name,designation;
		long salary;
		int eid;
		
		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the Employee name");
		name = sc.nextLine();
		System.out.println("enter the Employee id");
		eid = sc.nextInt();
		System.out.println("enter the Employee salary");
		salary = sc.nextLong();
		System.out.println("enter the Employee designation");
		designation = sc.nextLine();
		EmployeeBean bean = new EmployeeBean();
		bean.setName(name);
		bean.setEid(eid);
		bean.setSalary(salary);
		bean.setDesignation(designation);

		Employee e = new Employee();
		/*boolean result = e.addEmployee(bean);
		if(!result)
			System.out.println("User ADDED");
		else
			System.out.println("User not ADDED");
		*/
		
		System.out.println("Enter the salary criteria");
		long csal=sc.nextLong();
		
		

	}

}


