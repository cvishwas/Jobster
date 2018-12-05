package src.com.jster.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/recommendedJob")
public class SearchJobseekersPreprocess extends HttpServlet {
	   private SearchJobseekerDAO dbl;
	   public void init() throws ServletException {
	      dbl = new SearchJobseekerDAO("system", "sysdba");
	   }
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
			      throws ServletException, IOException {
		   
		   
				  
	   }
}