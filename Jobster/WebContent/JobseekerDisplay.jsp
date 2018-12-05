<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://w
ww.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>

<body>
	<form method="POST" action="AddJobseekerFav">
	<fieldset>
	<legend>Check suitable candidates for interviewing</legend>
	
	<c:forEach items="${jobseekers}" var="jobseekers">
		<input type="checkbox" name="jobseeker" value="${jobseekers.getID()}"/>${jobseekers.getFirstName()} ${jobseekers.getLastName()}<br>
	</c:forEach>
		<input type="submit" value="Submit Now"/>
	</fieldset>
	
	
	
	</form>




</body>




</html>

