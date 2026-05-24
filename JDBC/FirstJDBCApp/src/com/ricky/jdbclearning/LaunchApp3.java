package com.ricky.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp3 {
	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbclearning";
			String user = "root";
			String password = "";
			Connection connect = DriverManager.getConnection(url, user, password);
			Statement statement = connect.createStatement();
			
			// retrieve data from table --> no change in table --> use executeQuery()
			String selectQuery = "SELECT * FROM studentInfo;";
			ResultSet rs = statement.executeQuery(selectQuery); // ResultSet is representative of our table in java application
			
			// process result set
			boolean hasData = false;
			System.out.println("Table Data: ");
			while(rs.next()) {
				hasData = true;
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			
			if(!hasData) {
				System.out.println("No Data Found");
			}
			
			statement.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
