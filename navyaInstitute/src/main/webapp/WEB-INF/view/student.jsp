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
<div><a href="<c:url value="/logout" />">Logout</a></div>
	<table border="1">
		
			<tr>
				<td>${student.id}</td>
				<td>${student.name}</td>
				<td>${student.mob}</td>
				<td>${student.dob}</td>
				<td>${student.batchId}</td>
			</tr>
		
	</table>
</body>
</html>