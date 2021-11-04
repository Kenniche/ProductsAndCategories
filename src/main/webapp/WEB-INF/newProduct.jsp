<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="css/style.css">
<script type="text/javascript" src="js/app.js"></script>
<link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<meta charset="UTF-8">
<title>New Product</title>
</head>
<body>	
	<div class = "container">
		<h1 class="mt-3 display1">New Product</h1>
		<form:form action="/products/new" method="post" modelAttribute="newProduct">
	      		<p>
	      			<form:label path="name" class="form-label">Name:</form:label>
		      		<form:errors path="name" class="text-danger" />
		      		<form:input path="name" class="form-control"/>
	      		</p>
	      		<p>
	      			<form:label path="description" class="form-label">Description:</form:label>
		      		<form:errors path="description" class="text-danger" />
		      		<form:input path="description" class="form-control"/>
	      		</p>
	      		<p>
	      			<form:label path="price" class="form-label">Price:</form:label>
		      		<form:errors path="price" class="text-danger" />
		      		<form:input path="price" class="form-control"/>
	      		</p>
	      		<div class="d-flex justify-content-end">
		    		<input type="submit" value="Create Product" class="btn btn-sm btn-outline-primary mt-3" />
	      		</div>
    		</form:form>
	</div>
</body>
</html>