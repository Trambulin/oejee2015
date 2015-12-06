<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.morkalla.gymproject.ejbservice.domain.TrainerStub" %> 
<% List<TrainerStub> trainers = (List<TrainerStub>) request.getAttribute("trainers"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Trainers ::</title>
</head>
<body>
	<h1>List of Trainers</h1>
	<table class="trainerstable">
		<thead>
			<tr>
				<th>Name</th>
				<th>Height</th>
				<th>Weight</th>
			</tr>
		</thead>
		<tbody>
			<% for ( TrainerStub trainer : trainers) { %>
				<tr>
					<td><a href="Trainer?name=<% out.print(trainer.getName()); %>"><% out.print(trainer.getName()); %></a></td>
					<td><% out.print(trainer.getHeight()); %> cm</td>
					<td><% out.print(trainer.getWeight()); %> kg</td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>