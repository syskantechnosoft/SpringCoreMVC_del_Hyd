<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body bgcolor="orange">
	<h1>Welcome to JSP!!</h1>
	<b><marquee bgcolor="green">
			Today date is :
			<%=new Date()%>
		</marquee></b>
	<a href="viewTrainees.jsp">View All Trainees</a>

</body>
</html>