<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Table Contents</title>
</head>
<body>
	<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
		user="root" password="root" url="jdbc:mysql://localhost:3306/project1" />
	<sql:query var="rs" dataSource="${ds}">select * from employee</sql:query>
	<a href="insertRecord.jsp">Add New Record</a>
	<table border='1'>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Password</th>
			<th>Role</th>
			<th>Actions</th>
		</tr>
		<core:forEach var="emp" items="${rs.rows}">
			<tr>
				<td><core:out value="${emp.id}"></core:out></td>
				<td><core:out value="${emp.name}"></core:out></td>
				<td><core:out value="${emp.password}"></core:out></td>
				<td><core:out value="${emp.role}"></core:out></td>
				<td><a href="editRecord.jsp?id=${emp.id}">Edit</a> || <a
					href="deleteRecord.jsp?id=${emp.id}">Delete</a></td>
			</tr>
		</core:forEach>
	</table>
</body>
</html>