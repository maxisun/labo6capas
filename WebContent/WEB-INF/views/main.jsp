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
					<td><button  onClick = "editar(this)">Editar</button></td>
				</tr>
			</c:forEach>
	</table>
	<br>
	<form action="${pageContext.request.contextPath}/findOne" method="post"> 
		<label>Search: </label><input type="number" name="id"><br>
		<input type="submit" value="Enviar">
	</form>
	<br>
	<form action="${pageContext.request.contextPath}/save" method="post"> 
		<input type="submit" value="Add a new student">
	</form>
	<script type="text/javascript">
	function editar(td){
		selectedRow = td.parentElement.parentElement;
		let estado;
		if(selectedRow.cells[3].innerHTML=='Activo'){
			estado = true;
		} else {
			estado = false;
		}
		let student = {
				sName: selectedRow.cells[0].innerHTML,
				lName: selectedRow.cells[1].innerHTML,
				sAge: parseInt(selectedRow.cells[2].innerHTML),
				bActivo: estado
		};
		
		
		//enviando
		var url = "http://localhost:8079/labo6/edit";

		var json = JSON.stringify(student);
		console.log(json);

	/*	var xhr = new XMLHttpRequest();
		xhr.open("POST", url, true);
		xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
		xhr.onload = function () {
			var users = JSON.parse(xhr.responseText);
			if (xhr.readyState == 4 && xhr.status == "201") {
				//console.table(users);
				console.log("success")
			} else {
				console.log("error")
			}
		}
		xhr.send(json);
		*/
		let config = new Request("${pageContext.request.contextPath}/edit", {
				method: 'POST',
				headers: {
						'Content-Type': 'application/json'
				},
				body: json,
				mode: 'cors',
				redirect: 'follow'					
		})

		fetch(config).then(res=>{
			
		}).catch((err)=>{
			console.log(err)
		})
		
	}


	</script>
</body>
</html>