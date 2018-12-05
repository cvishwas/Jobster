package src.com.jster.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddJobseekerFav extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SearchJobseekerDAO dbl;
	
	public void init() {
	    dbl = new SearchJobseekerDAO("system", "sysdba");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      // Set response content type
	      response.setContentType("text/html");
	      // Actual logic goes here.
	      PrintWriter out = response.getWriter();
	      
	      String[] jobseekers = request.getParameterValues("jobseeker");
	      for (String s: jobseekers) {
	    	  System.out.println(s);
	    	  if (s == null) {
	    		  System.out.println("Yoink");
	    	  }
	      }

	      out.println("<h1> To be interviewed: </h1>" );
	      for(String s: jobseekers) {
	    	  if (s != null) {
		    	  out.println("<h1> "+s+" </h1>");
		    	  int resultFav = dbl.DB_setFavorites(1, Integer.parseInt(s));
		    	  int resultInterview = dbl.DB_toggleInterview(1, Integer.parseInt(s));
	    	  } 	 
	      }
	}
	
	public void destroy() {
		
	}

}
