package com.le.ac.project.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;

@Controller
@RequestMapping("login")
public class UserController {
	@Autowired
	UserService userService;
	@RequestMapping("lg")
	public String memberlogin(HttpServletRequest request)
	{
		String name =(String) request.getParameter("username");
		String pwd = (String) request.getParameter("password");
		User u = new User();
		u.setName(name);
		u.setPassword(pwd);
		boolean flag=userService.getUser(u);
		if(flag){
			System.out.println("ok!");
		return "null";
		}
		System.out.println("fail!");
		return null;
		}
}
