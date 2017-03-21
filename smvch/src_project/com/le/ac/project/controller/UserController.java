package com.le.ac.project.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.le.ac.core.util.Page;
import com.le.ac.project.model.Function;
import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("manager")
	public String userManager(HttpServletRequest request)
	{
		User u =(User)request.getSession().getAttribute("user");
		if(u.getRole() ==11)
		{
			request.setAttribute("user", u);
			return "/userDetail";
		}
		List userList = userService.getAllUserByRole(u);
		if(userList.isEmpty())
		{
			return "/error";
		}
		request.setAttribute("userList", userList);
		return "/userManager";
	}
	@RequestMapping("add")
	public String add(HttpServletRequest request)
	{
		
			return "/addUser";
		
	}
	@RequestMapping("addUser")
	public String addUser(HttpServletRequest request)
	{
		
		User u = new User();
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setEmail(request.getParameter("email"));
		u.setTel(request.getParameter("tel"));
		u.setRole(11);
		u.setStatus(0);
		try {
			boolean flag = userService.saveNewUser(u);
			if(flag)
			{
				return userManager(request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/error";
	}
	@RequestMapping("getUser")
	public String getUser(HttpServletRequest request)
	{
		User u = (User)request.getSession().getAttribute("user");
		Page pageList = null;
		try {
			pageList=userService.getAllUser(u);
			
			if(pageList.getTotalCount()==-1)
			{
				return "/error";
			}
			List userList=userService.getAllUserByRole(u);
			request.setAttribute("pageList", userList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/getUsers";
	}
	@RequestMapping("update")
	public String update(HttpServletRequest request)
	{
		User u= new User();
		u.setUid(Integer.parseInt(request.getParameter("uid")));
		u=userService.getUserById(u);
		request.setAttribute("user", u);
		return "/update";
	}
	@RequestMapping("updateUser")
	public String updateUser(HttpServletRequest request)
	{
		User u = new User();
		u.setUid(Integer.parseInt(request.getParameter("uid")));
		u.setUsername(request.getParameter("username"));
		u.setPassword(request.getParameter("password"));
		u.setEmail(request.getParameter("email"));
		u.setTel(request.getParameter("tel"));
		u.setRole(11);
		u.setStatus(0);
		int flag;
		try {
			flag = userService.updateUser(u);
			if(flag==1)	
				return getUser(request);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return "/error";
	}
	@RequestMapping("delete")
	public String delete(HttpServletRequest request)
	{
		User u = new User();
		try {
			userService.deleteUser(u);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@RequestMapping("deleteList")
	public String deleteList(HttpServletRequest request)
	{
		String userids[] = request.getParameterValues("checkbox");
		
		return null;
	}
	@RequestMapping("deleteajax")
	public String deleteajax(HttpServletRequest request,HttpServletResponse response)
	{
		String uid = request.getParameter("uid");
		String uuu = request.getParameter("uuu");
		System.out.println(uid+"!!!"+uuu);
		PrintWriter out= null;
		String value="ok";
		String str="{\"name\":\""+value+"\"}";
		
//		JSONObject json = new JSONObject();
//		json.put("ok", value);
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.write(str);
		out.flush();
		out.close();
		return null;
	}
	
}
