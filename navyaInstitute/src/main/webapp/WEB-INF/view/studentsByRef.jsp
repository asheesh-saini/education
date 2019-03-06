<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div><a href="../home">Back</a></div>
	<table border="1">
	<tr>
				<td>Student Id</td>
				<td>Name</td>
				<td>Mobile number</td>
				<td>Date of Birth</td>
				<td>Batch Id</td>
				<td>Reference Id</td>
			</tr>
		<c:forEach var="student" items="${references}">
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.mob}</td>
				<td>${student.dob}</td>
				<td>${student.batchId}</td>
				<td>${student.reference}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>