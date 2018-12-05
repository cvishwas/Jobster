<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobster Job Recommendation</title>
</head>
<body>


	<form method="Get">
		<table>
			<tr>
			<tr>
				<td><h4>Job</h4></td>
				<td><h4>Field</h4></td>
				<td><h4>location</h4></td>
			</tr>

			<tr>
				<% try{
					rs = statement.executeQuery("SELECT * FROM job_post");
					while (rs.next()){
				%>

				<tr>
				<td> <%=rs.getString("post_title") %> </td>
				<td> <%=rs.getString("field") %> </td>
				<td> <%=rs.getString("location") %> </td>
				</tr>
				<tr>
				<td colspan="3"> <%=rs.getString("job_description") %> </td>
				</tr>
				<%	
					}
				} catch (Exception e){
					e.printStackTrace();
				}
				%>
			</tr>
		</table>

	</form>
</body>
</html>