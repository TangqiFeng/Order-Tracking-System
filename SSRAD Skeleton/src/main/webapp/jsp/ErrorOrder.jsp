<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>SS RAD Final Project</title>
	</head>
	<body>
	
		<h1>Error Creating the following Order</h1>
		
		<h3>${errorMsg}</h3>
	
		<br/>
		
		<table>
			<tr>
				<th> Product ID </th>
				<th> Customer ID </th>
				<th> Quantity </th>
			</tr>
				<tr>
					<td>
						<label>${Order.cId}</label>
					</td>
					<td>
						<label>${Order.pId}</label>
					</td>
					<td>
						<label>${Order.qty}</label>
					</td>
					
				</tr>
		</table>
		
		<br/>
		
		<br/>
		<a href="/">Home</a>&nbsp;
		<a href="/addOrder"> Add Order </a>&nbsp;
		<a href="/showProducts"> List Products </a>
		
	</body>
</html>