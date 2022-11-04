<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.syskan.CRUDDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Generic CRUD</title>
</head>
<body bgcolor="cyan">
	<marquee><%=new Date()%></marquee>
	<%
	CRUDDAO crudDAO = new CRUDDAO();
	List<String> tables = new ArrayList<String>();
	tables = crudDAO.getTableNames();
	int i = 1;
	%>
	<table bgcolor="orange" border="1" align="center">
		<tr>
			<th>Sl No</th>
			<th>Table Name</th>
			<th>Actions</th>
		</tr>
		<%
		for (String table : tables) {
		%>
		<tr>
			<td><%=i%></td>
			<td><%=table%></td>
			<td><a href="viewTable.jsp?table=<%=table%>">View</a> || <a
				href="deleteTable.jsp?table=<%=table%>">Delete</a></td>
		</tr>

		<%
		i++;
		}
		%>
	</table>
</body>
</html>