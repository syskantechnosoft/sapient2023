package com.sapient;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLJDBC {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		// Step 1: Load & Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");

		// Step 3 : Create & Execute the Query
		Statement stmt = conn.createStatement();

		// Step 4 : Process the Result
		ResultSet rs = stmt.executeQuery("select * from employee");

		while (rs.next()) {
			System.out.println(
					rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString(3) + " " + rs.getString("role"));
		}

		// Step 5 : Disconnect
		rs.close();
		stmt.close();
		conn.close();
	}

}
