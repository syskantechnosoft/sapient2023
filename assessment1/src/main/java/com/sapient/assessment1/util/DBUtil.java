package com.sapient.assessment1.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

	private static Connection connection;
	private static Statement statement;
	private static PreparedStatement preparedStatement;
	private static ResultSet resultSet;

	private final static String DB_URL = "jdbc:mysql://localhost:3306/sapient";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return connection;
	}

	public static void closeResources() {
		try {
			if (resultSet != null)
				resultSet.close();
			if (preparedStatement != null)
				preparedStatement.close();
			if (statement != null)
				statement.close();
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
