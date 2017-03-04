package com.le.ac.project.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.le.ac.core.dao.BaseDao;
import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;
@Component
public class UserServiceImpl implements UserService {
	
	private BaseDao baseDao = new BaseDao<>();
	@Override
	public boolean getUser(User u) {
		String hql="from User t where t.username=? and t.password=?";
		List list = baseDao.find(hql,u.getUsername(),u.getPassword());
		if(list.isEmpty())
		{
			return false;
		}
		return true;
	}

}
