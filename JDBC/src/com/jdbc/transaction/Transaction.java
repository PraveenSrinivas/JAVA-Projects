package com.jdbc.transaction;
import com.jdbc.SingleConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;


public class Transaction {

	public void trans() {
		Connection con = null;
		Savepoint s1=null;
		try {
			con = SingleConnection.getObject().getCon();
			con.setAutoCommit(false);
			PreparedStatement pstmt = con.prepareStatement("update Bank.SBI set balance=? where bankid=?;");
			pstmt.setInt(1,4444);
			pstmt.setInt(2,15);
			
			pstmt.executeUpdate();

			pstmt.setInt(1,101);
			pstmt.setInt(2,111);
			
			pstmt.executeUpdate();

			s1 = con.setSavepoint();
			
			pstmt.setInt(1,4949);
			pstmt.setInt(2,21);
			
			pstmt.executeUpdate();
			
			con.commit();
			
			con.setAutoCommit(true);

		} catch (SQLException e) {
			if(con!=null)
				if(s1!=null)
				{
					try {
						con.rollback(s1);
						con.setAutoCommit(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
				else {
					try {
						con.rollback();
						con.setAutoCommit(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
					
			
			e.printStackTrace();
		}
	}
}
