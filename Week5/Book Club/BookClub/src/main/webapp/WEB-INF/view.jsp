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
<div class="container">
	<div class="header">
		<div class="header-row">
		<a href="/dashboard">Back to the Shelves</a>
			<h3>${ book.name }</h3>
		</div>
	</div>
	
	<div class="jumbotron">
	<c:choose>
		<c:when test = "${ userId == book.user.id }">
			<h4 class="display-6"><b>You read ${ book.name } by ${ book.author }</b></h4>
		<p class="lead">Here are your comments:</p>
		</c:when>
		<c:otherwise>
			<h4 class="display-6"><b>${ book.user.name } read ${ book.name } by ${ book.author }</b></h4>
			<p class="lead">Here are ${ book.user.name }'s comments:</p>
		</c:otherwise>
	</c:choose>
		<hr class="my-4">
		<p class="lead"><em>${ book.comment }</em></p>
		<hr class="my-4">
		<c:choose>
			<c:when test="${ userId == book.user.id }">
			<a href="/book/edit/${ book.id }" class="btn btn-primary btn-md">Edit</a>
			</c:when>
		</c:choose>
	</div>
</body>
</html>

