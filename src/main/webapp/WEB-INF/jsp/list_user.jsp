<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List User</title>
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
		      		<th>user name</th>
		      		<th>name</th>
		      		<th>birthday</th>
		      		<th>gender</th>
		      		<th>image</th>
		      		<th>file</th>
		      		<th>&nbsp;</th>
		    	</tr>
		  	</thead>
		  	<tbody>
		  		<c:forEach items="${userList}" var="user">
			    	<tr class="active">
			      		<td>${user.id}</td>
			      		<td>${user.username}</td>
			      		<td>${user.name}</td>
			      		<td>${fn:substring(user.birthday, 0, 10)}</td>
			      		<td>${user.gender==1 ? "Male" : "Female"}</td>
			      		<td>
			      			<c:if test="${user.imageUrl != null}">
			      				<img src="${user.imageUrl}" width="200px" />
			      			</c:if>
			      			<c:if test="${user.imageUrl == null}">
			      				Not provided
			      			</c:if>
			      		</td>
			      		<td>
			      			<c:if test="${user.fileUrl != null}">
			      				<a href="download?filePath=${user.fileUrl}">download</a>
			      			</c:if>
			      			<c:if test="${user.fileUrl == null}">
			      				Not provided
			      			</c:if>
			      		</td>
			      		<td>
			      			<a href="edit-user/${user.id}">Edit</a>&nbsp;&nbsp;
			      			<a href="delete-user/${user.id}">Delete</a>&nbsp;&nbsp;
			      			<a href="add-user">Add</a>
			      		</td>
			    	</tr>
		  		</c:forEach>
		  	</tbody>
		</table>
	</body>
</html>