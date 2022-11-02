<%@page import="com.deloitte.dao.TraineeDAO"%>
<%@page import="com.deloitte.entity.Trainee"%>
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
	String name = request.getParameter("name");
	String email = request.getParameter("email");
	long mobile = Long.parseLong(request.getParameter("mobile"));
	Trainee t = new Trainee();
	t.setName(name);
	t.setEmail(email);
	t.setMobile(mobile);
	TraineeDAO traineeDAO = new TraineeDAO();
	traineeDAO.insertTrainee(t);
	out.println(t);
	response.sendRedirect("viewTrainees.jsp");
	%>
</body>
</html>