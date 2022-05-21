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
<h1>Create a New Book</h1>
<a href="/dashboard">Home</a>
<a href="logout">Logout</a>
<form:form method="POST" action="/book/create" modelAttribute="newBook">
		<div class = "form-group">
		<form:label path="name">Name:</form:label>
    	<form:input path="name" class="form-control"/>
    	<form:errors class ="text-danger" path="name"/>
		</div>
		<div class = "form-group">
		<form:label path="author">Author:</form:label>
    	<form:input path="author" class="form-control"/>
    	<form:errors class ="text-danger" path="author"/>
		</div>
		<div class = "form-group">
		<form:label path="comment">My Thoughts:</form:label>
    	<form:input path="comment" class="form-control"/>
    	<form:errors class ="text-danger" path="comment"/>
		</div>
		<!-- hidden input of user_id -->
    	<form:input type="hidden" value="${loggedInUser.id}" path="user" />
		<br/>
		<button class ="btn-primary">Add This Book</button>
	</form:form>
</body>
</html>

