package com.le.ac.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.le.ac.project.model.User;
import com.le.ac.project.service.UserService;
/**
 * 
 * @author liu
 *
 */
@Controller
@RequestMapping("/")
public class IndexController {
	@Autowired
	UserService userService;
	@RequestMapping("/")
	public String index(HttpServletRequest request)
	{
		return "/login";
	}
	
	@RequestMapping("login")
	public String login(HttpServletRequest request)
	{
		String name =request.getParameter("username");
		String pwd = request.getParameter("password");
		User u = new User();
		u.setUsername(name);
		u.setPassword(pwd);
		User user=userService.getUser(u);	
		if(user != null){
			HttpSession session =  request.getSession();
			session.setAttribute("user", user);
		return "frameset";
		}
		System.out.println("fail!");
		return "/login";
		}
	@RequestMapping("header")
	public String header(HttpServletRequest request)
	{
		User user= (User) request.getSession().getAttribute("user");	
		request.setAttribute("user", user);
		return "header";
	}
	@RequestMapping("menu")
	public String menu(HttpServletRequest request)
	{
		User user= (User) request.getSession().getAttribute("user");	
		List flist = userService.getFunctionByUser(user);
		
		request.setAttribute("flist", flist);
		return "menu";
	}
	@RequestMapping("content")
	public String content(HttpServletRequest request)
	{
		return "content";
	}
}
