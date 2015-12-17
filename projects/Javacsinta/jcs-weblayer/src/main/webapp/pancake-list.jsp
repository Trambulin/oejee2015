<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<%@ page import="hu.oe.pancakestore.serviceclient.domain.PancakeStub"%>
<%
	List<PancakeStub> pancakes = (List<PancakeStub>) request.getAttribute("pancakes");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style/page.css" />
<title>List of pancakes</title>
</head>
<body>
	<div class="container">
		<div class="header">
			<h1>List of pancakes</h1>
		</div>
		<div class="nav">
			<a href="http://localhost:8080/jcs-weblayer/">Home</a> <a
				href="http://localhost:8080/jcs-weblayer/UILinks.jsp">Javacsinta
				- user links</a> <a
				href="http://localhost:8080/jcs-weblayer/MILinks.jsp">Javacsinta
				- management links</a>
		</div>
		<div class="article">
			<table class="listtable">
				<thead>
					<tr>
						<th>Name</th>
						<th>Price</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (PancakeStub pancake : pancakes) {
					%>
					<tr>
						<td><a href="Pancake?name=<%out.print(pancake.getName());%>">
								<%
									out.print(pancake.getName());
								%>
						</a></td>
						<td>
							<%
								out.print(pancake.getPrice());
							%> Ft
						</td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>