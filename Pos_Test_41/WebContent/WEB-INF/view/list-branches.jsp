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
			<td>Enterprise Name</td>
			<td>Area</td>
			<td>Branches</td>
		</tr>

		<c:forEach var="tempBranches" items="${branches}">
			<tr>
				<td>${tempBranches.id}</td>
				<td>${tempBranches.branchName}</td>
				<!-- <td>${tempBranches.address}</td> -->
				<td><a href="stocks/${tempBranches.id}">See Stocks</a></td>
				</tr>
		</c:forEach>


	</table>


</body>
</html>