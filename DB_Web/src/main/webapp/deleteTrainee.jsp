<%@page import="com.deloitte.dao.TraineeDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
</head>
<body>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	TraineeDAO traineeDAO = new TraineeDAO();
	traineeDAO.deleteTrainee(id);
	response.sendRedirect("viewTrainees.jsp");
	%>
</body>
</html>