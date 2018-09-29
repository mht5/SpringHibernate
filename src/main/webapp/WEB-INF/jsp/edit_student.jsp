<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Edit Book</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<c:url var="formAction" value="/update-student" />
		<form:form commandName="student" method="post" action="${formAction}">
			<fieldset>
				<legend>Edit book</legend>
				<form:hidden path="id" />
				<p>
					<label for="name">name: </label>
					<form:input id="name" path="name" />
				</p>
				<p>
					<label for="teacherIdList">teachers: </label>
					<div class="form-group">
				  		<c:forEach items="${teacherList}" var="teacher">
					  		<label class="form-checkbox form-inline">
					  			<c:if test="${teacherIdList.contains(teacher.id)}">
					    			<input type="checkbox" name= "teacherIdList" value="${teacher.id}" checked>
								</c:if>
					  			<c:if test="${!teacherIdList.contains(teacher.id)}">
					    			<input type="checkbox" name= "teacherIdList" value="${teacher.id}">
					    		</c:if>
					    		<i class="form-icon"></i>
					    		${teacher.name}
					  		</label>
				  		</c:forEach>
					</div>
					<form:errors path="teacherIdList" cssClass="text-error" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Update Student">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>