<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.marcibbx.JEEzusom.ejbservice.domain.AccountStub" %> 
<% List<AccountStub> accounts = (List<AccountStub>)request.getAttribute("accounts"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>JEEzusom</title>
</head>
<body>
	<h2>accounts</h2>
	<table class="table-property">
		<tr>
			<th>Id</th>		
			<th>First Name</th>
			<th>Last Name</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
		</tr>
		<% for ( AccountStub account : accounts ) { %>
		<tr>	
			<td><% out.print(account.getId()); %></td>		
			<td><a href="http://localhost:8080/jee-weblayer/listcharacters?accountId=<%out.print(account.getId());%>"><% out.print(account.getFirstName()); %></a></td>
			<td><% out.print(account.getLastName()); %></td>
			<td><% out.print(account.getName()); %></td>
			<td><% out.print(account.getEmail()); %></td>
			<td><% out.print(account.getPassword()); %></td>
		</tr>		
		<% } %>
	</table>
	
	<br /><br />
	
	<h2>New account</h2>
	<form method="post" action="http://localhost:8080/JEEzusom/api/account/addaccount">
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstName" required="required" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastName" required="required" /></td>
			</tr>
			<tr>
				<td>Name</td>
				<td><input type="text" name="name" required="required" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="email" required="required" /></td>
			</tr>
				<td>Password</td>
				<td><input type="text" name="password" required="required" /></td>
			</tr>			
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</table>
</body>
</html>