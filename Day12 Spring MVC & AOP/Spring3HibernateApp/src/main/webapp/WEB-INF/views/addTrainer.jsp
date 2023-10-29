<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Add Trainer Data</h2>
	<form:form method="POST" action="saveTrainer.html">
		<table>
			<tr>
				<td><form:label path="id">Trainer ID:</form:label></td>
				<td><form:input path="id" value="${trainer.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Trainer Name:</form:label></td>
				<td><form:input path="name" value="${trainer.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="email">Trainer Email:</form:label></td>
				<td><form:input path="email" value="${trainer.email}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty trainers}">
		<h2>List Trainers</h2>
		<table align="left" border="1">
			<tr>
				<th>Trainer ID</th>
				<th>Trainer Name</th>
				<th>Trainer Email</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${trainers}" var="trainer">
				<tr>
					<td><c:out value="${trainer.id}" /></td>
					<td><c:out value="${trainer.name}" /></td>
					<td><c:out value="${trainer.email}" /></td>
					<td align="center"><a href="editTrainer.html?id=${trainer.id}">Edit</a>
						| <a href="deleteTrainer.html?id=${trainer.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>