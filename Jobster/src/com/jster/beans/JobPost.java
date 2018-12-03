package com.jster.beans;

import java.util.Date;
import java.util.Set;

import com.jster.beans.JobCategory;
import com.jster.beans.JobType;
import com.jster.beans.Location;
import com.jster.beans.User;

public class JobPost {
	private Integer id;
    private User user;
    private Set<JobType> jobTypes;
    private Set<JobCategory> jobCategories;
	private String description;
	private java.util.Date date;
    private Set<Location> locations;
    private Boolean isLikedJobPost;
	
	public JobPost(){
		
	}
	

    public JobPost(Integer id, User user, Set<JobType> jobTypes, Set<JobCategory> jobCategories, Set<Location> locationList,  Date createdDate, String jobDescription, Boolean isLikedJobPost) {
        this.id = id;
        this.user = user;
        this.jobTypes = jobTypes;
        this.jobCategories = jobCategories;
        this.locations = locationList;
        this.date = createdDate;
        this.description = jobDescription;
        this.isLikedJobPost = isLikedJobPost;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Set<JobType> getJobTypes() {
		return jobTypes;
	}


	public void setJobTypes(Set<JobType> jobTypes) {
		this.jobTypes = jobTypes;
	}


	public Set<JobCategory> getJobCategories() {
		return jobCategories;
	}


	public void setJobCategories(Set<JobCategory> jobCategories) {
		this.jobCategories = jobCategories;
	}


	public Set<Location> getLocations() {
		return locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	

	public Boolean getIsLikedJobPost() {
		return isLikedJobPost;
	}


	public void setIsLikedJobPost(Boolean isLikedJobPost) {
		this.isLikedJobPost = isLikedJobPost;
	}


	@Override
	public String toString() {
		return "JobPost [id=" + id + ", user=" + user + ", jobTypes=" + jobTypes + ", jobCategories=" + jobCategories
				+ ", description=" + description + ", date=" + date + ", locations=" + locations + ", isLikedJobPost="
				+ isLikedJobPost + "]";
	}

	
	
}
