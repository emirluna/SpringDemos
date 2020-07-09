<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Form registration customer</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM</h2>
		</div>
	</div>


	<div id="container">
		<h3>Save Enterprise</h3>
		<form:form action="saveEnterprise" modelAttribute="enterprise"
			method="POST">
			
			<table>
				<tr>
					<td><label>Name: </label></td>
					<td><form:input path="name" /></td>
				</tr>
				<tr>
					<td><label>Area: </label></td>
					<td><form:input path="area" /></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save" /></td>
				</tr>
			</table>

		</form:form>

		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}">Back to List</a>
		</p>
		
	</div>

</body>

</html>