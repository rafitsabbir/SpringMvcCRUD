<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Form</title>
</head>
<body>
<spring:url value="/save" var="saveURL" />

<form:form modelAttribute="userform" method="POST" action="${saveURL}">
<form:hidden path="id"/>
<table>
	<tr>
		<td>First Name</td>
		<td><form:input path="firstname"/></td>
	</tr>
	<tr>
		<td>Last Name</td>
		<td><form:input path="lastname"/></td>
	</tr>
	<tr>
		<td>Address</td>
		<td><form:input path="Address"/></td>
	</tr>
	<tr>
		<td></td>
		<td><button type="submit">Save</button></td>
	</tr>
</table>
</form:form>

</body>
</html>