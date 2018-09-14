<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add User</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<c:url var="formAction" value="/save-user" />
		<form:form commandName="user" enctype="multipart/form-data" method="post" action="${formAction}">
			<fieldset>
				<legend>Add a user</legend>
				<p>
					<label for="username">user name: </label>
					<form:input id="username" path="username" />
					<form:errors path="username" cssClass="text-error" />
				</p>
				<p>
					<label for="name">name: </label>
					<form:input id="name" path="name" />
					<form:errors path="name" cssClass="text-error" />
				</p>
				<p>
					<label for="birthday">birthday: </label>
					<form:input id="birthday" path="birthday" />
					<form:errors path="birthday" cssClass="text-error" />
				</p>
				<p>
					gender: 
					<form:radiobutton path="gender" value="1" id="male" /><label for="male">Male</label>
					<form:radiobutton path="gender" value="0" id="female" /><label for="female">Female</label>
					<form:errors path="gender" cssClass="text-error" />
				</p>
				<p>
					<label for="image">image: </label>
					<form:input type="file" id="image" path="image" />
					<form:errors path="image" cssClass="text-error" />
				</p>
				<p>
					<label for="file">file: </label>
					<form:input type="file" id="file" path="file" />
					<form:errors path="file" cssClass="text-error" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Add User">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>