<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.morkalla.gymproject.ejbservice.domain.TrainerStub" %> 
<% TrainerStub trainer = (TrainerStub) request.getAttribute("trainer"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>:: <% out.print(trainer.getName()); %> ::</title>
</head>
<body>
	<h1><% out.print(trainer.getName()); %></h1>
	<div><label>Height: </label><span><% out.print(trainer.getHeight()); %> cm</span></div>
	<div><label>Weight: </label><span><% out.print(trainer.getWeight()); %> kg</span></div>
	<br/><br/>
	<div><a href="TrainerList">back</a></div>
</body>
</html>