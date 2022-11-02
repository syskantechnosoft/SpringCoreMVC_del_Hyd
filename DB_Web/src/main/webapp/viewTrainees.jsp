<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="com.deloitte.dao.TraineeDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.deloitte.entity.Trainee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Trainees</title>
</head>
<body bgcolor="cyan">
	<a href="index.jsp">Home</a>
	<a href="newTrainee.jsp">Add a Trainee</a>
	<h1>Trainee Details</h1>
	<table bgcolor="red" border="1">
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Actions</th>
		</tr>
		<%
		List<Trainee> trainees = new ArrayList<Trainee>();
		TraineeDAO traineeDAO = new TraineeDAO();
		trainees = traineeDAO.readAll();
		for (Trainee trainee : trainees) {
		%>
		<tr>
			<td><%=trainee.getId()%></td>
			<td><%=trainee.getName()%></td>
			<td><%=trainee.getEmail()%></td>
			<td><%=trainee.getMobile()%></td>
			<td><a href="editTrainee.jsp?id=<%=trainee.getId()%>">Edit</a>||
				<a href="deleteTrainee.jsp?id=<%=trainee.getId()%>">Delete</a>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>