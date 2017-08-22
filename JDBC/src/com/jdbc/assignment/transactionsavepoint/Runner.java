package com.jdbc.assignment.transactionsavepoint;

public class Runner {

	public static void main(String[] args) {
		System.out.println("APP Start");
		TransSavePoint tsp = new TransSavePoint();
		tsp.transave();		
		System.out.println("App end");
	}

}
