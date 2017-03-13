package com.le.ac.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.le.ac.project.model.Function;
import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("manager")
	public String userManager(HttpServletRequest request)
	{
		Integer uid = Integer.parseInt(request.getParameter("userid"));
		User u = new User();
		u.setUid(uid);
		u=userService.getUserById(u);
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
	public String addUser(HttpServletRequest request)
	{
		return "/addUser";
	}
}
