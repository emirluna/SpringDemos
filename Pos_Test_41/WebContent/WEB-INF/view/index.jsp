<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<c:forEach var="tempCategory" items="${categories}">
<tr>
<td>${tempCategory.id}</td>
<td>${tempCategory.name}</td>
</tr>
</c:forEach>



</table>


</body>
</html>