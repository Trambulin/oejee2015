<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.CondominiumStub" %>
<%@ page import="java.util.List" %>
<% List<CondominiumStub> condominiums = (List<CondominiumStub>) request.getAttribute("condominiums"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/page.css"/>
    <link href="bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet">
    <title>:: Condominiums ::</title>
</head>
<body>
<div class="panel panel-default">
    <div class="panel-heading">List of Condominiums</div>
    <table class="table">
        <thead>
        <tr>
            <th>Id</th>
            <th>Location</th>
            <th>Type</th>
            <th>Floors</th>
            <th>Year</th>

        </tr>
        </thead>
        <tbody>
        <% for (CondominiumStub stub : condominiums) { %>
        <tr>
            <td>#<% out.print(stub.getId()); %></td>
            <td><% out.print(stub.getLocation()); %></td>
            <td><% out.print(stub.getTypeName()); %></td>
            <td><% out.print(stub.getFloors()); %></td>
            <td><% out.print(new java.sql.Date(stub.getBuildYear().getTime())); %></td>

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