<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Club</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	   
	<h1>Book Club</h1>
	<p>A place for friends to share thoughts on books.</p>
	<form:form method="POST" action="/register" modelAttribute="user">
		<div class="form-group">
			<form:label path="name">Name:</form:label>
			<form:errors class="text-danger" path="name" />
			<form:input class="form-control" path="name" />
		</div>
		<div class="form-group">
			<form:label path="email">Email</form:label>
			<form:errors class="text-danger" path="email" />
			<form:input class="form-control" path="email" />
		</div>
		<div class="form-group">
			<form:label path="password">Password:</form:label>
			
			<form:errors class="text-danger" path="password" />
			<form:password class="form-control" path="password" />
		</div>
		<div class="form-group">
			<form:label path="confirm">Confirm PW:</form:label>
			<form:password class="form-control" path="confirm" />
			<form:errors class="text-danger" path="confirm" />
		</div>
		<input type="submit" value="Register" />
	</form:form>

	<form method="POST" action="/login">
		<p class="text-danger">
		<c:out value="${error }"/>
		</p>
		<div class="form-group">
			<label type="email" for="email">Email</label> <input
				class="form-control" type="text" id="email" name="email" />
		</div>
		<div class="form-group">
			<label for="password">Password</label> <input class="form-control"
				type="password" id="password" name="password" />
		</div>
		<input type="submit" value="Login" />
	</form>
</body>
</html>

