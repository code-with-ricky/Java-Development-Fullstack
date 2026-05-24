/* 
 * In this code we have shown how we can handle multiple exceptions using multiple catch block
 * better way than using try catch and throws both
*/

package com.ricky.jdbclearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class LaunchApp5 {

	public static void main(String[] args) {
		Connection connect = null;
		Statement statement = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/jdbclearning";
			String user = "root";
			String password = "";
			connect = DriverManager.getConnection(url, user, password);
			statement = connect.createStatement();
			String query = "SELECT * FROM studentInfo";
			ResultSet rs = statement.executeQuery(query);
			boolean hasData = false;
			while(rs.next()) {
				hasData = true;
				System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
			}
			
			if(!hasData) {
				System.out.println("No data found");
			}
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {  // Generic catch block --> good practice to write at end
			e.printStackTrace();
		} finally {
			// if exception happens at any line inside try block, it will go to catch and code below that line will not executed
			// but closing of resources is must so we write them in finally block
			// finally block always execute even if exception occurs or not
			try {
				statement.close();
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}

	}

}
