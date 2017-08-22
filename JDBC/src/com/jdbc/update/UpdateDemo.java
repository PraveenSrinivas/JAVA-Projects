package com.jdbc.update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
	static Connection con = null;
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//("jdbc:mysql://localhost:3306", "root", "1");


		Statement stmt=null;
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			stmt.execute("update test_db.user set " + "name='travi'"+ "where phone='9972743692'");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	protected void finalize() throws Throwable {
		if(con!=null)
		{
			try {
				con.close();
				con=null;
			}
			catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}

