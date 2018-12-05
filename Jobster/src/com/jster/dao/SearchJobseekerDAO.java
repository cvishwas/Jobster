package src.com.jster.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class SearchJobseekerDAO {
	Connection con = null;
	DBConnection dbcon = new DBConnection();
	
	public SearchJobseekerDAO(String username, String password) {
		con = dbcon.getDBConnection("system", "sysdba");
	}
	
	
	public Vector<Jobseeker> DB_Search_Jobseekers(int salaryReq, String jobtypePref, String jobcategPref) {
		Vector<Jobseeker> jobseekers = new Vector<Jobseeker>();
		String jobtypeQuery = " INNER JOIN JOB_TYPE ON USER_PREFERENCES.JOB_TYPE=JOB_TYPE.TYPE_ID "+
							   "AND JOB_TYPE.TYPE_ID ="+jobtypePref;
				
		String jobcategQuery = " INNER JOIN JOB_CATEGORY ON USER_PREFERENCES.JOB_CATEG=JOB_CATEGORY.CATEG_ID "+
							  "AND JOB_CATEGORY.CATEG_ID ="+jobcategPref;
		
		String salaryQuery = "SELECT USERS.F_NAME, USERS.L_NAME, USERS.EMAIL, USER_PREFERENCES.SALARY, USERS.USER_ID FROM Users " + 
				"INNER JOIN USER_PREFERENCES ON USERS.USER_ID = USER_PREFERENCES.USER_ID " + 
				"AND USERS.ACC_TYPE=1 " + 
				"AND USER_PREFERENCES.SALARY <= "+salaryReq;
		String overallQuery;
		
		System.out.println(" Jobtype pref: " + jobtypePref + " and job categ pref: " + jobcategPref);
		boolean test = jobcategPref.equals("n/a");
		System.out.println(test);
		
		
		try {
			Statement s = con.createStatement();
			if (jobtypePref.equals("n/a")) {
				overallQuery = salaryQuery;
			}else {
				overallQuery = salaryQuery + jobtypeQuery;
			}
			
			if (!jobcategPref.equals("n/a")) {
				overallQuery += jobcategQuery;
			}
			
			
			
			ResultSet rs = s.executeQuery(overallQuery);
			
			while(rs.next()) {
				Jobseeker js = new Jobseeker();
				js.setFirstName(rs.getString("F_NAME"));
				js.setLastName(rs.getString("L_NAME"));
				js.setEmail(rs.getString("EMAIL"));
				js.setSalary(Integer.parseInt(rs.getString("SALARY")));
				js.setID(Integer.parseInt(rs.getString("USER_ID")));
				jobseekers.add(js);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jobseekers;
	}
	
	public String DB_ID_to_Name(int user_id) {
		String str = "";
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT USERS.F_NAME, USERS.L_NAME FROM Users WHERE USERS.user_id = " + user_id);
			while(rs.next()) {
				str = rs.getString("F_NAME") + rs.getString("L_NAME");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return str;
	}
	
	public Vector<JobType> DB_GetAllJobTypes(){
		Vector<JobType> jt_vec = new Vector<JobType>();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Job_Type.type_id, Job_Type.type_name FROM Job_Type");
			while(rs.next()) {
				JobType jt = new JobType();
				jt.setID(Integer.parseInt(rs.getString("type_id")));
				jt.setName(rs.getString("type_name"));
				jt_vec.add(jt);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}	
		return jt_vec;
		
	}
	
	public Vector<JobCategory> DB_GetAllJobCategories(){
		Vector<JobCategory> jc_vec = new Vector<JobCategory>();
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("SELECT Job_Category.categ_id, Job_Category.categ_name FROM Job_Category");
			while(rs.next()) {
				JobCategory jc = new JobCategory();
				jc.setID(Integer.parseInt(rs.getString("categ_id")));
				jc.setName(rs.getString("categ_name"));
				jc_vec.add(jc);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return jc_vec;
	}
	
	public int DB_setFavorites(int employer_id, int user_id) {
		int success = 0;
		 try {
			 Statement s = con.createStatement();
			 success = s.executeUpdate("INSERT INTO EMPLOYER_FAVORITES (user_id, employer_id, to_interview) VALUES ("+user_id+","+employer_id+", 0)");
		 }catch(SQLException e) {
			 e.printStackTrace();
		 }
		 
		 return success;
	}
	
	public int DB_toggleInterview(int employer_id, int user_id) {
		int success = 0;
		
		try {
			Statement s = con.createStatement();
			success = s.executeUpdate("UPDATE EMPLOYER_FAVORITES SET to_interview = 1 - to_interview WHERE employer_id = "+employer_id+" AND user_id = "+user_id);
		}catch(SQLException e) {
			 e.printStackTrace();

		}
		return success;
	}

}
