<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POS - Point Of Sales</title>

<link type="text/css"
	  rel="stylesheet" 
	  href="${pageContext.request.contextPath}/resources/css/style.css" >

</head>
<body>
<div id="wrapper">
		<div id="header">

			<h2>List of Enterprises</h2>

		</div>
	</div>

<div id="container">
		<div id="content">

			<input type="button" value="Add Enterprise"
			onclick="window.location.href='showFormAdd'; return false;"
			class="add-button" />


	<table>
		<tr>
			<td>ID</td>
			<td>Enterprise Name</td>
			<td>Area</td>
			<td>Branches</td>
		</tr>

		<c:forEach var="tempEnterprises" items="${enterprises}">
			<tr>
				<td>${tempEnterprises.id}</td>
				<td>${tempEnterprises.name}</td>
				<td>${tempEnterprises.area}</td>
				<td><a href="branches/${tempEnterprises.id}">See Branches</a></td>
			</tr>
		</c:forEach>


	</table>
	</div>
</div>

</body>
</html>