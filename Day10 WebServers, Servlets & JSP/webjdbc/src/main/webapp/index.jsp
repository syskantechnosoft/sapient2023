<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JDBC CRUD</title>
</head>
<body>

	<%
	try {
		// Step 1: Load & Register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Step 2: Establish the connection
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");

		// Step 3 : Create & Execute the Query
		Statement stmt = conn.createStatement();

		// Step 4 : Process the Result
		ResultSet rs = stmt.executeQuery("select * from employee");

		while (rs.next()) {
			out.println(
			rs.getInt(1) + " " + rs.getString("name") + " " + rs.getString(3) + " " + rs.getString("role"));
		}

		// Step 5 : Disconnect
		rs.close();
		stmt.close();
		conn.close();

	} catch (SQLException se) {
		out.print(se.getMessage());
	}
	%>


</body>
</html>