<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Job Application</title>
</head>
<body>
<h1>Please fill in the information to apply</h1>
<h3>Personal Information</h3>
<form action="ApplicationSubmit">
	First name:<br>
	<input type="text" name="firstName">
	<br>
	Last name:<br>
	<input type="text" name="lastName">
	<br>
	Address:<br>
	<input type="text" name="address">
	<br>
	City:<br>
	<input type="text" name="city">
	<br>
	Zip Code:<br>
	<input type="number" name="zip">
	<br>
	State:<br>
	<input type="text" name="state">
	<br>
	Country:<br>
	<input type="text" name="country">
	<br>
	Date of Birth:<br>
	<input type="date" name="dateOfBirth">
	<br>
	Phone Number:<br>
	<input type="text" name="phoneNumber">
	<br>
	Email:<br>
	<input type="email" name="email">
	
	<h3>Academic Information</h3>
	School Attended:<br>
	<input type="text" name="schoolAttended">
	<br>
	Degree: <br>
	<input type="text" name="degree">
	<br>
	Major: <br>
	<input type="text" name="major">
	<br>
	Date Graduated:<br>
	<input type="number" name="dateGrad">
	<br>
	GPA:<br>
	<input type="number" name="gpa">
	<br>

	<h3>Employment History</h3>
	Company Name:<br>
	<input type="text" name="compName">
	<br>
	Job Title:<br>
	<input type="text" name="jobTitle">
	<br>
	Date Started:<br>
	<input type="date" name="dateStart">
	<br>
	Date Finished:<br>
	<input type="date" name="dateEnd">
	<br>

	<h3>Other</H3>
	Are you eligible to work in the U.S.?
	<br><input type="radio" name="workElig" value="Yes">Yes
	<br><input type="radio" name="workElig" value="No">No
	<br>
	<input type="submit" value="Apply">
</form>




</body>
</html>