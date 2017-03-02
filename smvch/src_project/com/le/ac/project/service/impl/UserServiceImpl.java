package com.le.ac.project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Override
	public boolean getUser(User u) {
		// TODO Auto-generated method stub
		return false;
	}

}
