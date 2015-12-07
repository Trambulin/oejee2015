<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.OrderStub" %>
<%@ page import="java.text.NumberFormat" %>
<%@page import="java.text.SimpleDateFormat"%>
<%
	List<OrderStub> orders = (List<OrderStub>) request.getAttribute("orders");

%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>Rendelések | PC World webshop</title>
</head>
<body>
	<h1>PC World webshop rendelések</h1>
	
	<p><% out.print("Összesen " + orders.size() + " tétel"); %></p>
	
	<table class='list_table'>
		<tr>
			<th align="left" width="40px">ID</th>
			<th align="left" width="150px">Felhasználó</th>
			<th align="left">Rendelt termék</th>
			<th align="right" width="90px">Ár</th>
			<th align="center" width="120px">Rendelés ideje</th>
			<th align="center" width="120px">Beérkezés</th>
			<th align="center" width="60px">Átvéve</th>
		</tr>
	<%
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		for (OrderStub order : orders) {
			// Preformat price
			NumberFormat nf = NumberFormat.getInstance();
		    nf.setMaximumFractionDigits(0);
		    nf.setMinimumFractionDigits(0);
			String sPrice = nf.format(order.getPrice());
			
			// Format date
			String dateShippedOn = formatter.format(order.getShippedOn());
			String dateShipmentDue = formatter.format(order.getShipmentDue());
			
			
			boolean delivered = order.getDelivered();
			if (delivered)
			{
				out.print("<tr class='order_archived'>");
			} else {
				out.print("<tr>");
			}
			
			out.print("<td align=\"left\">" + order.getId() + "</td>");
			out.print("<td align=\"left\"><a href='Customer?id=" + order.getCustomer().getId() + "'>" + order.getCustomer().getLastName() + " " + order.getCustomer().getFirstName() + "</a></td>");
			out.print("<td align=\"left\"><a href='Product?id=" + order.getSupplier().getId() + "'>" + order.getSupplier().getName() + "</a></td>");
			out.print("<td align=\"right\">" + sPrice + " Ft</td>");
			out.print("<td align=\"center\">" + dateShippedOn + "</td>");
			out.print("<td align=\"center\">" + dateShipmentDue + "</td>");
			
			if (delivered) {
				out.print("<td align=\"center\">Igen</a></td>");
			} else {
				out.print("<td align=\"center\"><a href=\"/store/api/order/delivered-" + order.getId() + "\">[Nem]</a></td>");
			}
			
			out.print("</tr>");
		}
	%>
	</table>
	<p><a href="ProductList">Vissza</a></p>
</body>
</html>