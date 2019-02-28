<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html;
   charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Students</title>
</head>
<body>
	<section class="container">
		<form:form method="POST" modelAttribute="newStudent"
			class="form-horizontal">
			<fieldset>
				<legend>Add new student</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="id">Student
						Id</label>
					<div class="col-lg-10">
						<form:input id="productId" path="id" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">Student Name</label>
					<div class="col-lg-10">
						<form:input id="productId" path="name" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="batchId">Batch id</label>
					<div class="col-lg-10">
						<form:input id="productId" path="batchId" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="dob">Date of Birth</label>
					<div class="col-lg-10">
						<form:input id="productId" path="dob" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="mob">Mobile No</label>
					<div class="col-lg-10">
						<form:input id="productId" path="mob" type="text"
							class="form:input-large" />
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-10">
						<input type="submit" id="btnAdd"
							class="btn
             btn-primary" value="Add" />
					</div>
				</div>
			</fieldset>
		</form:form>
	</section>
</body>
</html>
