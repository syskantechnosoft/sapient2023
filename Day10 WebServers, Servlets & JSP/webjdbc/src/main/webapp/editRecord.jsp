<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Record</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	%>
	<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
		user="root" password="root" url="jdbc:mysql://localhost:3306/project1" />
	<sql:query var="rs" dataSource="${ds}">select * from employee where id = <%=id%></sql:query>
	<core:forEach items="${rs.rows}" var="emp">
		<table align="center" border="1">
			<form action="update.jsp">
				<tr>
					<th>sl No</th>
					<th>Property</th>
					<th>Value</th>
				</tr>
				<input type="hidden" name="id" value="${emp.id}" />
				<tr>
					<td>1.</td>
					<td>Employee Name :</td>
					<td><input type="text" name="name" value="${emp.name}"></td>
				</tr>
				<tr>
					<td>2.</td>
					<td>Password :</td>
					<td><input type="text" name="password" value="${emp.password}"></td>
				</tr>
				<tr>
					<td>3.</td>
					<td>Role :</td>
					<td><input type="text" name="role" value="${emp.role}"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="reset" value="ClearAll"></td>
					<td><input type="submit" value="Update Record"></td>
				</tr>
			</form>
		</table>
	</core:forEach>
</body>
</html>