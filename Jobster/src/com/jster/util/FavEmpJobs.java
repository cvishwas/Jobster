package com.jster.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class FavEmpJobs implements java.io.Serializable{
	
	public void findJobs(int userId, Connection conn) {
		ResultSet rs = null;
		try {
			Statement state = conn.createStatement();
			
			String query = "Select job_post.job_id, job_post.job_description, job_post.created_date, job_post.employer_id from Job_Post Inner Join User_Favorites_Employee on User_Favorites_Employee.employer_id = Job_Post.employer_id Inner Join Users on Users.user_id = User_Favorites_Employee.user_id WHERE Users.user_id = " + userId;
			rs = state.executeQuery(query);
			
			while(rs.next()){
				//Do whatever we need to do to write the data here
				System.out.println("Job Id : " + rs.getInt(1) +"\nJob Desc : " + rs.getString(2) + "\nCreated Date: " + rs.getDate(3) + "\nEmployee_Id: " + rs.getString(4) +"\n"); 
	
			}			

		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public int findUserNameId(String userName, Connection conn) {
		ResultSet rs = null;
		int retNum = -1;
		try {
			Statement state = conn.createStatement();
			
			String query = "Select user_id from Users_Accounts where username = '" + userName +"'";
			rs = state.executeQuery(query);
			
			if(rs.next()){
				retNum = rs.getInt(1);
				//System.out.println(retNum + " this is the id for username " + userName);
				
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		};
		return retNum;
	}
	
	public void addFavEmp(String userName, String employerName, Connection conn) {
		int userId = findUserNameId(userName, conn);
		if(userId != -1) {
			int employId = findUserNameId(employerName, conn);
			if(employId != -1) {
				addFavEmpDatabase(userId, employId, conn);
			}
			else {
				//Should never hit this in practical use
				System.out.println("Error: Employer not found in on our servers");
			}
		}
		else {
			//Should never hit this in practical use
			System.out.println("Error: User not found in on our servers");
		}
	}
	
	
	public void addFavEmpDatabase(int userId, int employerId, Connection conn) {
		try {
			Statement state = conn.createStatement();
			String query = "Insert into User_Favorites_Employee (user_id, employer_id) values (" + userId+"," + employerId + ")";
			state.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
	}


}
