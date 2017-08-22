package com.jdbc.singletonconnection;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbc.SingleConnection;
import com.jdbc.singletonconnection.bean.UserBean;


public class User {

	public boolean addUser(UserBean user) {

		boolean res=false;

		String sql = "insert into test_db.user values('"
				+user.getName()+"',"+user.getAge()+",'"+user.getEmail()+"','"+user.getPhone()+"');";

				SingleConnection single = SingleConnection.getObject();
				Connection con = single.getCon();
				//try
				try {
					Statement stmt = con.createStatement();
					res = stmt.execute(sql);
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
				return res;

	}
}
