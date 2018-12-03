package com.jster.dao;

import java.util.List;

import com.jster.beans.JobPost;

public interface UserFavoritePostJobDao {
	Integer addDeleteFavoritePostJob(int userId, int jobPostId);
	List<JobPost> getFavoritesJobPost(int userId);
}
