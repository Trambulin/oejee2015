<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.RepairStub" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<% List<RepairStub> repairs = (List<RepairStub>) request.getAttribute("repairs"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/page.css"/>
    <link href="bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet">
    <link href="my.css" rel="stylesheet">
    <title>:: Repairs ::</title>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">List of Repairs</div>
<%--    <div class="panel-body">All repairs from every condominium</div>--%>
    <table class="table">
        <thead>
        <tr>
            <th>Date</th>
            <th>Location</th>
            <th>Price</th>
        </tr>
        </thead>
        <tbody>
        <% for (RepairStub stub : repairs) { %>
        <tr>
            <td><% out.print(stub.getDate()); %></td>
            <td><a href="CondominiumView?id=<%out.println(stub.getCondominiumLocation().getId());%>"><%
                out.print(stub.getCondominiumLocation().getLocation()); %></a></td>
            <td><% out.print(NumberFormat.getInstance(Locale.ENGLISH).format(stub.getPrice())); %></td>
        </tr>
        <% } %>
        </tbody>
    </table>
</div>
<script src="bootstrap-3.2.0-dist/js/jquery-1.11.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="bootstrap-3.2.0-dist/js/bootstrap.min.js"></script>
</body>
</html>