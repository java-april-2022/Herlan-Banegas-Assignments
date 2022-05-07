<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h3 style="color: #007bff">Expense Details</h3><a href="/expenses">Dash board</a>
	</div>
	<div class="row">
		<div class="row">
			<div class="col col-lg-4">Expense Name:</div>
			<div class="col col-lg-8">${ expense.name }</div>
		</div>
		<div class="row">
			<div class="col col-lg-4">Expense Description:</div>
			<div class="col col-lg-8">${ expense.description }</div>
		</div>
		<div class="row">
			<div class="col col-lg-4">Vendor:</div>
			<div class="col col-lg-8">${ expense.vendor }</div>
		</div>
		<div class="row">
			<div class="col col-lg-4">Amount Spent:</div>
			<div class="col col-lg-8">${ expense.ammount }</div>
		</div>
	</div>
</body>
</html>