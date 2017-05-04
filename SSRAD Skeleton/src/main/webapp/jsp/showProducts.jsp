<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<c:url value="/j_spring_security_logout" var="logoutUrl"/>  
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

<h1>List of Products</h1>

<table>
	<tr>
		<th> Product ID </th>
		<th> Description </th>
		<th> Quality in Stock </th>
	</tr>
			
	<c:forEach var="product" items="${allProducts}">
		<tr>
			<td>
				<c:out value="${product.pId}"/>
			</td>
			<td>
				<c:out value="${product.pDesc}"/>
			</td>
			<td>
				<c:out value="${product.qtyInStock}"/>
			</td>
		</tr>
	</c:forEach>
</table>

<a href="/">Home </a>&nbsp;
<a href="/addProduct"> Add Product </a>&nbsp;
<a href="/showProducts"> List Products </a>&nbsp;
<a href="/showOrders"> List Orders </a>&nbsp;

<a href="/logout">Logout</a>

</body>
</html>