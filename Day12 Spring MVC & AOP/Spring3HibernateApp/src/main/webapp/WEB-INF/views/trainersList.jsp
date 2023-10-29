<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Trainers</title>
</head>
<body>
	<h1>List Trainers</h1>
	<h3>
		<a href="addTrainer.html">Add More Trainer</a>
	</h3>

	<c:if test="${!empty trainers}">
		<table align="left" border="1">
			<tr>
				<th>Trainer ID</th>
				<th>Trainer Name</th>
				<th>Trainer Email</th>

			</tr>

			<c:forEach items="${trainers}" var="trainer">
				<tr>
					<td><c:out value="${trainer.id}" /></td>
					<td><c:out value="${trainer.name}" /></td>
					<td><c:out value="${trainer.email}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>