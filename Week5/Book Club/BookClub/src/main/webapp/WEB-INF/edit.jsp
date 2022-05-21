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
<title>Insert title here</title>
</head>
<body>
		<div class="container">
	<h1>Edit Book</h1>
	<form:form method="put" action="/book/update/${editBook.id}" modelAttribute="editBook">
		<div class = "form-group">
		<form:label path="title">Title:</form:label>
    	<form:input path="title" class="form-control"/>
    	<form:errors class ="text-danger" path="title"/>
		</div>
		<div class = "form-group">
		<form:label path="author">Author:</form:label>
    	<form:input path="author" class="form-control"/>
    	<form:errors class ="text-danger" path="author"/>
		</div>
		<div class = "form-group">
		<form:label path="thoughts">My Thoughts:</form:label>
    	<form:input path="thoughts" class="form-control"/>
    	<form:errors class ="text-danger" path="thoughts"/>
		</div>
		<!-- hidden input of user_id -->
    	<form:input type="hidden" value="${loggedInUser.id}" path="user" />
		<br/>
		<button class ="btn-primary">Edit This Book</button>
	</form:form>
	</div>
</body>
</html>