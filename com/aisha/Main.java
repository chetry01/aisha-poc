package com.aisha;

import java.sql.*;

public class Main {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/my_database"; // replace with your DB name
		String user = "root"; // MySQL username
		String password = "root"; // MySQL password

		try {
			// Load JDBC driver (optional for newer versions)
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Connect to MySQL
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to MySQL!");

			// Create a statement
			Statement stmt = conn.createStatement();

			// Execute query
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");

			// Process results
			while (rs.next()) {
				System.out.println(rs.getInt("id") + " | " + rs.getString("name") + " | " + rs.getString("email"));
			}

			// Close connections
			rs.close();
			stmt.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
