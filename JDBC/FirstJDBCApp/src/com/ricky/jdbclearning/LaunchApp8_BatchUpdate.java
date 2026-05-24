package com.ricky.jdbclearning;

import java.sql.Connection;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LaunchApp8_BatchUpdate {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Connection connect = null;
		PreparedStatement pstmt = null;
		
		try {
			connect = JDBCUtil.getConnection();
			String query = "UPDATE studentInfo SET city = ? WHERE id = ?;";
			pstmt = connect.prepareStatement(query);
			
			pstmt.setString(1, "Banglore");
			pstmt.setInt(2, 1);
			pstmt.addBatch();
			
			pstmt.setString(1, "Kolkata");
			pstmt.setInt(2, 2);
			pstmt.addBatch();
			
			pstmt.setString(1, "Banglore");
			pstmt.setInt(2, 1);
			pstmt.addBatch();
			
			pstmt.setString(1, "Pune");
			pstmt.setInt(2, 3);
			pstmt.addBatch();
			
			int[] rowsAffected = pstmt.executeBatch();
			if(rowsAffected.length > 0) {
				System.out.println(rowsAffected.length + " batches updated successfully");
			} else {
				System.out.println("No batches updated!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCUtil.closeResources(connect, pstmt);
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
