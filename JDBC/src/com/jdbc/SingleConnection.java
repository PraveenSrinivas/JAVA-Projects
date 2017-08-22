package com.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class SingleConnection {

	String url="jdbc:mysql://localhost:3306";
	String uname="root";
	String pswd="1";
	Connection con=null;




	private static final SingleConnection SINGLE;

	static 
	{
		SINGLE = new SingleConnection();
	}


	private SingleConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url, uname, pswd);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static SingleConnection getObject() {
		return SINGLE;

	}
	
	public Connection getCon() {
		return con;
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
