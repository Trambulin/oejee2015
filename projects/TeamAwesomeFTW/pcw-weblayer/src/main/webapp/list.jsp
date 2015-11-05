<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.qwaevisz.pcworld.ejbservice.domain.ProductStub" %>
<% List<ProductStub> products = (List<ProductStub>) request.getAttribute("products"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: Books ::</title>
</head>
<body>
	<h1>List of products</h1>
	<table class="bookstable">
		<tbody>
			<% for ( ProductStub product : products) { %>
				<tr>
					<td><% out.print(product.getId()); %></td>
					<td><% out.print(product.getProductType()); %></td>
					<td><% out.print(product.getName()); %></td>
					<td><% out.print(product.getDescription()); %></td>
					<td><% out.print(product.getWarranty()); %></td>
					<td><% out.print(product.getPrice()); %></td>
					<td><% out.print(product.getManufacturer()); %></td>
					<td><% out.print(product.getShippingDays()); %></td>
				</tr>
			<% } %>
		</tbody>
	</table>
</body>
</html>