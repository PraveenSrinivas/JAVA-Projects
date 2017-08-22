package com.jdbc.assignment.transactionsavepoint;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

import com.jdbc.SingleConnection;

public class TransSavePoint {

	public void transave() {
	
	Connection con = null;
	con = SingleConnection.getObject().getCon();
	Savepoint s1 = null;
	try {
		con.setAutoCommit(false);

		PreparedStatement pstmt = con.prepareStatement("update Bank.SBI set balance=? where bankid=?;");
		
		pstmt.setInt(1, 10);
		pstmt.setString(2, "u");
		pstmt.executeUpdate();
		
		
		pstmt.setInt(1, 32);
		pstmt.setInt(2, 21);
		pstmt.executeUpdate();
		
		s1 = con.setSavepoint();

		pstmt.setInt(1, 5);
		pstmt.setInt(2, 111);
		pstmt.executeUpdate();
	
		s1 = con.setSavepoint();
		
		pstmt.setInt(1, 10);
		pstmt.setInt(2, 111);
		pstmt.executeUpdate();
		
		con.commit();
		con.setAutoCommit(true);
	} catch (SQLException e) {
		if(con!=null)
		{
			if(s1!=null)
			{
				try {
					con.rollback(s1);
					con.commit();
					con.setAutoCommit(true);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else
			{
				try {
					con.rollback();
					con.setAutoCommit(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		e.printStackTrace();
	}
	
	}
	
}
