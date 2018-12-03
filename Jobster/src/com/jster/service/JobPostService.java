package com.jster.service;

import java.util.List;

import com.jster.beans.JobPost;

public interface JobPostService {
	List<JobPost> getPostList(Integer userId); 
	Integer addDelFavoritePostJob(int userId, int jobPostId);
	List<JobPost> getPostList(Integer userId, String inputDate, char index);
	
}
