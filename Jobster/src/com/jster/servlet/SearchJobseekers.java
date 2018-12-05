package src.com.jster.servlet;

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
	      
	      // Important, implement a way to get the employer ID here
	      int employerID = 1; // request.getParameter?

	     
	      
		 Vector<Jobseeker> jobseekers =  dbl.DB_Search_Jobseekers(Integer.parseInt(request.getParameter("salary")), request.getParameter("jobtypeOptions"), request.getParameter("jobcategoryOptions"));
		 
		 
		 if (!jobseekers.isEmpty()) {
		   	  request.setAttribute("jobseekers", jobseekers);
		   	 
		   	  request.getRequestDispatcher("JobseekerDisplay.jsp").forward(request, response);
		   	  
		 }else {
			 out.println("<h1>" + "No users found! Redirecting" + "</h1>");
			 response.setHeader("Refresh",  "3; URL=JobseekerSearch.jsp");
		 }
		 
	   }

	   public void destroy() {
	      // do nothing.
	   }
	}
