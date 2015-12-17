<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.oe.pancakestore.serviceclient.domain.CustomerStub" %> 
<% List<CustomerStub> customers = (List<CustomerStub>) request.getAttribute("customers"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Customers ::</title>
</head>
<body>
	<h1>List of Customers</h1>
	<table class="customerstable">
		<thead>
			<tr>
				<th>Name</th>
				<th>Phone</th>
<!-- 				<th>Payment Method</th> -->
				<th>Email</th>
				<th>Details</th>
			</tr>
		</thead>
		<tbody>
			<% for ( CustomerStub customer : customers) { %>
				<tr>
					<td><a href="Customer?name=<% out.print(customer.getName()); %>"><% out.print(customer.getName()); %></td>
					<td><% out.print(customer.getPhone()); %></td>
					<!-- <td><%// out.print(customer.getPaymentmethod()); %></td>-->
					<td><% out.print(customer.getEmail()); %></td>
					<td><% out.print(customer.getDetails()); %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>