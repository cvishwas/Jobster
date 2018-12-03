package com.jster.dao;

import java.util.List;

import com.jster.beans.JobPost;

public interface JobPostDao {
	List<JobPost> getPostsList(Integer userId);

}
