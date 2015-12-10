<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>  
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub" %> 
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.ProductStub" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.CustomerStub" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.AttributeStub" %>
<% ProductOrderStub productOrder = (ProductOrderStub)request.getAttribute("productOrder"); %>
<% CustomerStub customer = productOrder.getCustomer(); %>
<% ProductStub product = productOrder.getProduct(); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>SomeNewProject</title>
</head>
<body>
	<h2>ProductOrder - <% out.print(productOrder.getNumber()); %></h2>
	<p>
		<table class="table-property">
			<tr>
				<th>Order Number</th>
				<th>Quantity</th>
				<th>Delivered</th>
				<th>Customer Name</th>
				<th>Product Serial</th>
				<th>Product Name</th>
			</tr>
			<tr>
				<td><% out.print(productOrder.getNumber()); %></td>
				<td><% out.print(productOrder.getQuantity()); %></td>
				<td><% out.print(productOrder.getDelivered()); %></td>	
				<td><% out.print(customer.getName()); %></td>
				<td><% out.print(product.getSerial()); %></td>
				<td><% out.print(product.getName()); %></td>
			</tr>			
		</table>
	</p>	
</body>
</html>