package com.ricky.jdbclearning;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class LaunchApp4 {

	public static void main(String[] args) throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/jdbclearning";
			String user = "root";
			String password = "";
			Connection connect = DriverManager.getConnection(url, user, password);
			
			Statement statement = connect.createStatement();
			
			String deleteQuery = "DELETE FROM studentInfo WHERE id=2";
			int rowsAffected = statement.executeUpdate(deleteQuery);
			
			if(rowsAffected > 0) {
				System.out.println("Data Deleted Successfully!");
			}else {
				System.out.println("Failed to delete data");
			}
			
			statement.close();
			connect.close();
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		

	}

}
