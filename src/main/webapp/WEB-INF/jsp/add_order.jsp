<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Add Order</title>
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
		<c:url var="formAction" value="/save-order" />
		<form:form commandName="order" method="post" action="${formAction}">
			<fieldset>
				<legend>Add an order</legend>
				<p>
					<label for="customerId">customer: </label>
					<div class="form-group" style="width: 20%">
						<form:select id="customerId" path="customerId" class="form-select">
							<form:options  items="${customerList}" itemValue="id" itemLabel="name"/>
					  	</form:select>
					</div>
					<form:errors path="customerId" cssClass="text-error" />
				</p>
				<p>
					<label for="bookId">book: </label>
					<div class="form-group" style="width: 20%">
						<form:select id="bookId" path="bookId" class="form-select">
							<form:options  items="${bookList}" itemValue="id" itemLabel="name"/>
					  	</form:select>
					</div>
					<form:errors path="bookId" cssClass="text-error" />
				</p>
				<p>
					<label for="count">count: </label>
					<form:input id="count" type="number" step="any" path="count" />
					<form:errors path="count" cssClass="text-error" />
				</p>
				<%-- <p>
					<label for="price">price: </label>
					<form:input id="price" path="price" />
					<form:errors path="price" cssClass="text-error" />
				</p> --%>
				<p>
					<label for="address">address: </label>
					<form:input id="address" path="address" />
					<form:errors path="address" cssClass="text-error" />
				</p>
				<p id="buttons">
					<input id="reset" type="reset" value="Reset">
					<input type="submit" type="submit" value="Add Order">
				</p>
			</fieldset>
		</form:form>
	</body>
</html>