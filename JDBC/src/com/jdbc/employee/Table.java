package com.jdbc.employee;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.jdbc.SingleConnection;


public class Table {

	public boolean create() {

		String sql = "create table jspidersdb.employee(name varchar(20),eid int,salary int,designation varchar(15),primary key(eid));";
		boolean res=false;
		SingleConnection single = SingleConnection.getObject();
		Connection con = single.getCon();

		try {
			Statement stmt = con.createStatement();
			res=stmt.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public void update() {

	}

	public void insert() {

	}

	public void delete() {

	}
}
