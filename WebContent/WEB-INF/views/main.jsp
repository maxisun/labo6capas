<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SpringJPA</title>
</head>
<body>
	<table id="table" border=1>
		<tr>
			<th>Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Status</th>
		</tr>
			<c:forEach items="${students}" var="students">
				<tr>
					<td>${students.sName}</td>
					<td>${students.lName}</td>
					<td>${students.sAge}</td>
					<td>${students.activoDelegate}</td>
					<th><form  name="form1" action="${pageContext.request.contextPath}/edit" method="post">
            		<INPUT type="hidden" name="id" value=${students.cStudent}>
            		<INPUT type="Submit" value="Editar">
					</form></th>
				</tr>
			</c:forEach>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/deleteOne" method="post"> 
		<label>Delete: </label><input type="text" name="name"><br>
		<input type="submit" value="Delete">
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/save" method="post"> 
		<input type="submit" value="Add a new student">
	</form>
</body>
</html>