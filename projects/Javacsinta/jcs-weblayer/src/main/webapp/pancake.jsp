<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.oe.pancakestore.serviceclient.domain.PancakeStub" %> 
<% PancakeStub pancake = (PancakeStub) request.getAttribute("pancake"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>Javacsinta - <% out.print(pancake.getName()); %></title>
</head>
<body>
	<h1><% out.print(pancake.getName()); %>: <% out.print(pancake.getPrice()); %>Ft</h1>
	<div><label>Description: </label><span><% out.print(pancake.getDescription()); %></span></div>
	<br/><br/>
	<div><a href="PancakeList">back</a></div>
</body>
</html>