<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Record</title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	%>
	<sql:setDataSource var="ds" driver="com.mysql.cj.jdbc.Driver"
		user="root" password="root" url="jdbc:mysql://localhost:3306/project1" />
	<sql:update dataSource="${ds}" var="result"> delete from employee where id = ?
	<sql:param value="<%=id%>"></sql:param>
	</sql:update>

	<%
	response.sendRedirect("showTable.jsp");
	%>
</body>
</html>