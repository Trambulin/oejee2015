<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.qwaevisz.bookstore.serviceclient.domain.CustomerStub" %> 
<% CustomerStub customer = (CustomerStub) request.getAttribute("customer"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: <% out.print(customer.getName()); %> ::</title>
</head>
<body>
	<h1><% out.print(customer.getName()); %>: <% out.print(customer.getPhone()); %></h1>
	<div><label>Payment Method: </label><span><% out.print(customer.getPaymentmethod()); %></span></div>
	<div><label>Email: </label><span><% out.print(customer.getEmail()); %></span></div>
	<div><label>Details: </label><span><% out.print(customer.getDetails()); %></span></div>
	<br/><br/>
	<div><a href="CustomerList">back</a></div>
</body>
</html>