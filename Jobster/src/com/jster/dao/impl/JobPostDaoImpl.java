package com.jster.dao.impl;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import com.jster.dao.JobPostDao;

public class JobPostDaoImpl implements JobPostDao{

    private String GET_ALL_POSTS = "Select jp.job_id, jp.job_description, jp.created_date, \n" + 
    								"u.user_id, u.username, u.f_name, u.l_name, u.email,\n" + 
    								"l.location_id, l.city, l.state_province, l.postal_code,\n" + 
    								"jc.categ_id, jc.categ_name, jt.type_id, jt.type_name, juf.user_id\n" + 
    								"From Job_Post jp \n" + 
    								"Inner Join Users u \n" + 
    								"On u.user_id = jp.employer_id \n" + 
    								"Inner Join User_Job_Location usl \n" + 
    								"On usl.job_id = jp.job_id \n" + 
    								"Inner Join Location l\n" + 
    								"On usl.location_id = l.location_id \n" + 
    								"Inner Join Job_Post_Categ jpc\n" + 
    								"On jpc.post_id = jp.job_id \n" + 
    								"Inner Join Job_Category jc\n" + 
    								"On jpc.category_id = jc.categ_id\n" + 
    								"Inner Join Job_Post_Type jpt\n" + 
    								"On jpt.post_id = jp.job_id \n" + 
    								"Inner Join Job_Type jt\n" + 
    								"On jpt.type_id = jt.type_id\n" + 
    								"Left Outer Join Job_User_Favorites juf\n" + 
    								"On juf.job_id = jp.job_id ";


    public List<JobPost> getPostsList(Integer userId) {
        List<JobPost> list = new ArrayList<>();
        try {
            Statement stmt = DBConnection.getConnection().createStatement();

            ResultSet rs = stmt.executeQuery(GET_ALL_POSTS);

            while (rs.next()) {
                Integer idPost = rs.getInt(1);
                JobPost jp =  list.stream().filter(x -> x.getId().equals(idPost)).findFirst().orElse(null);
                if (jp != null) {
                    jp.getJobTypes().add(new JobType(rs.getInt(15), rs.getString(16)));
                    jp.getJobCategories().add(new JobCategory(rs.getInt(13), rs.getString(14)));
                    jp.getLocations().add(new Location(rs.getInt(9), null, rs.getString(10), rs.getString(11),rs.getString(12)));
                    jp.setIsLikedJobPost(rs.getInt(17)==userId ? true: jp.getIsLikedJobPost());
                } else {
                    list.add(new JobPost(idPost, 
                    					 new User(rs.getInt(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)), 
                    					 new HashSet<>(Arrays.asList(new JobType(rs.getInt(15), rs.getString(16)))),  
                    					 new HashSet<>(Arrays.asList(new JobCategory(rs.getInt(13), rs.getString(14)))), 
                    					 new HashSet<>(Arrays.asList(new Location(rs.getInt(9), null, rs.getString(10), rs.getString(11),rs.getString(12)))), 
                    					 rs.getDate(3), 
                    					 rs.getString(2), 
                    					 rs.getInt(17) == userId ? true: false));

                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

}
