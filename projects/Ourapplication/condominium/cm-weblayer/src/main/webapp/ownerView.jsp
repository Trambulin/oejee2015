<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page import="hu.nik.condominium.ejbservice.domain.CondominiumStub" %>
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
<div><label>Email</label><span><% out.print(owner.getEmail()); %></span></div>
<div><label>Phone</label><span><% out.print(owner.getPhone()); %></span></div>
<%
    int i=1;
    for(CondominiumStub condominiumStub:  owner.getCondominiumStub()) {
        Long id=condominiumStub.getId();
        String name=condominiumStub.getLocation()+ "["+condominiumStub.getTypeName()+"]";
        String anchor="<a href=CondominiumView?id="+id+">"+name+"</a>";
        out.print("<div><label>#"+i+"</label>: </label><span>"+anchor+"</span></div>");
        i++;
    }
%>
<br/><br/>
<div><a href="OwnerListView">back to the whole list</a></div>
</body>
</html>