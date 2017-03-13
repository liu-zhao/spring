package com.le.ac.project.service;

import java.util.List;

import com.le.ac.project.model.User;

public interface UserService {

	public User getUser(User u) ; 
	
	public List getFunctionByUser(User u);
	
	public User getUserById(User u);
	
	public List getAllUserByRole(User u);
}
