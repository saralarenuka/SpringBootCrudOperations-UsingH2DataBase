package com.in.service;

import java.util.List;

import com.in.entity.User;

public interface UserService {

	public User saveUserDetails(User user) ;
	public User getOneUser(Integer id);
	public List<User> getUserDetails();
}
