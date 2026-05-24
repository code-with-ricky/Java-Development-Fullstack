package com.ricky.jdbclearning;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	// when JDBCUtil class is loaded, this runs
	static {
		try {
			// loads and register the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// throwing SQLException so whoever calling this invoking this method, let them handle the exception
	public static Connection getConnection() throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbclearning";
		String user = "root";
		String password = "";
		Connection connect = DriverManager.getConnection(url, user, password);
		return connect;
	}
	
	// closing the resources
	public static void closeResources(Connection connect, Statement statement) throws SQLException {
		connect.close();
		statement.close();
	}
}
