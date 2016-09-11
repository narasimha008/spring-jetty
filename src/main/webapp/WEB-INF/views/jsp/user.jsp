<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>
 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>
 
<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
	<div class="navbar-header">
		<a class="navbar-brand" href="#">User Info</a>
	</div>
  </div>
</nav>
 
<div class="jumbotron">
  <div class="container">
	<form action="save" method="post">
	<table class="table table-bordered">
		<tbody>
			<tr>
			<td>First Name</td>
			<td>:</td>
			<td><input type="text" name="firstName" id="firstName" value="${user.firstName}">
			<input type="hidden" name="id" id="id" value="${user.id}"></td>
			</tr>
			<tr>
			<td>Last Name</td>
			<td>:</td>
			<td><input type="text" name="lastName" id="lastName" value="${user.lastName}"></td>
			</tr>
			<tr>
			<td>Age</td>
			<td>:</td>
			<td><input type="text" name="uage" id="uage" value="${user.uage}"></td>
			</tr>
		</tbody>		
	</table>
    <p>
    	<input class="btn btn-primary btn-lg" type="submit" name="Save" value="Save">
	</p>
	</form>
	</div>
</div>
 

<spring:url value="/resources/core/css/hello.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />
 
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
 
</body>
</html>