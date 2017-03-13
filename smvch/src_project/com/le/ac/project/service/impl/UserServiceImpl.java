package com.le.ac.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.le.ac.core.dao.HibernateDao;
import com.le.ac.core.hibernate.SimpleHibernateDaoImpl;
import com.le.ac.project.model.Function;
import com.le.ac.project.model.Role_func;
import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;
@Component
public class UserServiceImpl<T> extends HibernateDao<T> implements UserService{
	
	
	@Override
	public User getUser(User u) {
		String hql="from User t where t.username=? and t.password=?";
		List list=super.find(hql, u.getUsername(),u.getPassword());
		User user = null;
		try {
			user =(User) list.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}

	@Override
	public List getFunctionByUser(User u) {
//		List flist = new ArrayList<>();
//		String hql="from Role_func rf  where rf.role=?";
//		List list=super.find(hql, u.getRole());
//		for (int i = 0; i < list.size(); i++) {
//			Role_func rf = (Role_func)list.get(i);
//			String hql2="from Function f where f.fid = ?";
//			List temp =  super.find(hql2, rf.getFid());
//			Function f = (Function) temp.get(0);
//			flist.add(f);
//		}
		String hql="from Role_func rf left join fetch rf.function where rf.role=?";
		List list=super.find(hql, u.getRole());
		
		return list;
	}

	@Override
	public User getUserById(User u) {
		String hql="from User u where u.uid=?";
		List temp =super.find(hql,u.getUid());
		try {
			u = (User) temp.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public List getAllUserByRole(User u) {
		List userList = new ArrayList<>();
		if(u.getRole()==0)
		{
			//superAdmin
			userList = super.find("from User");
		}
		if(u.getRole()==10)
		{
			//normal admin
			String hql="from User u where u.role != ?";
			userList = super.find(hql,0);
		}
		if(u.getRole()==11)
		{
			//normal user
			userList.add(u);
		}
		return userList;
	}
	
}
