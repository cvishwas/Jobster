package com.sample.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchJobseekers extends HttpServlet {
	 
	   private SearchJobseekerDAO dbl;
	   public void init() throws ServletException {
	      // Do required initialization
	      dbl = new SearchJobseekerDAO("system", "sysdba");
	   }

	   public void doPost(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
	      
	      // Set response content type
	      response.setContentType("text/html");
	      	      

	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	    
	     
	      
		 Vector<Jobseeker> jobseekers =  dbl.DB_Search_Jobseekers(Integer.parseInt(request.getParameter("salary")), request.getParameter("jobtypeOptions"), request.getParameter("jobcategoryOptions"));
		 
		 // This is probably bad practice, but this is the way I knew how to do it at the time of writing this code
		 if (!jobseekers.isEmpty()) {
			 out.println("<form method=\"POST\" action=\"AddJobseekerFav\"");
			 out.println("<fieldset>");
			 out.println("<legend>Check suitable candidates for interview</legend>");
			 for(Jobseeker s:jobseekers) {
				 out.print("<input type=\"checkbox\" name=\"jobseeker\" value=\""+s.getID()+"\">"+"<h1>" + s.getFirstName()  + " " + s.getLastName() + "</h1><br>");
			 }
			 out.println("<input type=\"submit\" value=\"Submit Now\"/>");
			 out.println("</fieldset>");
			 out.println("</form>");
		 }else {
			 	out.println("<h1>" + "no users found" + "</h1>");
			 	response.setHeader("Refresh", "3; URL=JobseekerSearch.jsp");
		 }
		 
	   }

	   public void destroy() {
	      // do nothing.
	   }
	}
