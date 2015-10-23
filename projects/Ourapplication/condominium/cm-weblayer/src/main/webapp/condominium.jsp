<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="hu.nik.condominium.ejbservice.domain.CondominiumStub" %>
<% CondominiumStub condominium = (CondominiumStub) request.getAttribute("condominium"); %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="style/page.css" />
  <title>:: <% out.print(condominium.getLocation()); %> ::</title>
</head>
<body>
<h1><% out.print(condominium.getLocation()); %>></h1>
<div><label>Build year: </label><span><% out.print(condominium.getBuildYear()); %></span></div>
<div><label>Floors: </label><span><% out.print(condominium.getFloors()); %></span></div>
<div><label>Type</label>: </label><span><% out.print(condominium.getTypeName()); %></span></div>
<br/><br/>
<div><a href="CondominiumList">back</a></div>
</body>
</html>