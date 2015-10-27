<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Set" %>  
<%@page import="hu.domain.CarStub" %> 
<% CarStub car = (CarStub) request.getAttribute("car"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: <% out.print(car.getBrand().toString()+" "+car.getModel()); %> ::</title>
</head>
<body>
	<h1><% out.print(car.getBrand().toString()); %>: <% out.print(car.getModel()); %></h1>
	<div><label>Fuel: </label><span><% out.print(car.getFuel()); %></span></div>
	<div><label>Color: </label><span><% out.print(car.getColor()); %></span></div>
	<div><label>Price: </label><span><% out.print(car.getPrice()); %> Ft</span></div>
	<div><label>Production date: </label><span><% out.print(car.getProduction()); %></span></div>	
	<br/><br/>
	<div><a href="CarList">back</a></div>
</body>
</html>