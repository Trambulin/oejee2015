<%@page import="hu.morkalla.gymproject.ejbservice.domain.TrainerQualificationStub"%>
<%@page import="hu.morkalla.gymproject.ejbservice.domain.TrainerContactStub"%>
<%@page import="hu.morkalla.gymproject.persistence.entity.TrainerContact"%>
<%@page import="hu.morkalla.gymproject.persistence.entity.TrainerQualification"%>
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
	
	<div><label>Contacts: </label>
	<table>
	<tr>
		<td>Type</td>
		<td>Value</td>
	</tr>
	<% for (TrainerContactStub tc :trainer.getTrainerContacts() ){ 	%>	
		<tr>
			<td><% out.print(tc.getType());	 %></td>
			<td><% out.print(tc.getValue()); %></td>
		</tr>	
	<% } %>	
	 </table>	
	</div>
	
	<div><label>Qualifications: </label>
	<table>
	<tr>
		<td>Name</td>
		<td>Level</td>
		<td>Year</td>
	</tr>
	<% for (TrainerQualificationStub tq :trainer.getTrainerQualifications() ){ 	%>	
		<tr>
			<td><% out.print(tq.getName());	 %></td>
			<td><% out.print(tq.getLevel()); %></td>
			<td><% out.print(tq.getYear()); %></td>
		</tr>	
	<% } %>	
	 </table>	
	</div>
	
	<br/><br/>
	<div><a href="TrainerList">back</a></div>
</body>
</html>