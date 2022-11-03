<%@page import="com.deloitte.entity.Trainee"%>
<%@page import="com.deloitte.dao.TraineeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modify a Trainee</title>
</head>
<body bgcolor="yellow">
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	TraineeDAO traineeDAO = new TraineeDAO();
	Trainee trainee = traineeDAO.readById(id);
	%>
	<table border="1" bgcolor="blue">
		<form action="updateTrainee.jsp" method="get">
			<tr>
				<th>Sl No</th>
				<th>Trainee Property</th>
				<th>Trainee Value</th>
			</tr>
			<input type="hidden" name="id" value="<%=trainee.getId()%>">
			<tr>
				<td>1</td>
				<td>Name :</td>
				<td><input type="text" name="name"
					value="<%=trainee.getName()%>" required="required" /></td>
			</tr>
			<tr>
				<td>2</td>
				<td>Email :</td>
				<td><input type="email" name="email"
					value="<%=trainee.getEmail()%>" required="required" /></td>
			</tr>
			<tr>
				<td>3</td>
				<td>Mobile :</td>
				<td><input type="number" name="mobile"
					value=<%=trainee.getMobile()%> required="required" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="clear" /></td>
				<td><input type="submit" value="Update a Trainee" /></td>
			</tr>
		</form>
	</table>
</body>
</html>