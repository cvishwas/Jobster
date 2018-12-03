package com.jster.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JobseekerSearch")
public class SearchJobseekersPreprocess extends HttpServlet {
	   private DBLayer dbl;
	   public void init() throws ServletException {
	      dbl = new DBLayer("system", "sysdba");
	   }
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {

			   	  Vector<JobType> jobtypes = dbl.DB_GetAllJobTypes();
			   	  Vector<JobCategory> jobcategories = dbl.DB_GetAllJobCategories();

			   	  request.setAttribute("jobtypes", jobtypes);
			   	  request.setAttribute("jobcategories", jobcategories);
			   	  
			   	  request.getRequestDispatcher("JobseekerSearch.jsp").forward(request, response);
	   }
}