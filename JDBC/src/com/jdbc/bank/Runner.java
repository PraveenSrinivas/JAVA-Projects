package com.jdbc.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Runner {

	public static void main(String[] args) {
		
		String sid,rid;
		int amount,sbalance=0,rbalance=0;
		System.out.println("Enter the sender's id");
		Scanner sc = new Scanner(System.in);
		sid=sc.nextLine();
		System.out.println("Enter the reciever's id");
		rid=sc.nextLine();
		System.out.println("Enter the amount to transfer");
		amount=sc.nextInt();
		
		//get connection object
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection con; 
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "1");
			Statement stmt = con.createStatement();
			
			ResultSet res = stmt.executeQuery("select balance from SBI where bankid="+sid);
			if(res.next())
			{
				sbalance= res.getInt(1);
			}
			
			res = stmt.executeQuery("select balance from SBI where bankid="+rid);
			if(res.next())
			{
				rbalance=res.getInt(1);
			}
			
			
			if(sbalance>=amount+1000)
			{
				int subalance = sbalance-amount;
				int rubalance = rbalance+amount;
				String u_sender = "update SBI set balance="+subalance+" where bankid="+sid+";";
				String u_reciever = "update SBI set balance="+rubalance+" where bankid="+rid+";";
				String i_trans_s = "insert into transaction values("+sid+",'successful',"+amount+",'debiitted',"+subalance+");";
				String i_trans_r = "insert into transaction values("+rid+",'successful',"+amount+",'creditted',"+rubalance+");";
				stmt.addBatch(u_sender);
				stmt.addBatch(u_reciever);
				stmt.addBatch(i_trans_s);
				stmt.addBatch(i_trans_r);
				int a[] = stmt.executeBatch();
				System.out.println("Transaction successfull");
				
			}
			else
				System.out.println("Insufficient Balance");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		sc.close();
	}

	
}
