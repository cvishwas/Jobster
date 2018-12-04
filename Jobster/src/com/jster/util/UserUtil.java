package com.jster.util;
import com.jster.connection.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jster.beans.*;

public class UserUtil {
	
//	checks if username and password is valid 
	public static boolean isUserValid(User user_obj){
		boolean ret = false;
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try{
			Statement s = conn.createStatement();
			rs = s.executeQuery("Select * from Users where username = '"+user_obj.getUser_name()+"'");
//			check if return set is empty (ie user name is free)
			if (!rs.isBeforeFirst()) {
				ret = false;
			}
			else {
				rs.next();
				if(user_obj.getUser_name().equals(rs.getString(2)) && user_obj.getPassword().equals(rs.getString(3))) {
					ret = true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ret;
	}
	
//	add new user to Users db
	public static void commitNewUser(User user_obj){
		Connection conn = DBConnection.getConnection();
		
		try {
			Statement s = conn.createStatement();
			String sql = "insert into Users (username, password)" + 
						 "values('" + user_obj.getUser_name() +"','"+user_obj.getPassword()+"')";
			s.executeUpdate(sql);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
//	checks if the Username is NOT TAKEN
	public static boolean isUserNameAval(User user_obj){
		boolean ret = false;
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		try{
			Statement s = conn.createStatement();
			rs = s.executeQuery("Select * from Users where username = '"+user_obj.getUser_name()+"'");
//			check if return set is empty (ie user name is free to be used)
			if (!rs.isBeforeFirst()) {
				ret = true;
			}
			else {
				ret = false;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ret;
	}
	
//	For Testing Purposes
	public static void main(String args[]){
		User test_user = new User();
		test_user.setUser_name("tim");
		test_user.setPassword("123");
		System.out.println(UserUtil.isUserNameAval(test_user));
		UserUtil.commitNewUser(test_user);
		System.out.println(UserUtil.isUserNameAval(test_user));
		test_user.setPassword("321");
		System.out.println(UserUtil.isUserValid(test_user));
	}
}
