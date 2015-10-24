<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.OwnerStub" %>
<% OwnerStub owner = (OwnerStub) request.getAttribute("owner"); %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/page.css"/>
    <title>:: <% out.print(owner.getName()); %> ::</title>
</head>
<body>
<h1>OWNER</h1>

<div><label>Name: </label><span><% out.print(owner.getName()); %></span></div>
<div><label>Gender: </label><span><% out.print(owner.getGender());%></span></div>
<div><label>Email</label>: </label><span><% out.print(owner.getEmail()); %></span></div>
<div><label>Phone</label>: </label><span><% out.print(owner.getPhone()); %></span></div>
<br/><br/>
<%--<div><a href="OwnerList">back</a></div>--%>
</body>
</html>