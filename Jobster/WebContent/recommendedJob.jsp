<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page import="java.sql.SQLException"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Jobster Job Recommendation</title>
</head>
<body>
	<%
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/MOURADAK", "SYSTEM", "admin");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	%>
	<nav class="navbar navbar-light bg-light">
		<a class="navbar-brand text-info text-italic" href="">Jobster</a>
		<!-- Search post by posts, categories, states, cities -->
		<form
			action="viewposts?userId=<%=request.getParameter("userId")%>#search"
			method="POST" class="mx-auto">
			<div class="form-inline">
				<input class="form-control mr-sm-2" type="search" method="POST"
					name="searchName" placeholder="Search">
				<button class="btn btn-outline-info my-2 my-sm-0" name="search"
					type="submit">Search</button>
			</div>
			<div class="mx-auto">
				<input type="radio" name="searchType" value="type"> by Type
				<input type="radio" name="searchType" value="category"> by
				Category <input type="radio" name="searchType" value="city">
				by City <input type="radio" name="searchType" value="state">
				by State
			</div>
		</form>
		<a class="nav-item nav-link btn-info" href="#">Log out</a>
	</nav>
	<form method="Get" action="RecommendedJob">
		<table>
			<tr>
				<td><h4>Job</h4></td>
				<td><h4>Field</h4></td>
				<td><h4>location</h4></td>
			</tr>

			<tr>
				<%
					try {
						Statement s = con.createStatement();
						rs = statement.executeQuery("Select jp.job_description, location.city, jp.job_title, jp.created_date"
								+ "From job_post jp" + "Join user_job_location ujl ON (ujl.job_id = jp.job_id)"
								+ "Join Location ON (Location.location_id = jp.job_id)"
								+ "Where location.city = (Select l.city From location l"
								+ "Join user_job_location ujl ON (ujl.location_id = l.location_id)"
								+ "Join users ON (users.user_id = ujl.user_id)" + "Where users.user_id = '1')");
						while (rs.next()) {
				%>
			
			<tr>
				<td><%=rs.getString("job_title")%></td>
				<td></td>
				<%-- <td> <%=rs.getString("created_date") %> </td> --%>
				<td><%=rs.getString("location")%></td>
			</tr>
			<tr>
				<td colspan="3"><%=rs.getString("job_description")%></td>
			</tr>
			<%
				}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					try {
						//rs.close();
						con.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			%>
		</table>

	</form>
</body>
</html>