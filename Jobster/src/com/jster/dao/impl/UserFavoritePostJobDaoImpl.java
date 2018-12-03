package com.jster.dao.impl;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import com.jster.beans.JobCategory;
import com.jster.beans.JobPost;
import com.jster.beans.JobType;
import com.jster.beans.Location;
import com.jster.beans.User;
import com.jster.connection.DBConnection;
import com.jster.dao.UserFavoritePostJobDao;

public class UserFavoritePostJobDaoImpl implements UserFavoritePostJobDao {

	private String INSERT_DELETE_PROCEDURE = "Call inst_dlt_usr_favorite_post(?,?,?)";
	private String SELECT_FAVORITES_POSTS_BY_USER = "Select jp.job_id, jp.job_description, jp.created_date, "
										+ "u.user_id, u.username, u.f_name, u.l_name, u.email, l.location_id, "
										+ "l.city, l.state_province, l.postal_code, jc.categ_id, jc.categ_name, "
										+ "jt.type_id, jt.type_name "
										+ "From Job_Post jp "  
										+ "Inner Join Users u "  
										+ "On u.user_id = jp.employer_id "  
										+ "Inner Join User_Job_Location usl " 
										+ "On usl.job_id = jp.job_id "  
										+ "Inner Join Location l " 
										+ "On usl.location_id = l.location_id "  
										+ "Inner Join Job_Post_Categ jpc " 
										+ "On jpc.post_id = jp.job_id "  
										+ "Inner Join Job_Category jc " 
										+ "On jpc.category_id = jc.categ_id "  
										+ "Inner Join Job_Post_Type jpt "  
										+ "On jpt.post_id = jp.job_id "  
										+ "Inner Join Job_Type jt "  
										+ "On jpt.type_id = jt.type_id " 
										+ "Inner Join Job_User_Favorites juf " 
										+ "On juf.job_id = jp.job_id Where juf.user_id = ?";
	
	
	@Override
	public Integer addDeleteFavoritePostJob(int userId, int jobPostId) {
		int result = -1;
		try {
			CallableStatement stmt = DBConnection.getConnection().prepareCall(INSERT_DELETE_PROCEDURE);
			stmt.setInt(1, userId);
			stmt.setInt(2, jobPostId);
			stmt.registerOutParameter(3, Types.INTEGER);
			
			stmt.executeUpdate();
			
			result = stmt.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	@Override
	public List<JobPost> getFavoritesJobPost(int userId) {
		List<JobPost> list = new ArrayList<>();
		try {
			PreparedStatement stmt = DBConnection.getConnection().prepareStatement(SELECT_FAVORITES_POSTS_BY_USER);
			stmt.setInt(1, userId);
			
			ResultSet rs = stmt.executeQuery();
		    while (rs.next()) {
		    	Integer idPost = rs.getInt(1);
	            JobPost jp =  list.stream().filter(x -> x.getId().equals(idPost)).findFirst().orElse(null);
	            if (jp != null) {
	            	jp.getJobTypes().add(new JobType(rs.getInt(15), rs.getString(16)));
	                jp.getJobCategories().add(new JobCategory(rs.getInt(13), rs.getString(14)));
	                jp.getLocations().add(new Location(rs.getInt(9), null, rs.getString(10), rs.getString(11),rs.getString(12)));
	            } else {
	                list.add(new JobPost(idPost, new User(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)), new HashSet<>(Arrays.asList(new JobType(rs.getInt(15), rs.getString(16)))),  new HashSet<>(Arrays.asList(new JobCategory(rs.getInt(13), rs.getString(14)))), new HashSet<>(Arrays.asList(new Location(rs.getInt(9), null, rs.getString(10), rs.getString(11),rs.getString(12)))), rs.getDate(3), rs.getString(2), true));
	            }
	       }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
