<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring MVC Form Handling</title>
</head>
<body>
	<h2>Add Course Data</h2>
	<form:form method="POST" action="saveCourse.html">
		<table>
			<tr>
				<td><form:label path="id">Course ID:</form:label></td>
				<td><form:input path="id" value="${course.id}" readonly="true" /></td>
			</tr>
			<tr>
				<td><form:label path="name">Course Name:</form:label></td>
				<td><form:input path="name" value="${course.name}" /></td>
			</tr>
			<tr>
				<td><form:label path="description">Description:</form:label></td>
				<td><form:input path="description"
						value="${course.description}" /></td>
			</tr>
			<tr>
				<td><form:label path="duration">Course Duration(Hours):</form:label></td>
				<td><form:input path="duration" value="${course.duration}" /></td>
			</tr>

			<tr>
				<td><form:label path="url">Course URL:</form:label></td>
				<td><form:input path="url" value="${course.url}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>

	<c:if test="${!empty courses}">
		<h2>List Of Courses</h2>
		<table align="left" border="1">
			<tr>
				<th>Course ID</th>
				<th>Name</th>
				<th>Description</th>
				<th>Duration</th>
				<th>URL</th>
				<th>Actions on Row</th>
			</tr>

			<c:forEach items="${courses}" var="course">
				<tr>
					<td><c:out value="${course.id}" /></td>
					<td><c:out value="${course.name}" /></td>
					<td><c:out value="${course.description}" /></td>
					<td><c:out value="${course.duration}" /></td>
					<td><c:out value="${course.url}" /></td>
					<td align="center"><a href="editCourse.html?id=${course.id}">Edit</a>
						| <a href="deleteCourse.html?id=${course.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>