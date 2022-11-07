<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>All Courses</title>
</head>
<body>
	<h1>List Courses</h1>
	<h3>
		<a href="addCourse.html">Add More Course</a>
	</h3>

	<c:if test="${!empty courses}">
		<table align="left" border="1">
			<tr>
				<th>Course ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Duration</th>
				<th>Course URL</th>
			</tr>

			<c:forEach items="${courses}" var="course">
				<tr>
					<td><c:out value="${course.id}" /></td>
					<td><c:out value="${course.name}" /></td>
					<td><c:out value="${course.description}" /></td>
					<td><c:out value="${course.duration}" /></td>
					<td><c:out value="${course.url}" /></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>