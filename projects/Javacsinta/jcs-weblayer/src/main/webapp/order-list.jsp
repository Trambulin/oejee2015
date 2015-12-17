<%@page import="hu.oe.pancakestore.serviceclient.domain.OrderItemStub"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Set"%>
<%@ page import="java.util.List"%>
<%@ page
	import="hu.oe.pancakestore.serviceclient.domain.OrderHeaderStub"%>
<%
	List<OrderHeaderStub> orders = (List<OrderHeaderStub>) request.getAttribute("orders");
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
			<h1>List of orders</h1>
		</div>
		<div class="nav">
			<a href="http://localhost:8080/jcs-weblayer/">Home</a><a
				href="http://localhost:8080/jcs-weblayer/MILinks.jsp">Javacsinta
				- management links</a>
		</div>
		<div class="article">
			<table class="listtable">
				<thead>
					<tr>
						<th>Customer name</th>
						<th>Employee name</th>
						<th>Customer name</th>
						<th>Delivery Status</th>
						<th>Date</th>
						<th>Payment method</th>
						<th>Total price</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (OrderHeaderStub order : orders) {
					%>
					<tr>
						<td>
							<%
								out.print(order.getCustomer().getName());
							%>
						</td>
						<td>
							<%
								out.print(order.getEmployee().getName());
							%>
						</td>
						<td>
							<%
								out.print(order.getDeliveryStatus());
							%>
						</td>
						<td>
							<%
								out.print(order.getDate());
							%>
						</td>
						<td>
							<%
								out.print(order.getPaymentMethod());
							%>
						</td>
						<td>
							<%
								out.print(order.getTotalPrice());
							%>
						</td>
					</tr>
					<tr>
						<th>Pancake name</th>
						<th>Amount</th>
						<th>Price</th>
						<th></th>
						<th></th>
						<th></th>
						<th></th>
					</tr>
					<%
						List<OrderItemStub> anOrder = order.getorderItems();
							for (OrderItemStub orderItem : anOrder) {
					%>
					<tr>
						<td>
							<%
								out.print(orderItem.getPancake().getName());
							%>
						</td>
						<td>
							<%
								out.print(orderItem.getAmount());
							%>
						</td>
						<td>
							<%
								out.print(orderItem.getTotalPrice());
							%>
						</td>
						<td></td>
						<td></td>
						<td></td>
					</tr>

					<%
						}
					%>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
					</tr>
					<tr>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
						<td></td>
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