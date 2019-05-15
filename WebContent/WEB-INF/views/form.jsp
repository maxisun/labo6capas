<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ingrese Estudiante</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/formData" method="POST" modelAttribute="student">
		
		<label>Ingrese un nombre: </label>
		<form:input type="text" name="name" path="sName"/><br>
		
		<label>Ingrese un apellido: </label>
		<form:input type="text" name="lname" path="lName"/><br>
		
		<label>Ingrese edad: </label>
		<form:input type="number" name="age" path="sAge"/><br>
		
		<label>Estado del estudiante</label><br>
		<form:radiobutton name="status" path="bActivo" value="true"/><label>Activo</label><br>
		<form:radiobutton name="status" path="bActivo" value="false"/><label>Inactivo</label><br>
		
		<input type="submit" value="Agregar estudiante">
	</form:form>
</body>
</html>