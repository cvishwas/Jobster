package com.jster.util;
import com.jster.connection.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jster.beans.*;

public class UserUtil {
	
//	returns a boolean if username and password is valid 
//	if valid set the user_obj to contain 
//	the id from the table 
//	set the password attribute in user_obj to null (for security)
	public static boolean isUserValid(User user_obj){
		boolean ret = false;
		Connection conn = DBConnection.getConnection();
		PreparedStatement s = null;
		ResultSet rs = null;
		try{
			String sql = "Select * from Users where username = ?";
			s = conn.prepareStatement(sql);
			s.setString(1, user_obj.getUser_name());
			rs = s.executeQuery();
//			check if return set is empty (ie user name is not in the table)
			if (!rs.isBeforeFirst()) {
				ret = false;
			}
//			user name is in table
			else {
				rs.next();
//				check if username and password is correct
				if(user_obj.getUser_name().equals(rs.getString(2)) && user_obj.getPassword().equals(rs.getString(3))) {
//					setId for object
//					Null the password for the object
					user_obj.setId(rs.getInt(1));
					user_obj.setPassword(null);
					ret = true;
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try {
				if (rs != null){
					rs.close();
				}
				
				if (s != null){
					s.close();
				}
				
				if (conn != null){
					conn.close();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ret;
	}
	
//	insert new user to Users Table
	public static void commitNewUser(User user_obj){
		Connection conn = DBConnection.getConnection();
		PreparedStatement s = null;
		
		try {
			String sql =  "insert into Users (user_id, username, password, f_name, l_name, acc_type, email, address)"
						+ "values(users_seq.nextval,?,?,?,?,?,?,?)";
			s = conn.prepareStatement(sql);
			s.setString(1, user_obj.getUser_name());
			s.setString(2, user_obj.getPassword());
			s.setString(3, user_obj.getF_name());
			s.setString(4, user_obj.getL_name());
			s.setInt(5, user_obj.getAcc_type());
			s.setString(6, user_obj.getEmail());
			s.setString(7, user_obj.getAddress());
			s.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
				try {
					if (s != null){
						s.close();
					}
					
					if (conn != null){
						conn.close();
					}
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
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "Select * from Users where username = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, user_obj.getUser_name());
			rs = ps.executeQuery();
			
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
				if (rs != null){
					rs.close();
				}
				
				if (ps != null){
					ps.close();
				}
				
				if (conn != null){
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return ret;
	}
	
//	load into user_obj the information from the Users table
//	This is a setter for user_obj
//	This method assunes the user_obj id is set (so we could use it to query)
	public static void loadUserObj(User user_obj){
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			String sql = "Select * from Users where user_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, user_obj.getId());
			rs = ps.executeQuery();
			
//			check if rs is empty
			if (!rs.isBeforeFirst()) {
//				something went horribly wrong if this is True
				System.out.println("This User DOES NOT EXIST!");
			}
			else {
				rs.next(); //obtain user info into rs
				user_obj.setF_name(rs.getString(4));
				user_obj.setL_name(rs.getString(5));
				user_obj.setAcc_type(rs.getInt(6));
				user_obj.setEmail(rs.getString(7));
				user_obj.setAddress(rs.getString(8));
				
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if (rs != null){
					rs.close();
				}
				
				if (ps != null){
					ps.close();
				}
				
				if (conn != null){
					conn.close();
				}
			}
			catch (SQLException e){
				e.printStackTrace();
			}
		}
		
	}
	
//	For Testing Purposes
	public static void main(String args[]){
		User test_user = new User();
		test_user.setUser_name("tim");
		test_user.setPassword("123");
		System.out.println(UserUtil.isUserNameAval(test_user));
//		UserUtil.commitNewUser(test_user);
		System.out.println(UserUtil.isUserNameAval(test_user));
//		test_user.setPassword("321");
		System.out.println(UserUtil.isUserValid(test_user));
		UserUtil.loadUserObj(test_user);
		System.out.println(test_user);
	}
}
