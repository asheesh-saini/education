<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
<div><a href="../home">Back</a></div>
	<section class="container">
		<form:form method="POST" modelAttribute="newStudent"
			class="form-horizontal">
			<fieldset>
				<legend>Add new student</legend>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="id"><spring:message
							code="addStudent.form.studentId.label" /> </label>
					<div class="col-lg-10">
						<form:input id="productId" path="id" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="name">
						<spring:message code="addStudent.form.stdentName.label" />
					</label>
					<div class="col-lg-10">
						<form:input id="productId" path="name" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="batchId"><spring:message
							code="addStudent.form.batchId.label" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="batchId" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="dob"><spring:message
							code="addStudent.form.dob.label" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="dob" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="mob"><spring:message
							code="addStudent.form.mob.label" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="mob" type="text"
							class="form:input-large" />
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-lg-2 col-lg-2" for="reference"><spring:message
							code="addStudent.form.reference.label" /></label>
					<div class="col-lg-10">
						<form:input id="productId" path="reference" type="text"
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
