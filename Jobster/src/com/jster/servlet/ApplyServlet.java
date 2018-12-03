package com.jster.servlet;

import com.jster.beans.JobApplication;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ApplyServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

		String fname=request.getParameter("firstName");
		String lname=request.getParameter("lastName");
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		String zip=request.getParameter("zip");
		String dateOB=request.getParameter("dateOfBirth");
		String phoneNumber=request.getParameter("phoneNumber");
		String email=request.getParameter("email");
		
		String school=request.getParameter("schoolAttended");
		String degree=request.getParameter("degree");
		String major=request.getParameter("major");
		String dateGraduated=request.getParameter("dateGrad");
		String gpa=request.getParameter("gpa");
		
		String companyName=request.getParameter("compName");
		String jobTitle=request.getParameter("jobTitle");
		String dateStart=request.getParameter("dateStart");
		String dateEnd=request.getParameter("dateEnd");
		
		String workElig=request.getParameter("workElig");
		
		JavaBeans application=new JavaBeans();
		application.setFirstName(fname);
		application.setLastName(lname);
		application.setAddress(address);
		application.setCity(city);
		application.setState(state);
		application.setCountry(country);
		application.setZip(zip);
		application.setDoB(dateOB);
		application.setPhoneNumber(phoneNumber);
		application.setEmail(email);
		
		application.setSchoolAttended(school);
		application.setDegree(degree);
		application.setMajor(major);
		application.setGradDate(dateGraduated);
		application.setGPA(gpa);
		
		application.setCompName(companyName);
		application.setJobTitle(jobTitle);
		application.setDateStarted(dateStart);
		application.setDateEnd(dateEnd);
		
		application.setWorkElig(workElig);
		
		System.out.println(application.toString());
		
		//System.out.println(fname);
		//System.out.println(lname);
		//System.out.println(address);
		//System.out.println(city);
		//System.out.println(zip);
		//System.out.println(state);
		//System.out.println(country);
		//System.out.println(dateOB);
		//System.out.println(phoneNumber);
		//System.out.println(email);
		
		//System.out.println(school);
		//System.out.println(degree);
		//System.out.println(major);
		//System.out.println(dateGraduated);
		//System.out.println(gpa);
		
		//System.out.println(companyName);
		//System.out.println(jobTitle);
		//System.out.println(dateStart);
		//System.out.println(dateEnd);
		
		//System.out.println(workElig);
		
	}
}