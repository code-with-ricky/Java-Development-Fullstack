package com.ricky.jdbclearning;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

public class LaunchApp6UtillsUsed {

	public static void main(String[] args) {
		Connection connect = null;
		Statement statement = null;
		try {
			connect = JDBCUtil.getConnection();
			statement = connect.createStatement();
			String query = "INSERT INTO studentInfo(id, fullName, age, city) VALUES(2, 'Purba Sarkar', 22, 'Jamshedpur');";
			int rowsAffected = statement.executeUpdate(query);
			if(rowsAffected > 0) {
				System.out.println("Data Inserted!");
			} else {
				System.out.println("Data Insertion Failed!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(connect, statement);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
