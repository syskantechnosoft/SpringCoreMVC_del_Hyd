<%@page import="java.util.TreeMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.syskan.CRUDDAO"%>
<%@page import="com.syskan.entity.Table"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Table Contents</title>
</head>
<body bgcolor="cyan">
	<%
	String table = request.getParameter("table");
	Table t = new Table();
	CRUDDAO crudDAO = new CRUDDAO();
	t = crudDAO.getTableData(table);
	TreeMap<String, String> row = new TreeMap();
	List<TreeMap<String, String>> rows = new ArrayList<TreeMap<String, String>>();
	rows = t.getRows();
	row = rows.get(1);
	int i = 1;
	Set<String> colNames = row.keySet();
	//out.print("row : " + row);
	//out.print("rows:" + rows);
	%>
	<div align="center">
		<a href="index.jsp">Home</a> &nbsp; <a
			href="addRecord.jsp?table=<%=table%>">Add a Record</a>
	</div>
	<table bgcolor="orange" border="1" align="center">
		<tr>
			<%
			for (String col : colNames) {
			%>
			<th><%=col%></th>
			<%
			}
			%>
			<th>Actions</th>
		</tr>
		<%
		for (TreeMap<String, String> r : rows) {
			row = r;
			out.print("<tr>");
			for (String col : colNames) {
				out.print("<td>" + row.get(col) + "</td>");
			}
			out.print("<td><a href='editColumn.jsp?id=${row.get(\"id\")}'>Edit</a>||<a href=''>Delete</a></td>");
			out.print("</tr>");
		}
		%>
	</table>
</body>
</html>