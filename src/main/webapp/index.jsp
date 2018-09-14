<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title><spring:message code="index.title" /></title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="#" class="navbar-brand mr-2"><spring:message code="index.header" /></a>
		  	</section>
		</header><br/>
		<div class="columns">
			<div class="column col-2 col-md-6">
				<h2><a href="/SpringHibernate/list-user"><spring:message code="index.link" /></a><br/></h2>
			</div>
		</div>
	</body>
</html>