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
	<input type="text" name="firstName" required>
	<br>
	Last name:<br>
	<input type="text" name="lastName" required>
	<br>
	Address:<br>
	<input type="text" name="address" required>
	<br>
	City:<br>
	<input type="text" name="city" required>
	<br>
	Zip Code:<br>
	<input type="number" name="zip" min="0" max="99999" required>
	<br>
	State:<br>
	<input type="text" name="state" required>
	<br>
	Country:<br>
	<input type="text" name="country" required>
	<br>
	Date of Birth:<br>
	<input type="date" name="dateOfBirth" required>
	<br>
	Phone Number:<br>
	<input type="text" name="phoneNumber" max="9999999999" required >
	<br>
	Email:<br>
	<input type="email" name="email" required>
	
	<h3>Academic Information</h3>
	School Attended:<br>
	<input type="text" name="schoolAttended" required>
	<br>
	Degree: <br>
	<input type="text" name="degree" required>
	<br>
	Major: <br>
	<input type="text" name="major" required>
	<br>
	Date Graduated:<br>
	<input type="date" name="dateGrad">
	<br>
	GPA:<br>
	<input type="number" name="gpa" min="0" max="4">
	<br>

	<h3>Employment History</h3>
	Company Name:<br>
	<input type="text" name="compName" required>
	<br>
	Job Title:<br>
	<input type="text" name="jobTitle" required>
	<br>
	Date Started:<br>
	<input type="date" name="dateStart" required>
	<br>
	Date Finished:<br>
	<input type="date" name="dateEnd" required>
	<br>

	<h3>Other</H3>
	Are you eligible to work in the U.S.?
	<br><input type="radio" name="workElig" value="Yes" required>Yes
	<br><input type="radio" name="workElig" value="No" required>No
	<br>
	<input type="submit" value="Apply">
</form>




</body>
</html>
