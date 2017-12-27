package com.accolite.au.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionUtil {
	private static Connection connection;
	private static final String URL 	 = "jdbc:mysql://localhost:3306/hibernate5-db";
	private static final String username = "root";
	private static final String password = "Admin1234";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println(e);
		}
	}
	
	private JDBCConnectionUtil() {
		//Do Nothing
	}
	
	public static Connection openConnection() throws SQLException {
		if(connection == null) {
			connection = DriverManager.getConnection(URL, username, password);
		}
		return connection;
	}
	
	public static void closeConnection() throws SQLException {
		if(connection != null && !connection.isClosed()) {
			connection.close();
		}
	}

}
