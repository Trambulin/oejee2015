<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.RepairStub" %>
<%@ page import="java.util.List" %>
<%@ page import="java.text.NumberFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.NotificationStub" %>
<% List<NotificationStub> stubs = (List<NotificationStub>) request.getAttribute("notifications"); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="style/page.css"/>
  <link href="bootstrap-3.2.0-dist/css/bootstrap.css" rel="stylesheet">
  <link href="my.css" rel="stylesheet">
  <title>:: Notifications ::</title>
</head>
<body>
<div class="panel panel-default">
  <div class="panel-heading">List of Notifications</div>
  <%--    <div class="panel-body">All repairs from every condominium</div>--%>
  <table class="table">
    <thead>
    <tr>
      <th>Message</th>
      <th>Answer</th>
      <th>Date</th>
    </tr>
    </thead>
    <tbody>
    <% for (NotificationStub stub : stubs) { %>
    <tr>
      <td><% out.print(stub.getMessage()); %></td>
      <td><% out.print(stub.getAnswer()); %></td>
      <td><% out.print(stub.getDate()); %></td>
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