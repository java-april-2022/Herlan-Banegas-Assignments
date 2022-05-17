<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
	
<meta charset="UTF-8">
<title>Ninjas And Dojos</title>
</head>
<h1>Dojos And Ninjas</h1>
| <a href="/">Home Page</a> 
| <a href="/ninja">New Ninja</a> 
| <a href="/dojo">New Dojo</a> |
<body>

<table class="table table-dark">
<thead>
	<tr>	
		<th>First Name</th>
		<th>Last Name</th>
		<th>Dojo</th>
	</tr>
</thead>

<c:forEach items="${ninjas}" var="ninjas">
	<tr>
		<td>${ninjas.firstName}</td>
		<td>${ninjas.lastName}</td>
		<td><a href = "/showDojo/${ninjas.dojo.id}">${ninjas.dojo.name}</a></td>
	</tr>
	
</c:forEach>


</table>


</body>
</html>