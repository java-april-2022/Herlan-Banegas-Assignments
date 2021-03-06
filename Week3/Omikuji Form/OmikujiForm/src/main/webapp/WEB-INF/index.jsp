<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Send an Omikuji!</h1>
	<form action="/results" method="POST">
		<div class="row">
			<div class="col-md-4">
				<label for="pickNumber">Pick a number from 5 to 25.</label> 
				<br><input type="number" name="pickNumber" min="5" max="25" class="form-control">
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="city">Enter the name of any city.</label> 
				<br><input type="text" class="form-control" name="city">
			</div>
			<div class="col">
				<label for="name">Enter the name of any real person.</label> 
				<br><input type="text" class="form-control" name="name">
			</div>
		</div>
		<div class="row">
			<div class="col">
				<label for="hobby">Enter professional endeavor or hobby.</label>
				<br><input type="text" class="form-control" name="hobby">
			</div>
			<div class="col">
				<label for="living">Enter any type of living thing.</label> 
				<br><input type="text" class="form-control" name="living">
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
				<label for="comment">Say something nice to someone.</label>
				<br><textarea class="form-control" name="comment" rows="4" cols="20">
      			</textarea>
			</div>
		</div>
		<br>
		<p>
			<em>Send and show a friend</em>
		</p>
		<button class="btn" type="submit">Submit</button>
	</form>
</body>
</html>