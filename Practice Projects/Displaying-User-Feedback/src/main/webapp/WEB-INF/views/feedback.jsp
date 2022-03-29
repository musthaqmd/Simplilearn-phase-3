<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>submit</title>
<style>
fieldset {
	background-color: #edd79a;
	height: 100px;
	display: flex;
	align-items: center;
}

input {
	margin: 5px;
	width: 60%;
	border-radius: 8px;
}

textarea {
	width: 60%;
	height: 70%;
	border-radius: 8px;
}

button {
  background-color: #617d5e;
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 3px;
  
}
</style>
<body>

	<div class="container">
		<h2>Here is the data information retrieved from The Movie
			Database</h2>
		<form:form method="post" modelAttribute="fb" class="form">
			<form:hidden path="id" />

			<fieldset class="form-group">
				<form:label path="original_title">Movie Title: </form:label>
				<form:input path="original_title" type="text" class="form-control"
					required="required" />
				<form:errors path="original_title" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="overview">Overview: </form:label>
				<form:textarea path="overview" type="text" class="form-control"
					required="required" />
				<form:errors path="overview" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="vote_count">Vote count: </form:label>
				<form:input path="vote_count" type="text" class="form-control"
					required="required" /> votes
				<form:errors path="vote_count" cssClass="text-warning" />
			</fieldset>
			<button type="submit">Add data to the feedback table</button>
			<br>
		</form:form>
		
		
	</div>


</body>

</html>