<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.marcibbx.JEEzusom.ejbservice.domain.CharacterBaseStub" %> 
<% List<CharacterBaseStub> CharacterBases = (List<CharacterBaseStub>)request.getAttribute("characters"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>JEEzusom</title>
</head>
<body>
	<h2>Characters</h2>
	<table class="table-property">
		<tr>			
			<th>Name</th>
			<th>Experience</th>
			<th>MoneyAmount</th>
		</tr>
		<% for ( CharacterBaseStub CharacterBase : CharacterBases ) { %>
		<tr>			
			<td><% out.print(CharacterBase.getName()); %></td>
			<td><% out.print(CharacterBase.getExperience()); %></td>
			<td><% out.print(CharacterBase.getMoneyamount()); %></td>
		</tr>		
		<% } %>
	</table>
	
	
</body>
</html>