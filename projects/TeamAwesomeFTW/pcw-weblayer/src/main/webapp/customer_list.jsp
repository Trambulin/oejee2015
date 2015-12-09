<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.CustomerStub" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.TypeStub" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	List<CustomerStub> customers = (List<CustomerStub>)request.getAttribute("customers");

%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>Vásárlovak | PC World webshop</title>
</head>
<body>
	<h1>PC World webshop</h1>
	<h2>Vásárlók</h2>
	
	<table class='list_table'>
		<tr>
			<th align="left" width="40px">ID</th>
			<th align="left">Vásárló</th>
			<th align="left" width="250px">Email</th>
			<th align="center" width="120px">Csatlakozás</th>
		</tr>
	<%
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	for (CustomerStub customer : customers)
	{
		out.print("<tr>");
		out.print("<td align=\"center\">" + customer.getId() + "</td>");
		out.print("<td align=\"left\"><a href='Customer?id=" + customer.getId() + "'>" + customer.getLastName() + " " + customer.getFirstName() + "</a></td>");
		out.print("<td align=\"left\">" + customer.getEmail() + "</td>");
		out.print("<td align=\"center\">" + formatter.format(customer.getJoined()) + "</td>");
		out.print("</tr>");
	}
	%>
	</table>
	<h2>Felhasználó hozzáadás</h2>
	<form id="frmAddUser" action="/store/api/customer/add" method="post">
		<label>Vezetéknév*: <input type="text" name="inpLastName" maxlength="32" /></label>
		<label>Keresztnév*: <input type="text" name="inpFirstName" maxlength="32" /></label>
		<label>Email*: <input type="text" name="inpEmail" maxlength="64" /></label>
		<label>Jelszó: <input type="password" name="inpPassword" maxlength="32" /></label>
		<label>Lakcím: <input type="text" name="inpAddress" maxlength="128" /></label>
		<label>Telefon: <input type="text" name="inpTelephone" maxlength="16" /></label>
		<input type="submit" value="Hozzáad" />
		*kötelező kitölteni
	</form>
	<p><a href="ProductList">Vissza</a></p>
</body>
</html>