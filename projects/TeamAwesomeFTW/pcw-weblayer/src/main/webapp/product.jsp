<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.ProductStub" %> 
<% ProductStub product = (ProductStub) request.getAttribute("products"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title><% out.print(product.getName()); %> | PC World webshop</title>
</head>
<body>
	<%
	out.print("<h1>" + product.getName() + "</h1>");
	//<div><a href="BookList">back</a></div>
	
	
	%>
	<div><a href="ProductList">back</a></div>
</body>
</html>