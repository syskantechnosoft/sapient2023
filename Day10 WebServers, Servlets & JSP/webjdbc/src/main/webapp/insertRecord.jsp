<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert Record</title>
</head>
<body>
	<table>
		<form action="insert.jsp">
			<tr>
				<th>sl No</th>
				<th>Property</th>
				<th>Value</th>
			</tr>			
			<tr>
				<td>1.</td>
				<td>Employee Name :</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>2.</td>
				<td>Password :</td>
				<td><input type="text" name="password"></td>
			</tr>
			<tr>
				<td>3.</td>
				<td>Role :</td>
				<td><input type="text" name="role"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="ClearAll"></td>
				<td><input type="submit" value="Insert Record"></td>
			</tr>
		</form>
	</table>
</body>
</html>