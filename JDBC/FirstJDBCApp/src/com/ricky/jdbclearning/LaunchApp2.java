package com.ricky.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp2 {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbclearning";
			String user = "root";
			String password = "";
			Connection connect = DriverManager.getConnection(url, user, password);
			Statement statement = connect.createStatement();
			
			String updateQuery = "UPDATE studentInfo SET city='Pune' WHERE id=2";
			int rowsAffected = statement.executeUpdate(updateQuery);
			
			if(rowsAffected == 0) {
				System.out.println("Failed to update data");
			}else {
				System.out.println("Data Updated Successfully!");
			}
			
			statement.close();
			connect.close();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
