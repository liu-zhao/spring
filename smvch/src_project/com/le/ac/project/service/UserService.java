package com.le.ac.project.service;

import java.io.IOException;
import java.util.List;

import com.le.ac.core.util.Page;
import com.le.ac.project.model.User;

public interface UserService {

	public User getUser(User u) ; 
	
	public List getFunctionByUser(User u);
	
	public User getUserById(User u);
	
	public List getAllUserByRole(User u);
	
	public Page getUserByRole(User u) throws Exception;
	
	public int saveOrUpdateUser(User u);
	public int updateUser(User u) throws Exception;
	
	public boolean saveNewUser(User u);
	
	public boolean deleteUser(User u) throws Exception;
	
	public Page getAllUser(User u) throws Exception;
}
