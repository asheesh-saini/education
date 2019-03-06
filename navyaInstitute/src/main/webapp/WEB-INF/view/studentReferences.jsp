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
				<td>Reference ID</td>
				<td>Number</td>
				
			</tr>
		<c:forEach var="ref" items="${references}">
			<tr>
				<td><a href="detailsByRef?s=${ref.referenceId}">${ref.referenceId}</a></td>
				<td>${ref.count}</td>
				
			</tr>
		</c:forEach>
	</table>
</body>
</html>