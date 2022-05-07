<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<h1 class="text-center">Safe Travels</h1>

	<div class="container col-4">

		<table class="table table-dark">
			<thead>
				<tr>
					<th>Expense</th>
					<th>Vendor</th>
					<th>Amount</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allExpenses }" var="expense">
					<tr>
						<td><a href="/expenses/show/${ expense.id }">${ expense.name }</a></td>
						<td><c:out value="${expense.vendor }"></c:out></td>
						<td><c:out value="${expense.ammount }"></c:out></td>
						<td><a href="/edit/${expense.id}">Edit</a> <a
							href="/delete/${expense.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>

		</table>

	</div>
	<h1 class="text-center">Add an Expense:</h1>
	<div
		class=" d-flex justify-content-center container col-4 ">


		<form:form action="/expenses" method="post" modelAttribute="expense">
			<p>
				<form:label path="name">Name:</form:label>
				<form:errors path="name" />
				<form:input path="name" />
			</p>
			<p>
				<form:label path="vendor">Vendor:</form:label>
				<form:errors path="vendor" />
				<form:textarea path="vendor" />
			</p>
			<p>
				<form:label path="ammount">Amount:</form:label>
				<form:errors path="ammount" />
				<form:input path="ammount" />
			</p>
			<p>
				<form:label path="description">Description:</form:label>
				<form:errors path="description" />
				<form:input type="description" path="description" />
			</p>
			<input type="submit" value="Submit" />
		</form:form>

	</div>
</body>
</html>