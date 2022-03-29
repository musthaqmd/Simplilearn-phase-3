<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet">
</head>

<body>

	<div class="container">
	<h2>Please enter an Id to retrieve the feedback from The Movie Database</h2><hr>
		<form method="post" modelAttribute="id">
			<label>Id:</label> <input type="text" name="id" required="required" class="form-control"><br />
			<br />
			<button type="submit" class="btn btn-info">Search</button>
		</form><br>
		
		<font color="red">${errorMessage}</font>
	</div>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>

</html>