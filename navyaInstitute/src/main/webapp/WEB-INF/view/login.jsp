<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:url var="loginUrl" value="/login" />
	<form action="login" method="post" class="form-horizontal">

		<div class="input-group input-sm">
			<label class="input-group-addon" for="username"><i
				class="fa fa-user"></i></label> <input type="text" class="form-control"
				id="userId" name="username" placeholder="Enter Username" required>
		</div>
		<div class="input-group input-sm">
			<label class="input-group-addon" for="password"><i
				class="fa fa-lock"></i></label> <input type="password" class="form-control"
				id="password" name="password" placeholder="Enter   Password"
				required>
		</div>
		<div class="form-actions">
			<input type="submit" class="btn btn-block btn-primary btn-default"
				value="Log in">
		</div>
	</form>

</body>
</html>