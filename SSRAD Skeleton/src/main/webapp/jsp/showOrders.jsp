<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>

<style>
			table {
			    font-family: arial, sans-serif;
			    border: 2px solid #4462ce;
			    width: 80%;
			}
		
			td, th {
			    text-align: center;
			    padding: 5px;
			}
		
			tr:nth-child(even) {
			    background-color: #6884e8;
			}
		</style>

</head>
<body>

<h1>List of Orders</h1>
		
<c:forEach var="order" items="${allOrders}">
	
	<h2>
		Order Id: <c:out value="${order.oId}"/>
	</h2>
	<table>
		<tr>
			<th> Quantity </th>
			<th> Order Date </th>
			<th> Customer ID </th>
			<th> Customer Name </th>
			<th> Product ID </th>
			<th> Description </th>
		</tr>
			<tr>
				<td>
					<c:out value="${order.qty}"/>
				</td>
				<td>
					<c:out value="${order.orderDate}"/>
				</td>
				<td>
					<c:out value="${order.cust.cId}"/>
				</td>
				<td>
					<c:out value="${order.cust.cName}"/>
				</td>
				<td>
					<c:out value="${order.prod.pId}"/>
				</td>
				<td>
					<c:out value="${order.prod.pDesc}"/>
				</td>
			</tr>
	</table>
</c:forEach>

<a href="/">Home</a>&nbsp;
<a href="/addOrder"> Add Order </a>&nbsp;
<a href="/showProducts"> List Products </a>&nbsp;
<a href="/showCustomers"> List Customer </a>&nbsp;

</body>
</html>