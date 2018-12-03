package com.jster.service.impl;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import com.jster.beans.JobPost;
import com.jster.dao.UserFavoritePostJobDao;
import com.jster.dao.impl.JobPostDaoImpl;
import com.jster.dao.impl.UserFavoritePostJobDaoImpl;
import com.jster.service.JobPostService;

public class JobPostServiceImpl implements JobPostService{

    private JobPostDaoImpl jpd;
    private UserFavoritePostJobDao upj;

    public JobPostServiceImpl() {
        jpd = new JobPostDaoImpl();
        upj = new UserFavoritePostJobDaoImpl();
    }

    public List<JobPost> getPostList(Integer userId, String searchData, char index) {
    	/*******get favorites users post*******************/
    	if(index == 'f') 
    		return upj.getFavoritesJobPost(userId);
    	
    	List <JobPost> list = jpd.getPostsList(userId);
    	
    	switch (index) { 
    		/******** filter posts by types*****************************/
    		case 't': {
    			list = list.stream().filter(x -> {
       			 	return x.getJobTypes().stream().filter (
       			 		y -> {
       						 Pattern pattern = Pattern.compile(searchData.toLowerCase());
       						 Matcher matcher = pattern.matcher(y.getName().toLowerCase());
       						 return matcher.find();
       			 		}).collect(Collectors.toList()).size() > 0;
    			}).collect(Collectors.toList());
    			
    			break;
    		}
    		/******** filter posts by categories*****************************/
    		case 'k' : {
    			list = list.stream().filter(x -> {
       			 	return x.getJobCategories().stream().filter (
       			 		y -> {
       			 			Pattern pattern = Pattern.compile(searchData.toLowerCase());
       			 			Matcher matcher = pattern.matcher(y.getName().toLowerCase());
       			 			return matcher.find();
       			 		}).collect(Collectors.toList()).size() > 0;
    	    	}).collect(Collectors.toList());
    	    	break;
    		}
    		/******** filter posts by states*****************************/
    		case 's' : {
    			list = list.stream().filter(x -> {
       			 	return x.getLocations().stream().filter (
       			 			y -> {
       			 				Pattern pattern = Pattern.compile(searchData.toLowerCase());
       			 				Matcher matcher = pattern.matcher(y.getStateProvince().toLowerCase());
       			 				return matcher.find();
       			 			}).collect(Collectors.toList()).size() > 0;
    			}).collect(Collectors.toList());
    			break;
    		}
    		/******** filter posts by cities*****************************/
    		case 'c' : {
    			list = list.stream().filter(x -> {
       			 	return x.getLocations().stream().filter (
       			 		y -> {
       			 			Pattern pattern = Pattern.compile(searchData.toLowerCase());
       			 			Matcher matcher = pattern.matcher(y.getCity().toLowerCase());
       			 			return matcher.find();
       			 		}).collect(Collectors.toList()).size() > 0;
    			}).collect(Collectors.toList());
    			break;
    		}
    	}
    	return list.stream().sorted((o1,o2) -> o2.getDate().compareTo(o1.getDate())).collect(Collectors.toList());
    }
    /********get all posts*************/
    public List<JobPost> getPostList(Integer userId) {
        return jpd.getPostsList(userId);
    }

    
    /*******add to user favorite posts**************/
    public Integer addDelFavoritePostJob(int userId, int jobPostId) {
    	return upj.addDeleteFavoritePostJob(userId, jobPostId);
    }
    
}
