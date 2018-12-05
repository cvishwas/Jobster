package com.jster.servlet;
import com.jster.beans.*;
import com.jster.util.*;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//		step 1 set content type
		response.setContentType("text/html");

		//		step 2 get print writer
		PrintWriter out = response.getWriter();
		
		User sessUser = new User();
		sessUser.setUser_name(request.getParameter("username"));
		sessUser.setPassword(request.getParameter("password"));
		sessUser.setF_name(request.getParameter("f_name"));
		sessUser.setL_name(request.getParameter("l_name"));
		sessUser.setEmail(request.getParameter("email"));
		sessUser.setAddress(request.getParameter("address"));
		String account_type = request.getParameter("account_type");
		if (account_type.equals("Employer")){
			sessUser.setAcc_type(1);
		}
		else{
			sessUser.setAcc_type(2);
		}
		
		
//		System.out.println(sessUser.getUser_name());
//		check if username is avilable
		if(UserUtil.isUserNameAval(sessUser)){
			UserUtil.commitNewUser(sessUser);
			//		step 3 generate html
			out.println("<html><body>");
			out.println("User Registered");
			out.println("<br></br>");
			out.println("<a href=portal.html>Return to Home</a>");
			out.println("</body></html>");
		}
		else{
//			step 3 generate html
			out.println("<html><body>");
			out.println("FAILED: UserName Taken");
			out.println("<br></br>");
			out.println("<a href=portal.html>Return to Home</a>");
			out.println("</body></html>");
		}
		
////		step 3 generate html
//		out.println("<html><body>");
//		out.println("Test confirmed");
//		out.println("<br></br>");
//		out.println("<a href=portal.html>Return to Home</a>");
//		out.println("</body></html>");
		

		
	}

}
