<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find One</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
		<tr>
			<td>${student.cStudent}</td>
			<th>${student.sName}</th>
			<th>${student.lName}</th>
			<th>${student.sAge}</th>
			<th>${student.activoDelegate}</th>
		</tr>
	</table>
</body>
</html>