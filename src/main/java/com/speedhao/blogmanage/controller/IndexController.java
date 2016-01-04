package com.speedhao.blogmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//后台管理首页
@Controller
@RequestMapping("/")
public class IndexController {

	//后台管理框架首页
	@RequestMapping("index")
	public String index(Model model){
		model.addAttribute("name", "index");
		return "index";
	}
	
}
