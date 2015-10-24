<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.OwnerStub" %>
<%@ page import="java.util.List" %>
<% List<OwnerStub> owners = (List<OwnerStub>) request.getAttribute("owners"); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="style/page.css"/>
  <link href="bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet">
  <link href="my.css" rel="stylesheet">
  <title>:: Owners ::</title>
</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">List of owners</div>
  <table class="table">
    <thead>
    <tr>
      <th>Name</th>
      <th>Gender</th>
      <th>Email</th>
      <th>Profile</th>
    </tr>
    </thead>
    <tbody>
    <% for (OwnerStub stub : owners) { %>
    <tr>
      <td><% out.print(stub.getName()); %></td>
      <td><% out.print(stub.getGender()); %></td>
      <td><% out.print(stub.getEmail()); %></td>
      <%
        Long id=stub.getId();
        String anchor="<a href=OwnerView?id="+id+">See full profile</a>";
      %>
      <td><%out.print(anchor);%></td>
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