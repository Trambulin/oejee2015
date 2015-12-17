<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.ProductStub" %> 
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.AttributeStub" %> 
<% List<ProductStub> products = (List<ProductStub>)request.getAttribute("products"); %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- <link rel="stylesheet" type="text/css" href="style/page.css" />	 -->
	<title>SomeNewProject</title>
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
	
	<h2>Products</h2>
	<table class="table-property table-striped">
		<tr>
			<th>Serial</th>
			<th>Name</th>
			<th>Category</th>
			<th>Title</th>
			<th>Author</th>
			<th>Stock</th>			
		</tr>
		<% for ( ProductStub product : products ) { %>
		<tr>
			<td><% out.print(product.getSerial()); %></td>
			<td><% out.print(product.getName()); %></td>
			<td><% out.print(product.getCategory()); %></td>
			
			<% List<AttributeStub> attributes = product.getAttributes(); %>
			
			<% for (AttributeStub attribute : attributes) { %>
				<% if (attribute.getName().equals("title")) { %>
					<td><% out.print(attribute.getValue()); %></td>
				<% } %>
			<% } %>
			
			<% for (AttributeStub attribute : attributes) { %>
				<% if (attribute.getName().equals("author")) { %>
					<td><% out.print(attribute.getValue()); %></td>
				<% } %>
			<% } %>
			
			<% for (AttributeStub attribute : attributes) { %>
				<% if (attribute.getName().equals("stock")) { %>
					<td><% out.print(attribute.getValue()); %></td>
				<% } %>
			<% } %>				
			
		</tr>		
		<% } %>
	</table>
</body>
</html>