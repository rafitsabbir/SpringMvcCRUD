<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Page</title>
</head>
<body>
<h1> List</h1>
<table width="100%" border="1">
<tr>
	<th>Id </th>
	<th>First Name </th>
	<th>Last Name </th>
	<th>Address </th>
	<th colspan="2"> Action </th>
</tr>

<c:forEach items="${listuser}" var="user"> 
	<tr>
		<td>${user.id } </td>
		<td>${user.firstname } </td>
		<td>${user.lastname } </td>
		<td>${user.address } </td>
		<td>
			<spring:url value="/update/${user.id }" var="updateURL" />
			<a href="${updateURL}">Update</a>			
		</td>
		<td>
			<spring:url value="/delete/${user.id }" var="deleteURL" />
			<a href="${deleteURL}">Delete</a>			
		</td>
	</tr>
</c:forEach>
</table>

</body>
</html>