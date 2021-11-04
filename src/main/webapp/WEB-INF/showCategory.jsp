<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri= "http://java.sun.com/jsp/jstl/core" %>
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
<title>Category Page</title>
</head>
<body>	
	<div class = "container d-flex justify-content-center align-items-center flex-column">
		<h1 class="mt-3 display1"><c:out value="${category.name}"/> </h1>
		<div class="row">
			<div class="col">
				<h2>Products</h2>
				<ul>
					<c:forEach items="${category.products}" var="product">
						<li> <c:out value="${product.name}"/>
					</c:forEach>
				</ul>
			</div>
			<div class="col">
				<form action="/categories/${category.id}" method="post" modelAttribute="addProduct">
					<input type="hidden" value="${category.id}" name="category_id"/>
		      			<label class="form-label">Add Product:</label>
			      		<select class="form-control" name="product_id">
			      			<c:forEach items="${products}" var="product">
						        <option value="${product.id}"> <c:out value="${product.name}"/> </option>
						    </c:forEach>
						</select>
						<div class="d-flex justify-content-end">
		    				<input type="submit" value="Add" class="btn btn-sm btn-outline-primary mt-3" />
	      				</div>
	      		</form> 
			</div>
		</div>
	</div>
</body>
</html>