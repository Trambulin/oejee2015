<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.Set" %>  
<%@ page import="java.util.List" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.ProductStub" %>
<%@ page import="hu.teamawesome.pcworld.ejbservice.domain.TypeStub" %>
<%@ page import="java.text.NumberFormat" %>
<%
	List<ProductStub> products = (List<ProductStub>)request.getAttribute("products");

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
	long lastType = -1;
	int i = 0;
	
	for ( ProductStub product : products) {
		TypeStub type = product.getProductType();
		
		// put header
		if (type.getId() != lastType)
		{
			if (i > 0)
			{
				out.print("</tbody></table>");
			}
			out.print("<h2>" + type.getName() + "</h2>");
			lastType = type.getId();
			
			out.print("<table class='list_table'></tbody>");
			
			out.print("<tr>");
			out.print("<th align=\"left\">Termék</th>");
			out.print("<th align=\"center\" width=\"90px\">Garancia</th>");
			out.print("<th align=\"right\" width=\"90px\">Ár</th>");
			out.print("<th align=\"center\" width=\"100px\">Beszállítás</th>");
			out.print("<th align=\"left\" width=\"180px\">Gyártó</th>");
			out.print("</tr>");
		}
		
		// Preformat
		NumberFormat nf = NumberFormat.getInstance();
	    nf.setMaximumFractionDigits(0);
	    nf.setMinimumFractionDigits(0);
		String sPrice = nf.format(product.getPrice());
		
		
		// print entry
		out.print("<tr>");
		out.print("<td align=\"left\"><a href='Product?id=" + product.getId() + "'>" + product.getName() + "</a></td>");
		out.print("<td align=\"center\">" + product.getWarranty() + " hónap</td>");
		out.print("<td align=\"right\">" + nf.format(product.getPrice()) + " Ft</td>");
		out.print("<td align=\"center\">" + product.getShippingDays() + " nap</td>");
		out.print("<td align=\"left\">" + product.getManufacturer().getName() + "</td>");
		out.print("</tr>");
		
		i++;
	}
	out.print("</tbody></table>");
	%>
</body>
</html>