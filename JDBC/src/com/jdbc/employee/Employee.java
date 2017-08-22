package com.jdbc.employee;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.SingleConnection;

public class Employee {

	public boolean addEmployee(EmployeeBean e) {

		
		boolean res=false;
	
		String sql = "insert into jspidersdb.employee values('"+e.getName()+"','"+e.getEid()+"','"+e.getSalary()+"','"+e.getDesignation()+"');";
		SingleConnection single = SingleConnection.getObject();
		Connection con = single.getCon();

		Statement stmt;
		try {
			stmt = con.createStatement();
			res = stmt.execute(sql);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return res;
	}
	public void getdata(long csal) {
		String sql = "select * from jspidersdb.employee where salary>"+csal+";";
		SingleConnection single = SingleConnection.getObject();
		Connection con = single.getCon();
		Statement stmt;
		try {
			stmt = con.createStatement();
			ResultSet res = stmt.executeQuery(sql);
			while(res.next())
			{
				System.out.println("name "+ res.getString(1)+ " num "+ res.getInt(2)+ " salary "+ res.getInt(3)
				+ " email "+ res.getString(4));
			}
			}
		catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
}
