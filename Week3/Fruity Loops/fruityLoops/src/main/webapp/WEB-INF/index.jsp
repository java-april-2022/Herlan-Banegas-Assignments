<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/styles.css">
<title>Insert title here</title>
</head>
<body>
	<h1>Fruit Store</h1>
	<div class="container">
		<table>
			<tr>
				<th>Name</th>
				<th>Price</th>
			</tr>
			<c:forEach var="fruits" items="${fruitsOfLove }">
			<tr>
				<td><c:out value="${fruits.name }"></c:out></td>
				<td><c:out value="${fruits.price }"></c:out></td>
			</tr>
			</c:forEach>
					
	
		</table>
	
	
	</div>

</body>
</html>