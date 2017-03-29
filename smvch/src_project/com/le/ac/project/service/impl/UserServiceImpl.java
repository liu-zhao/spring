package com.le.ac.project.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.le.ac.core.dao.HibernateDao;
import com.le.ac.core.hibernate.SimpleHibernateDaoImpl;
import com.le.ac.core.util.Page;
import com.le.ac.core.util.Pager;
import com.le.ac.project.model.Function;
import com.le.ac.project.model.Role_func;
import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;
@Service
@Transactional
public class UserServiceImpl<T> extends HibernateDao<T> implements UserService{
	
	
	@Override
	public User getUser(User u) {
		String hql="from User t where t.username=? and t.password=?";
		List list=super.find(hql, u.getUsername(),u.getPassword());
		User user = null;
		if(list.size()==0)
		{
			return null;
		}
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
	/**
	 * returnMessage is 0 means that insert operating successed
	 * 1 means that update operating successed!
	 */
	@Override
	public int saveOrUpdateUser(User u) {
		int flag=1;
		this.update(u);
		return flag;
	}

	@Override
	public boolean saveNewUser(User u){
		User user  = getUser(u);
		if(user !=null)
		{
			return false;
		}
		super.save(u);
		return true;
	}

	@Override
	public Page<T> getUserByRole(User u) throws Exception {
		Page<T> userList = new Page<>();
		if(u.getRole()==0)
		{
			//superAdmin
			userList = this.getAll(userList);
		}
		if(u.getRole()==10)
		{
			//normal admin
			String hql="from User u where u.role != ?";
			userList = this.findPage(userList, hql, 0);
			//userList = super.find(hql,0);
		}
		if(u.getRole()==11)
		{
			//normal user
			
		}
		return userList;
		
	}

	@Override
	public boolean deleteUser(User u) throws Exception {
		this.delete(u);
		return true;
	}

	@Override
	public Page getAllUser(User u) throws Exception {
		Page userlist = new Page<>();
		if(u.getRole()==0)
		{
			//superAdmin
			userlist = this.findPage(userlist, "from User u where u.status=?",0);
			
		}
		if(u.getRole()==10)
		{
			//normal admin
			String hql="from User u where u.role != ?";
			userlist = this.findPage(userlist, hql,0);
		}
		if(u.getRole()==11)
		{
			//normal user
			//userlist.add(u);
			List list = new ArrayList<>();
			list.add(u);
			userlist.setResult(list);
		}
		return userlist;
	}

	@Override
	public int updateUser(User u) throws Exception {
		
		this.update(u);
		//this.getSession().flush();
		return 1;
	}

	@Override
	public Pager getAllUserPager(User u, String currentPage, String pageSize) throws Exception {
		if(u.getRole()==0)
		{
			//superAdmin
			StringBuffer hql = new StringBuffer("from User u where u.status=0");
			if (!StringUtils.isEmpty(u.getUsername())) {
			return this.pagedQuery(hql.toString(), currentPage, pageSize);
			}
			
		}
		if(u.getRole()==10)
		{
			//normal admin
			StringBuffer hql = new StringBuffer(
					"from User u where u.status=0 and u.role!=0");
			if (!StringUtils.isEmpty(u.getUsername())) {	
			return this.pagedQuery(hql.toString(), currentPage, pageSize);
			}
		}
		if(u.getRole()==11)
		{
			StringBuffer hql = new StringBuffer(
					"from User u where u.status=0 and u.role!=0 u.uid="+u.getUid());
			if (!StringUtils.isEmpty(u.getUsername())) {
			return this.pagedQuery(hql.toString(), currentPage, pageSize);
			}
		}
		return null;
	}
	
}
