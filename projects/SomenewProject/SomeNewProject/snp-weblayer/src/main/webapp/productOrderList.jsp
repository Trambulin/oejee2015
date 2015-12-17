<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>  
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.ProductOrderStub" %> 
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.ProductStub" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.CustomerStub" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.AttributeStub" %>
<% List<ProductOrderStub> productOrders = (List<ProductOrderStub>)request.getAttribute("productOrders"); %>
<% List<CustomerStub> customers = (List<CustomerStub>)request.getAttribute("customers"); %>
<% List<ProductStub> products = (List<ProductStub>)request.getAttribute("products"); %>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- <link rel="stylesheet" type="text/css" href="style/page.css" />	 -->
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.10/css/jquery.dataTables.min.css" />
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" />
	<title>SomeNewProject</title>
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
	
	<h2>ProductOrders</h2>
	<p>
		<table class="table-property table-striped">
			<tr>
				<th>Order Number</th>
				<th>Quantity</th>
				<th>Delivered</th>
				<th>Customer Name</th>
				<th>Product Serial</th>
				<th>Product Name</th>
			</tr>
			<% for (ProductOrderStub productOrder : productOrders) { %>
				<tr>
					<% CustomerStub customer = productOrder.getCustomer(); %>
					<% ProductStub product = productOrder.getProduct(); %>
					<td><% out.print(productOrder.getNumber()); %></td>
					<td><% out.print(productOrder.getQuantity()); %></td>
					<td><% out.print(productOrder.getDelivered()); %></td>	
					<td><% out.print(customer.getName()); %></td>
					<td><% out.print(product.getSerial()); %></td>
					<td><% out.print(product.getName()); %></td>
				</tr>
			<% } %>
		</table>
	</p>	
	
	<h2>New ProductOrder</h2>
	<form method="post" action="http://localhost:8080/somenewproject/api/productOrder/add">
		<table>
			<tr>
				<td>Customer</td>
				<td>
					<select name="input-customer">
						<% for (CustomerStub customer : customers) { %>
							<option value="<% out.print(customer.getId()); %>"><% out.print(customer.getName()); %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>Product</td>
				<td>
					<select name="input-product">
						<% for (ProductStub product : products) { %>
							<option value="<% out.print(product.getId()); %>"><% out.print(product.getName()); %></option>
						<% } %>
					</select>
				</td>
			</tr>
			<tr>
				<td>Quantity</td>
				<td><input type="text" name="input-quantity" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form>	
</body>
</html>