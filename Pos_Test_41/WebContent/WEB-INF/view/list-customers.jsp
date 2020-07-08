<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List Categories</title>

<link type="text/css"
	  rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<div id="wrapper">
		<div id="header">

			<h2>Categories</h2>

		</div>
	</div>


	<div id="container">
		<div id="content">

			<table>
				<tr>
					<th>ID</th>
					<th>Name</th>
				</tr>
				<c:forEach var="tempCustomer" items="${customers}">
				<tr>
					<td> ${tempCustomer.id}</td>
					<td> ${tempCustomer.name}</td>
				</tr>
				</c:forEach>
				
			</table>

		</div>
	</div>

</body>
</html>