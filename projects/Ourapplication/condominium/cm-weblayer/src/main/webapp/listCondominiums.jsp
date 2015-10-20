<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.CondominiumStub" %> 
<% List<CondominiumStub> condominiums = (List<CondominiumStub>) request.getAttribute("condominiums"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Condominiums ::</title>
</head>
<body>
	<h1>List of Condominiums</h1>
	<table class="bookstable">
		<thead>
			<tr>
				<th>Id</th>
				<th>Location</th>
				<th>Type</th>
				<th>Floors</th>
				<th>Year</th>

			</tr>
		</thead>
		<tbody>
			<% for ( CondominiumStub stub : condominiums) { %>
				<tr>
					<td>#<% out.print(stub.getId()); %></td>
					<td><% out.print(stub.getLocation()); %></td>
					<td><% out.print(stub.getTypeName()); %></td>
					<td><% out.print(stub.getFloors()); %></td>
					<td><% out.print(stub.getBuildYear().toString()); %></td>

				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>