<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.List" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.CustomerStub" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.OrderStub" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	CustomerStub customer = (CustomerStub)request.getAttribute("customer");
	List<OrderStub> orders = (List<OrderStub>)request.getAttribute("orders");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title><% out.print(customer.getLastName() + " " + customer.getFirstName()); %> | PC World webshop</title>
</head>
<body><%
	
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	String dateJoined = formatter.format(customer.getJoined());
	
	%>	
	<h1>PC World webshop</h1>
	<h2>Vásárló - <% out.print(customer.getLastName() + " " + customer.getFirstName()); %></h2>
	<p>
		<table class="property_table">
			<tr>
				<td>Email:</td>
				<td><% out.print(customer.getEmail()); %></td>
			</tr>
			<tr>
				<td>Telefonszám:</td>
				<td><% out.print(customer.getTelephone()); %></td>
			</tr>
			<tr>
				<td>Cím:</td>
				<td><% out.print(customer.getAddress()); %></td>
			</tr>
			<tr>
				<td>Csatlakozott:</td>
				<td><% out.print(dateJoined); %></td>
			</tr>
		</table>
	</p>
	<table class='list_table'>
		<tr>
			<th align="left" width="40px">ID</th>
			<th align="left">Rendelt termék</th>
			<th align="right" width="120px">Fizetendő ár</th>
			<th align="center" width="120px">Rendelés ideje</th>
			<th align="center" width="120px">Beérkezés</th>
			<th align="center" width="150px">Átvéve</th>
		</tr>
	<%
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
			out.print("<td align=\"left\"><a href='Product?id=" + order.getSupplier().getId() + "'>" + order.getSupplier().getName() + "</a></td>");
			out.print("<td align=\"right\">" + sPrice + " Ft</td>");
			out.print("<td align=\"center\">" + dateShippedOn + "</td>");
			out.print("<td align=\"center\">" + dateShipmentDue + "</td>");
			
			if (delivered) {
				out.print("<td align=\"center\">Igen</a></td>");
			} else {
				out.print("<td align=\"center\">Nem <a href=\"/store/api/order/delivered-" + order.getId() + "\">[ÁTVESZ]</a></td>");
			}
			
			out.print("</tr>");
		}
	%>
	</table>
	<p><a href="CustomerList">Vissza</a></p>
	
</body>
</html>