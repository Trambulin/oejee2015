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
<body>
	<h1>PC World webshop</h1>
	<h2><% out.print(product.getSupplier().getName()); %></h2>
	<p>
		<table class="property_table">
		<%
			NumberFormat nf = NumberFormat.getInstance();
		    nf.setMaximumFractionDigits(0);
		    nf.setMinimumFractionDigits(0);
			String sPrice = nf.format(product.getPrice());
			
			long customerId = 1;
			long supplierId = product.getSupplier().getId();
			
			int q_max = product.getQuantity();
			int q_free = q_max - product.getQuantityReserved();
				
			
			out.print("<tr><td>Ár:</td><td>" + nf.format(product.getPrice()) + " Ft</td></tr>");
			out.print("<tr><td>Garancia:</td><td>" + product.getSupplier().getWarranty() + " hónap</td></tr>");
			out.print("<tr><td>Raktáron:</td><td>" + q_free + "/" + q_max + " db</td></tr>");
			out.print("<tr><td>Beszállítás:</td><td>" + product.getSupplier().getShippingDays() + " nap</td></tr>");
			out.print("<tr><td>Gyártó:</td><td>" + product.getSupplier().getManufacturer().getName() + "</td></tr>");
			out.print("<tr><td>Gyártó tel.:</td><td>" + product.getSupplier().getManufacturer().getTelephone() + "</td></tr>");
			
			out.print("<tr><td colspan='2' style='text-align:center'><a href='/store/api/order/place-c" + customerId + "-p" + supplierId + "'>[megrendel]</a></td></tr>");
		%>
		</table>
	</p>
	<p><a href="ProductList">Vissza</a></p>
</body>
</html>