package com.speedhao.blogmanage.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//登录类操作类
@Controller
@RequestMapping("/")
public class LoginController {
	
	//登录页面
	@RequestMapping("login")
	public String login(HttpSession session){
		if(session.getAttribute("user") != null)
		{
			return "redirect:index.do";
		}
		return "login";
	}
	
	//登录动作
	@RequestMapping("doLogin")
	public String doLogin(HttpSession session,HttpServletRequest request){
		if(session.getAttribute("user") != null)
		{
			return "redirect:index.do";
		}
		String password = (String)request.getParameter("password");
		if("123".equals(password))
		{
			session.setAttribute("user", "speedhao");
			return "redirect:index.do";
		}
		else
		{
			return "redirect:login.do";
		}
	}
	
	//登出动作
	@RequestMapping("doLogout")
	public String doLogout(HttpSession session,HttpServletRequest request){
		if(session.getAttribute("user") != null)
		{
			session.removeAttribute("user");
		}
		return "redirect:login.do";
	}
	
}
