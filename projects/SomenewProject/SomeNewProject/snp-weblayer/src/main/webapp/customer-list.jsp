<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.CustomerStub" %> 
<% List<CustomerStub> customers = (List<CustomerStub>)request.getAttribute("customers"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>SomeNewProject</title>
</head>
<body>
	<h2>Customers</h2>
	<table class="table-property">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Password</th>
			<th>Role</th>
		</tr>
		<% for ( CustomerStub customer : customers ) { %>
		<tr>
			<td><% out.print(customer.getId()); %></td>
			<td><% out.print(customer.getName()); %></td>
			<td><% out.print(customer.getPassword()); %></td>
			<td><% out.print(customer.getRole()); %></td>
		</tr>		
		<% } %>
	</table>
	
	<br /><br />
	
	<h2>New Customer</h2>
	<form method="post" action="http://localhost:8080/somenewproject/api/customer/add">
		<table>
			<tr>
				<td>Name</td>
				<td><input type="text" name="input-name" required="required" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="input-password" required="required" /></td>
			</tr>
			<tr>
				<td>Category</td>
				<td>
					<select name="input-role">
						<option value="CUSTOMER">Customer</option>
						<option value="ADMINISTRATOR">Administrator</option>
					</select>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</table>
</body>
</html>