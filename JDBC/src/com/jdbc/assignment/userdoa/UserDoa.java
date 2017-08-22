package com.jdbc.assignment.userdoa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDoa implements SqlInterface{
	Connection con = null;
	Scanner sc0 = new Scanner(System.in);
	boolean res=true;
	int rc=0;
	String db,tbl;
	Statement stmt;
	PreparedStatement pstmt;


	public void getcon() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "1");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}


	public void getdb() {
		System.out.println("Database Name: ");
		db = sc0.nextLine();
		System.out.println("Table Name : ");
		tbl =  sc0.nextLine();
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public boolean adduser(UserBean u) {
		try {
			pstmt=con.prepareStatement("insert into "+db+"."+tbl+" values(?,?,?,?)");
			pstmt.setString(1, u.getName());
			System.out.println(u.getName());
			pstmt.setInt(2, u.getAge());
			pstmt.setString(3, u.getGender());
			pstmt.setLong(4, u.getPhoneno());
			rc=pstmt.executeUpdate();
			if(rc==1)
				res=false;
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return res;
	}

	@Override
	public boolean gettable() {
		res = false;
		try {
			ResultSet rset = stmt.executeQuery("select * from "+db+"."+tbl+";");
			while (rset.next()) {
				String rs = rset.getString("name");
				System.out.print(rs+"\t\t");
				rs = rset.getString("age");
				System.out.print(rs+"\t\t");
				rs = rset.getString("gender");
				System.out.print(rs+"\t\t");
				rs = rset.getString("phoneno");
				System.out.print(rs+"\n");

			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public boolean deleteuser(UserBean u) {
		try {
			if(readuser(u))
				res=stmt.execute("delete from "+db+"."+tbl+" where name='"+u.getName()+"';");
			else
			{
				System.out.println("There is no data for the user ''"+u.getName()+"'' to delete");
				res = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return res;
	}

	@Override
	public boolean updateuser(UserBean u) {
		try {
			res = stmt.execute("update "+db+"."+tbl+" set "+u.getCol_name()+"='"+u.getVal()+"' where "+u.getCond()+";");
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		return res;
	}

	@Override
	public boolean readuser(UserBean u) {
		res = false;
		int count=0;
		try {
			ResultSet rset = stmt.executeQuery("select * from "+db+"."+tbl+" where name='"+u.getName()+"';");
			while (rset.next()) {
				String rs = rset.getString("name");
				System.out.print(rs+"\t\t");
				rs = rset.getString("age");
				System.out.print(rs+"\t\t");
				rs = rset.getString("gender");
				System.out.print(rs+"\t\t");
				rs = rset.getString("phoneno");
				System.out.print(rs+"\n");
				count++;
			}
			if(count>0)	res = true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return res;
	}


	@Override
	public void closecon() {
		if(con!=null)
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
