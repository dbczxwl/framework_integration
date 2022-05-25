<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<title>Show Parameters</title>
</head>
<body>
	<h1>Form transfer param</h1>
	<!-- ${param.xxx} 等价于 request.getParamter("xxx") -->
	<p>param is "${param.bookName}"</p>
	<p>param is "<%=request.getAttribute("bookName")%>"</p>
	<p>result message is "${msg}"</p>
	<p>Wow! A new customer: "${customer.firstName}${customer.lastName}",Contact:"${customer.email}"</p>
	<table border="1">
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="item" items="${customerList}">
			<tr>
				<td>${item.firstName}</td>
				<td>${item.lastName}</td>
				<td>${item.email}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>