package com.jster.servlet;

import com.jster.beans.JobApplication;
import connection.dbconnection;
import connection.ApplyQuery;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
		
		Date date = new Date();
		String modDate= new SimpleDateFormat("yyyy-MM-dd").format(date);
		
		int currentUserID=1; //temp userId to test functionality
		int currentJobID=1; //temp jobID to test functionality
		
		
		application.setUserId(currentUserID);
		application.setJobId(currentJobID);
		application.setDateApplied(modDate);
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
		System.out.println(application.GET_INSERT_QUERY());
		String sql=(application.GET_INSERT_QUERY());
		
		PreparedStatement prep=null;
		dbconnection dbcon=new dbconnection();
		Connection conn=dbcon.getConnection();
		try {
			prep=conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//ApplyQuery query=new ApplyQuery();
		//Connection conn=dbcon.getConnection();
		//query.runQuery(sql,conn);
		
	}
}
