package com.jdbc.transaction;

public class Test {

	public static void main(String[] args) {
		
		System.out.println("App Start");
		
		Transaction t = new Transaction();
		t.trans();
		
		Transdemo t1 = new Transdemo();
		t1.trans1();
		
		
		System.out.println("App End");
	}

}
