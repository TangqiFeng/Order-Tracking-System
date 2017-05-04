<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SS RAD Final Project</title>

<body>

<h1>ADD New Products</h1>
<form:form modelAttribute="product">
	<table>
		<tr>
      		<td>Product Description:</td>
      		<td><form:input path="pDesc"></form:input></td>
      		<td><form:errors path="pDesc"></form:errors></td>
      		
    	</tr>
    	<tr>
      		<td>Quantity in Stock:</td>
      		<td><form:input path="qtyInStock"></form:input></td>
      		<td><form:errors path="qtyInStock"></form:errors></td>
    	</tr>
    	<tr>
	      <td colspan="2">
	        <input type="submit" value="Add"/>
	      </td>
    	</tr>
	</table>
</form:form>

<a href="/">Home</a>&nbsp;
<a href="/showProducts"> List Products </a>&nbsp;
<a href="/showOrders"> List Orders </a>

</body>
</html>