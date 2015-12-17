<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.CustomerStub" %> 
<% List<CustomerStub> customers = (List<CustomerStub>)request.getAttribute("customers"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>SomeNewProject</title>
	<!-- <link rel="stylesheet" type="text/css" href="style/page.css" />	 -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" />	
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
</head>

<body>
	<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
	<script src="https://cdn.datatables.net/1.10.10/js/jquery.dataTables.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script>
		$(document).ready(function(){
			$('.table-property').DataTable();
		});
	</script>
	
	<h2>Customers</h2>
	<table class="table-property table-striped">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Password</th>
			<th>Role</th>
		</tr>
		<% for ( CustomerStub customer : customers ) { %>
		<tr>
			<td><a href="http://localhost:8080/snp-weblayer/Customer?id=<% out.print(customer.getId()); %>"><% out.print(customer.getId()); %></a></td>
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