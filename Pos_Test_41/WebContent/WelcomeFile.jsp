<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DashBoard</title>
</head>
<body>

	<table>
		<tr>
			<td>ID</td>
			<td>Category Name</td>
		</tr>

		<c:forEach var="tempCategories" items="${categories}">
			<tr>
				<td>${tempCategories.id}</td>
				<td>${tempCategories.name}</td>
			</tr>
		</c:forEach>

		<tr>
			<td>ID</td>
			<td>Enterprise Name</td>
			<td>Area</td>
		</tr>

		<c:forEach var="tempEnterprises" items="${enterprises}">
			<tr>
				<td>${tempEnterprises.id}</td>
				<td>${tempEnterprises.name}</td>
				<td>${tempEnterprises.area}</td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>