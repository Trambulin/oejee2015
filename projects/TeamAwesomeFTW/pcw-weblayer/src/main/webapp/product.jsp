<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.StorageStub" %> 
<%@ page import="java.text.NumberFormat" %>
<% StorageStub product = (StorageStub) request.getAttribute("products"); %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title><% out.print(product.getSupplier().getName()); %> | PC World webshop</title>
</head>
<body><%
		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(0);
		nf.setMinimumFractionDigits(0);
		String sPrice = nf.format(product.getPrice());
	%>
	<h1>PC World webshop</h1>
	<h2><% out.print(product.getSupplier().getName()); %></h2>
	<p>
		<table>
			<tr>
				<td>Ár:</td>
				<td><% out.print(nf.format(product.getPrice())); %> Ft</td>
			</tr>
			<tr>
				<td>Beszállítás:</td>
				<td><% out.print(product.getSupplier().getShippingDays()); %> nap</td>
			</tr>
			<tr>
				<td>Garancia:</td>
				<td><% out.print(product.getSupplier().getWarranty()); %> hónap</td>
			</tr>
			<tr>
				<td>Raktáron:</td>
				<td><% out.print(product.getQuantity()); %> db</td>
			</tr>
			<tr>
				<td>Gyártó:</td>
				<td><% out.print(product.getSupplier().getManufacturer().getName()); %></td>
			</tr>
			<tr>
				<td>Gyártó tel.:</td>
				<td><% out.print(product.getSupplier().getManufacturer().getTelephone()); %></td>
			</tr>
		</table>
	</p>
	<p><a href="ProductList">Vissza</a></p>
</body>
</html>