<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ page import="hu.nik.condominium.ejbservice.domain.RepairStub" %>
<%@ page import="java.util.List" %>
<% List<RepairStub> repairs = (List<RepairStub>) request.getAttribute("repairs"); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="style/page.css" />
  <title>:: Repairs ::</title>
</head>
<body>
<h1>List of Repairs</h1>
<table class="bookstable">
  <thead>
  <tr>
    <th>Price</th>
    <th>Location</th>
    <th>Date</th>
  </tr>
  </thead>
  <tbody>
  <% for ( RepairStub stub : repairs) { %>
  <tr>
    <td><% out.print(stub.getPrice()); %></td>
    <td><a href="CondominiumView?id=<%out.println(stub.getCondominiumLocation().getId());%>"><% out.print(stub.getCondominiumLocation().getLocation()); %></a></td>
    <td><% out.print(stub.getDate()); %></td>
  </tr>
  <% } %>
  </tbody>
</table>
</body>
</html>