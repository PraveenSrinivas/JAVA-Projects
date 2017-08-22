package com.jdbc.transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc.SingleConnection;


public class Transdemo {

	public void trans1() {
		Connection con = null;
		
		try {
			//Class.forName("com.jdbc.mysql.Driver");
			
			con = SingleConnection.getObject().getCon();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("update Bank.SBI set balance=? where bankid=?;");
			pstmt.setInt(1,00000);
			pstmt.setInt(2,13);
			
			pstmt.executeUpdate();		
			
			con.commit();
	      }
		 catch (SQLException e) {
				e.printStackTrace();
			}
		}
}
