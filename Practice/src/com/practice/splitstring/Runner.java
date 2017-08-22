package com.practice.splitstring;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		String s;
		String k[];
		System.out.println("Enter the string");
		Scanner sc = new Scanner(System.in);
		s=sc.nextLine();
		k=s.split("i");
		for (String st : k) {
			System.out.println(st);			
		}
	}

}
