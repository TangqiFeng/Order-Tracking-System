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

<h1>ADD New Order</h1>
<form:form modelAttribute="Order" >
	<table>
		<tr>
      		<td>Customer ID:</td>
      		<td><form:input name="cid" path="cid"></form:input></td>
    	</tr>
    	<tr>
      		<td>Product ID:</td>
      		<td><form:input path="pid"></form:input></td>
    	</tr>
    	<tr>
      		<td>Quantity:</td>
      		<td><form:input path="qty"></form:input>${errorMsg}</td>
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
<a href="/showCustomers"> List Customer </a>

</body>
</html>