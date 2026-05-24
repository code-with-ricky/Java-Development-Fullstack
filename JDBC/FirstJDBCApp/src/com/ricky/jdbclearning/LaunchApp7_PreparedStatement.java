package com.ricky.jdbclearning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaunchApp7_PreparedStatement {

	public static void main(String[] args) {
		Connection connect = null;
		PreparedStatement ps = null;
		
		try {
			connect = JDBCUtil.getConnection();
			String query = "INSERT INTO studentInfo(id, fullName, age, city) VALUES(?, ?, ?, ?);";
			ps = connect.prepareStatement(query);
			ps.setInt(1, 4);
			ps.setString(2, "Srivaths Iyer");
			ps.setInt(3, 22);
			ps.setString(4, "Dombivali");
			
			int rowsAffected = ps.executeUpdate();
			if(rowsAffected > 0) {
				System.out.println("Data Inserted!");
			} else {
				System.out.println("Data Insertion Failed!");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(connect, ps);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
