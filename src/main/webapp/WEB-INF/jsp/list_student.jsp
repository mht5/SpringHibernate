<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List Student</title>
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
		      		<th>teachers</th>
		      		<th>&nbsp;</th>
		    	</tr>
		  	</thead>
		  	<tbody>
				<c:if test="${studentList.size() < 1}">
					<a href="add-student">Add</a>
				</c:if>
				<c:if test="${studentList.size() >= 1}">
			  		<c:forEach items="${studentList}" var="student">
				    	<tr class="active">
				      		<td>${student.id}</td>
				      		<td>${student.name}</td>
				      		<td>
						  		<c:forEach items="${student.teachers}" var="teacher">
						  			${teacher.name}, 
						  		</c:forEach>
				      		</td>
				      		<td>
				      			<a href="edit-student/${student.id}">Edit</a>&nbsp;&nbsp;
				      			<a href="delete-student/${student.id}">Delete</a>&nbsp;&nbsp;
				      			<a href="add-student">Add</a>
				      		</td>
				    	</tr>
			  		</c:forEach>
				</c:if>
		  	</tbody>
		</table>
	</body>
</html>