<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.ProductStub" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.ProductTypeStub" %>
<%
	List<ProductStub> products = (List<ProductStub>) request.getAttribute("products");

%><!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>Kínálat | PC World webshop</title>
</head>
<body>
	<h1>PC World webshop kínálata</h1>
	<%
	ProductTypeStub lastType = ProductTypeStub.MOUSE;
	int i = 0;
	
	for ( ProductStub product : products) {
		ProductTypeStub type = product.getProductType();
		
		// put header
		if (type != lastType)
		{
			if (i > 0)
			{
				out.print("</tbody></table>");
			}
			out.print("<h2>" + type + "</h2>");
			lastType = type;
			
			out.print("<table class='list_table'></tbody>");
			
			out.print("<tr>");
			out.print("<th align=\"left\">Termék</th>");
			out.print("<th align=\"center\" width=\"90px\">Garancia</th>");
			out.print("<th align=\"right\" width=\"90px\">Ár</th>");
			out.print("<th align=\"center\" width=\"100px\">Beszállítás</th>");
			out.print("<th align=\"left\" width=\"150px\">Gyártó</th>");
			out.print("</tr>");
		}
		
		// Preformat
		int price = product.getPrice();
		String sPrice;
		if (price > 1000)
		{
			sPrice = Integer.toString(price / 1000) + "," + Integer.toString(price % 1000);
		}
		else
		{
			sPrice = Integer.toString(price);
		}
		
		
		// print entry
		out.print("<tr>");
		out.print("<td align=\"left\"><a href='Product?id=" + product.getId() + "'>" + product.getName() + "</a></td>");
		out.print("<td align=\"center\">" + product.getWarranty() + " hónap</td>");
		out.print("<td align=\"right\">" + sPrice + " Ft</td>");
		out.print("<td align=\"center\">" + product.getShippingDays() + " nap</td>");
		out.print("<td align=\"left\">" + product.getManufacturer() + "</td>");
		out.print("</tr>");
		
		i++;
	}
	out.print("</tbody></table>");
	%>
</body>
</html>