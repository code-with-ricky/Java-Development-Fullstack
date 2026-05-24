package com.ricky.jdbclearning;

// step1: import sql package + add jar file
import java.sql.*;

public class LaunchApp1 {
	public static void main(String[] args) throws SQLException {
		try {
			// step 2: Load and register the driver
			// Driver --> Implementation class provided by DB vendor
			Class.forName("com.mysql.cj.jdbc.Driver");
			// other way
//			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			
			// Step 3: Establish connection
			// getConnection --> static method provided by DriverManager
			String url = "jdbc:mysql://localhost:3306/jdbclearning";
			String user = "root";
			String password = "Bhd123@Amk";
			Connection connect = DriverManager.getConnection(url, user, password);
			
			// Step 4: Create Statement
			Statement statement = connect.createStatement();
			
			// Execute the query
			// non select operation -> insert, update, delete --> use executeUpdate
			String insertQuery = "INSERT INTO studentInfo(id, fullName, age, city) VALUES(2, 'Srivaths Iyer', 21, 'Bangalore');";
			int rowsAffected = statement.executeUpdate(insertQuery); // return number of rows affected
			if(rowsAffected == 0) {
				System.out.println("Failed to insert data");
			}else {
				System.out.println("Data Inserted into the StudentInfo Table");
			}
			
			
			// close the resources
			statement.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
