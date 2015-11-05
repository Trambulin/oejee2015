<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.UserStub" %>
<% UserStub user = (UserStub) request.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="style/page.css"/>
    <title>:: <% out.print(user.getLogin()); %> ::</title>
</head>
<body>
<h1>USER</h1>

<div><label>Login: </label><span><% out.print(user.getLogin()); %></span></div>
<div><label>Email</label><span><% out.print(user.getEmail()); %></span></div>
<div><label>Full Name:</label><span><% out.print(user.getFullName()); %></span></div>

<br/><br/>
<div><a href="userListView">back to the whole list</a></div>
</body>
</html>