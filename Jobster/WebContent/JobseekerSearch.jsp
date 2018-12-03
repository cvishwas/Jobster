<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w
ww.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Jobseeker Search</title>
</head>

<body>

<h1>Jobseeker Search</h1>

	<form action="SearchJobseekers" method="POST">
		<table style="with: 50%">
		
		 <!--  job_type, job_categ, salary, pref_loc -->
			<tr>
				<td>Expected Salary (up to)</td>
				<td><input type="range" name="salary" min="0" max="200000" step="1000" /></td>
			</tr>

			<tr>
				<td>Job Type Preference: </td>
					<select name="jobtypeOptions">
					<c:forEach items="${jobtypes}" var="jobtypes">
						<option value=${jobtypes.getID()}>${jobtypes.name}</option>
					</c:forEach>
					<option value="n/a">No Preference/Any</option>
					</select>
			</tr>

			<tr>
				<td>Job Category Preference: </td>
					<select name="jobcategoryOptions">
					<c:forEach items="${jobcategories}" var="jobcategories">
						<option value=${jobcategories.getID()}>${jobcategories.name}</option>
					</c:forEach>
					<option value="n/a">No Preference/Any</option>
					</select>
			</tr>


			
			</table>			

			<input type="submit" value="Submit" />
	</form>






</body>




</html>