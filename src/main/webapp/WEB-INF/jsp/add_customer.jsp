<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Customer</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<c:url var="formAction" value="/save-customer" />
		<form:form commandName="customer" method="post" action="${formAction}">
			<fieldset>
				<legend>Add a customer</legend>
				<p>
					<label for="name">name: </label>
					<form:input id="name" path="name" />
					<form:errors path="name" cssClass="text-error" />
				</p>
				<p>
					<label for="balance">balance: </label>
					<form:input id="balance" path="balance" />
					<form:errors path="balance" cssClass="text-error" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Add Customer">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>