package com.jster.beans;

import java.util.List;

import com.jster.beans.JobPost;

public class User {
	private int id;
	private String user_name;
	private String password;
	private String f_name;
	private String l_name;
	private String address;
	private String email;
	private int acc_type;
    private List<JobPost> jobPostList;
	
	public User(){
		
	}
	

	public User(int id, String user_name, String f_name, String l_name, String email) {
		super();
		this.f_name = f_name;
		this.id = id;
		this.user_name = user_name;
		this.l_name = l_name;
		this.email = email;
	}



	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getL_name() {
		return l_name;
	}

	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAcc_type() {
		return acc_type;
	}

	public void setAcc_type(int acc_type) {
		this.acc_type = acc_type;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", user_name=" + user_name + ", password=" + password + ", f_name=" + f_name
				+ ", l_name=" + l_name + ", address=" + address + ", email=" + email + ", acc_type=" + acc_type
				+ ", jobPostList=" + jobPostList + "]";
	}
	
	
	
}
