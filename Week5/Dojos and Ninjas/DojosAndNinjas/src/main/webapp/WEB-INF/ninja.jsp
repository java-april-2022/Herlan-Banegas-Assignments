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
<title>New Ninja</title>
</head>
<h1>New Ninja</h1>
<body>
<form:form action="/createNinja" method="post" modelAttribute="newNinja">
	<p><form:label path="dojo">Dojo:</form:label>
	<form:select path="dojo">
		<c:forEach items="${dojos }" var="dojo">
		<option value="${dojo.id }"> ${dojo.name }</option>
		</c:forEach>
	</form:select>
	</p>
	<p>
		<form:errors class="text-danger" path="firstName" />
		<form:label path="firstName">First Name:</form:label>
		<form:input path="firstName" />
	</p>
	<p>
		<form:errors class="text-danger" path="lastName" />
		<form:label path="lastName">Last Name:</form:label>
		<form:input path="lastName" />
	</p>
	<p>
		<form:errors class="text-danger" path="age" />
		<form:label path="age">Age:</form:label>
		<form:input path="age" />
	</p>
	<button>Submit</button>


</form:form>
</body>
</html>