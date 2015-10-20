<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.domain.CarStub" %> 
<% List<CarStub> cars = (List<CarStub>) request.getAttribute("cars"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Cars ::</title>
</head>
<body>
	<h1>List of Cars</h1>
	<table class="carstable">
		<thead>
			<tr>
				<th>Brand</th>
				<th>Model</th>
				<th>Fuel</th>
				<th>Color</th>
				<th>Price</th>
				<th>Production Date</th>
			</tr>
		</thead>
		<tbody>
			<% for ( CarStub car : cars) { %>
				<tr>
					<td><% out.print(car.getBrand()); %></td>
					<td><% out.print(car.getModel()); %></a></td>
					<td><% out.print(car.getFuel()); %></td>
					<td><% out.print(car.getColor()); %></td>
					<td><% out.print(car.getPrice()); %> Ft</td>
					<td><% out.print(car.getProduction()); %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>