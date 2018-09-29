<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Student</title>
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre.min.css">
		<link rel="stylesheet" href="https://unpkg.com/spectre.css/dist/spectre-icons.min.css">
	</head>
	<body>
		<header class="navbar">
			<section class="navbar-section">
		    	<a href="<%=request.getContextPath()%>/index.html" class="navbar-brand mr-2">Home</a>
		  	</section>
		</header><br/>
		<c:if test="${param.msg != null}">
			<p style="color: red">
				${param.msg}
			</p>
		</c:if>
		<c:url var="formAction" value="/save-student" />
		<form:form commandName="student" method="post" action="${formAction}">
			<fieldset>
				<legend>Add a student</legend>
				<p>
					<label for="name">name: </label>
					<form:input id="name" path="name" />
					<form:errors path="name" cssClass="text-error" />
				</p>
				<p>
					<label for="teacherIdList">teachers: </label>
					<%-- <form:checkboxes path="teacherIdList" items="${teacherList}" itemValue="id" itemLabel="name" /> --%>
					<div class="form-group">
				  		<c:forEach items="${teacherList}" var="teacher">
					  		<label class="form-checkbox form-inline">
					    		<input type="checkbox" name= "teacherIdList" value="${teacher.id}">
					    		<i class="form-icon"></i>
					    		${teacher.name}
					  		</label>
				  		</c:forEach>
					</div>
					<form:errors path="teacherIdList" cssClass="text-error" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Add Student">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>