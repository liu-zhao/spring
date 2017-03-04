package com.le.ac.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {
	@Autowired
	UserService userService;
	
	
	@RequestMapping("login")
	public String login(HttpServletRequest request)
	{
		String name =request.getParameter("username");
		String pwd = request.getParameter("password");
		User u = new User();
		u.setUsername(name);
		u.setPassword(pwd);
		boolean flag=userService.getUser(u);
		if(flag){
			System.out.println("ok!");
		return "/index";
		}
		System.out.println("fail!");
		return "/index";
		}
}
