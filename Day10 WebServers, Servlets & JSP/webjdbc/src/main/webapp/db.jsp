<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DataBase</title>
</head>
<body>
	<%
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project1", "root", "root");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select * from employee");

		out.print("<table border='1'><tr><th> ID </th><th> Name </th><th> Password </th><th> Role </th></tr>");
		while (rs.next()) {
	%>
	<tr>
		<td><%=rs.getInt(1)%></td>
		<td><%=rs.getString(2)%></td>
		<td><%=rs.getString(3)%></td>
		<td><%=rs.getString(4)%></td>
	</tr>
	<%
	}
	out.print("</table>");
	rs.close();
	stmt.close();
	conn.close();

	} catch (SQLException se) {
	out.print(se.getMessage());
	}
	%>
</body>
</html>