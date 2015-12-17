<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.CustomerStub" %> 
<% CustomerStub customer = (CustomerStub)request.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="style/page.css" />
	<title>SomeNewProject</title>
</head>
<body>
	<h2>Customer - <% out.print(customer.getName()); %></h2>
	<p>
		<table class="table-property">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Password</th>
				<th>Role</th>
			</tr>
			<tr>
				<td><% out.print(customer.getId()); %></td>
				<td><% out.print(customer.getName()); %></td>
				<td><% out.print(customer.getPassword()); %></td>
				<td><% out.print(customer.getRole()); %></td>
			</tr>			
		</table>
	</p>	
</body>
</html>