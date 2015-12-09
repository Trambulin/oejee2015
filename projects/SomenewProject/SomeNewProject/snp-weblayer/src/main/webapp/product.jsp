<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>  
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.ProductStub" %> 
<%@ page import="hu.shruikan.somenewproject.ejbservice.domain.AttributeStub" %>
<% ProductStub product = (ProductStub)request.getAttribute("product"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>SomeNewProject</title>
</head>
<body>
	<h2>Product - <% out.print(product.getName()); %></h2>
	<p>
		<table class="table-property">
			<tr>
				<th>Name</th>
				<th>Serial</th>
				<th>Category</th>
				<th>Title</th>
				<th>Author</th>
				<th>Stock</th>
			</tr>
			<tr>
				<td><% out.print(product.getName()); %></td>
				<td><% out.print(product.getSerial()); %></td>
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
		</table>
	</p>	
</body>
</html>