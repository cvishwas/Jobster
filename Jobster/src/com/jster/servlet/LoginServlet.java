package com.jster.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jster.beans.User;
import com.jster.util.UserUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		
//		System.out.println(UserUtil.isUserNameAval(sessUser));
//		check if User object is vaild
		if(UserUtil.isUserValid(sessUser)){
			
//			store user object in session to be passed along
			HttpSession sess = request.getSession(true);
			sess.setAttribute("UserObj", sessUser);
			
			
			//		step 3 generate html
			out.println("<html><body>");
			out.println("User confirmed");
			out.println("<br></br>");
			out.println("<a href=test.jsp>Go to test Page</a>");
			out.println("</body></html>");
		}
		else{ 
			// Credentials are invalid
//			step 3 generate html
			out.println("<html><body>");
			out.println("FAILED");
			out.println("<br></br>");
			out.println("<a href=portal.html>Return to Home</a>");
			out.println("</body></html>");
		}
	}

}
