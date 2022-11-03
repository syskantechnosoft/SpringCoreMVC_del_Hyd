<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Trainee</title>
</head>
<body bgcolor="green">
	<table border="1" bgcolor="purple">
		<form action="addTrainee.jsp" method="get">
			<tr>
				<th>Sl No</th>
				<th>Trainee Property</th>
				<th>Trainee Value</th>
			</tr>
			<tr>
				<td>1</td>
				<td>Name :</td>
				<td><input type="text" name="name"
					placeholder="Enter Trainee Name here" required="required" /></td>
			</tr>
			<tr>
				<td>2</td>
				<td>Email :</td>
				<td><input type="email" name="email"
					placeholder="Enter Trainee Email here" required="required" /></td>
			</tr>
			<tr>
				<td>3</td>
				<td>Mobile :</td>
				<td><input type="number" name="mobile"
					placeholder="Enter Trainee Mobile Number here" required="required" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="reset" value="clear" /></td>
				<td><input type="submit" value="Add a Trainee" /></td>
			</tr>
		</form>
	</table>
</body>
</html>