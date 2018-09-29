<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List Teacher</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
		<!-- <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js" type="text/javascript"></script> -->
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<table class="table table-striped table-hover">
			<thead>
		    	<tr>
		      		<th>ID</th>
		      		<th>name</th>
		      		<th>&nbsp;</th>
		    	</tr>
		  	</thead>
		  	<tbody>
				<c:if test="${teacherList.size() < 1}">
					<a href="add-teacher">Add</a>
				</c:if>
				<c:if test="${teacherList.size() >= 1}">
			  		<c:forEach items="${teacherList}" var="teacher">
				    	<tr class="active">
				      		<td>${teacher.id}</td>
				      		<td>${teacher.name}</td>
				      		<td>
				      			<a href="edit-teacher/${teacher.id}">Edit</a>&nbsp;&nbsp;
				      			<a href="delete-teacher/${teacher.id}">Delete</a>&nbsp;&nbsp;
				      			<a href="add-teacher">Add</a>
				      		</td>
				    	</tr>
			  		</c:forEach>
				</c:if>
		  	</tbody>
		</table>
	</body>
</html>