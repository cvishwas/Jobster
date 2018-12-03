package com.jster.servlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jster.beans.JobPost;
import com.jster.service.JobPostService;
import com.jster.service.impl.JobPostServiceImpl;

 
/**
 * Servlet implementation
 */
@WebServlet(name="viewposts", urlPatterns ="/viewposts", loadOnStartup=1)
public class JobPostServlet extends HttpServlet {
    
    private JobPostService jps;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JobPostServlet() {
        super();
        jps = new JobPostServiceImpl();
        // TODO Auto-generated constructor stub
    }
 
    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	doPost(request, response);  	
    }
 
    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    	String str = request.getQueryString();
     	List<JobPost> list = null;
     	Integer userId;
    	try {
    		userId = Integer.parseInt(request.getQueryString().split("userId=")[1].split("&")[0]);
    	} catch (NullPointerException ex) {
    		userId = -1;
    	}
    	/******get the list depending on button was clicked*******************/
	   	char showListBy = ' ';
	   	String searchD = request.getParameter("searchName");
	    if(request.getParameter("search") != null) {
		   	String searchType = request.getParameter("searchType");
		  	/*******show list if button search was clicked**************/
		   	if (searchType == null) {
		   	} else if(searchType.equals("type")) {
		   		showListBy ='t';
		   	} else if(searchType.equals("category")) {
		   		showListBy = 'k';
		   	} else if (searchType.equals("state")) {
		   		showListBy = 's';
		   	} else if (searchType.equals("city")) {
		   		showListBy = 'c';
		   	}
		   	request.setAttribute("searchType", null);
		   	request.setAttribute("searchName", null);
	    } else if (request.getParameter("showFavorite") != null) {
	    	/*******show favorite posts **************/
	    	showListBy = 'f';
	    } else if(request.getParameter("favorite") != null) {
	    	/****** add/remove post as favorite********/
		   	String postId = request.getParameter("postId");
		   	if(!( postId == null || postId.equals("null"))) {
		    	jps.addDelFavoritePostJob(userId, Integer.parseInt(postId));
	    	}
	    } 
	    
	    list = jps.getPostList(userId, searchD, showListBy);
	    
        request.setAttribute("list", list);
        request.getRequestDispatcher("viewposts.jsp").forward(request, response);
    } 
}