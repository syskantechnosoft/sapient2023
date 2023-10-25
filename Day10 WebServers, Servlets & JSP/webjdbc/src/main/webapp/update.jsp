<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	String name = request.getParameter("name");
	String password = request.getParameter("password");
	String role = request.getParameter("role");
	%>
	<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
		user="root" password="root" url="jdbc:mysql://localhost:3306/project1" />
	<sql:update dataSource="${ds}" var="result"> update employee set name = ?, password = ?, role=? where id = ?
	<sql:param value="<%=name%>"></sql:param>
		<sql:param value="<%=password%>"></sql:param>
		<sql:param value="<%=role%>"></sql:param>
		<sql:param value="<%=id%>"></sql:param>
	</sql:update>
	<%
	response.sendRedirect("showTable.jsp");
	%>

</body>
</html>