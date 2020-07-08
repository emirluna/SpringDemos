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
			<td>Product Name</td>
			<td>Short Name</td>
			<td>Barcode</td>
			<td>Stock</td>
			<td>Status</td>
		</tr>

		<c:forEach var="tempStocks" items="${stocks}">
			<tr>
			
				<td>${tempStocks.products.id}</td>
				<td>${tempStocks.products.name}</td>
				<td>${tempStocks.products.shortName}</td>
				<td>${tempStocks.products.barcode}</td>
				<td>${tempStocks.stock}</td>
				<c:if test="${tempStocks.stock <= tempStocks.maxStock}">
				<td>Casi agotado</td>
				</c:if>
				<!-- <td>${tempBranches.address}</td> -->
				<!--  <td><a href="stocks/${tempBranches.id}">See Stocks</a></td>-->
				</tr>
		</c:forEach>


	</table>


</body>
</html>