package com.jdbc.demo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Runner {
	public static void main(String[] args) {
		Connection con=null;
		Properties prop = new Properties();
		try {
			FileReader fr = new FileReader("src/com/jdbc/demo/util/mysql.properties");
			prop.load(fr);
			
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//Load and register the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Establish a connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", prop);
			System.out.println(con);
			
			CallableStatement cstmt = con.prepareCall("{call insertdata(?,?,?)}");
			cstmt.setInt(1, 16);
			cstmt.setString(2, "rekha");
			cstmt.setInt(3, 4616);
			int a=cstmt.executeUpdate();
			System.out.println(a);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
