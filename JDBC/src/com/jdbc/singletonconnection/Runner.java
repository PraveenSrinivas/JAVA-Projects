package com.jdbc.singletonconnection;

import java.util.Scanner;

import com.jdbc.singletonconnection.bean.UserBean;

public class Runner {

	public static void main(String[] args) {
		String name,email;
		int age;
		long phone;
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the username");
		name = sc.next();
		System.out.println("enter the age");
		age = sc.nextInt();
		System.out.println("enter the user email");
		email = sc.next();
		System.out.println("enter the user phone");
		phone = sc.nextLong();

		UserBean bean = new UserBean();
		bean.setName(name);
		bean.setAge(age);
		bean.setEmail(email);
		bean.setPhone(phone);

		User user = new User();
		boolean result = user.addUser(bean);

		if(!result)
			System.out.println("User ADDED");
		else
			System.out.println("User not ADDED");
	}

}
