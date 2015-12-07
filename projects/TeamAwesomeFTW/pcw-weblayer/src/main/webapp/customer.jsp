<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.CustomerStub" %> 
<%@ page import="java.text.NumberFormat" %>
<% CustomerStub customer = (CustomerStub) request.getAttribute("customers"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title><% out.print(customer.getLastName() + " " + customer.getFirstName()); %> | PC World webshop</title>
</head>
<body>

		
	<h1>PC World webshop</h1>
	<h2><% out.print(customer.getLastName() + " " + customer.getFirstName()); %></h2>
	<p>
		<table>
			<tr>
				<td>Email:</td>
				<td><% out.print(customer.getEmail()); %></td>
			</tr>
			<tr>
				<td>Telefonszám:</td>
				<td><% out.print(customer.getTelephone()); %></td>
			</tr>
			<tr>
				<td>Cím:</td>
				<td><% out.print(customer.getAddress()); %></td>
			</tr>
			<tr>
				<td>Csatlakozott:</td>
				<td><% out.print(customer.getJoined()); %></td>
			</tr>
		</table>
	</p>
	<p><a href="OrderList">Vissza</a></p>
	
</body>
</html>