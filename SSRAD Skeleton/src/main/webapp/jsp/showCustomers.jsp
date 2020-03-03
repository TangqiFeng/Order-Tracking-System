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

<h1>List of Customers</h1>
		
<c:forEach var="customer" items="${allCustomers}">
	
	<h2>
		<c:out value="${customer.cName}"/>
	</h2>
	<h4>
		<c:out value="${customer.cName}"/>'s Orders
	</h4>
	<table>
		<tr>
			<th> Order ID </th>
			<th> Quantity </th>
			<th> Product ID </th>
			<th> Description </th>
		</tr>
		<c:forEach var="orders" items="${customer.orders}">
			<tr>
				<td>
					<c:out value="${orders.oid}"/>
				</td>
				<td>
					<c:out value="${orders.qty}"/>
				</td>
					<td>
						<c:out value="${orders.prod.pid}"/>
					</td>
					<td>
						<c:out value="${orders.prod.pDesc}"/>
					</td>
			</tr>
		</c:forEach>
	</table>
</c:forEach>

<a href="/">Home</a>&nbsp;
<a href="/addCustomer"> Add Customer </a>&nbsp;
<a href="/showProducts"> List Products </a>&nbsp;
<a href="/showOrders"> List Orders </a>&nbsp;

<a href="/logout">Logout</a>

</body>
</html>