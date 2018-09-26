<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>List Order</title>
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
		<c:if test="${param.msg != null}">
			<p style="color: red">
				${param.msg}
			</p>
		</c:if>
		<table class="table table-striped table-hover">
			<thead>
		    	<tr>
		      		<th>ID</th>
		      		<th>customer name</th>
		      		<th>book name</th>
		      		<th>count</th>
		      		<th>price</th>
		      		<th>address</th>
		      		<th>&nbsp;</th>
		    	</tr>
		  	</thead>
		  	<tbody>
				<c:if test="${orderList.size() < 1}">
					<a href="add-order">Add</a>
				</c:if>
				<c:if test="${orderList.size() >= 1}">
			  		<c:forEach items="${orderList}" var="order">
				    	<tr class="active">
				      		<td>${order.id}</td>
				      		<td>${order.customer.name}</td>
				      		<td>${order.book.name}</td>
				      		<td>${order.count}</td>
				      		<td>${order.price}</td>
				      		<td>${order.address}</td>
				      		<td>
				      			<a href="edit-order/${order.id}">Edit</a>&nbsp;&nbsp;
				      			<a href="delete-order/${order.id}">Delete</a>&nbsp;&nbsp;
				      			<a href="add-order">Add</a>
				      		</td>
				    	</tr>
			  		</c:forEach>
				</c:if>
		  	</tbody>
		</table>
	</body>
</html>