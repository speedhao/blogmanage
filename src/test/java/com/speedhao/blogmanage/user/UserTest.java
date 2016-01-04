package com.speedhao.blogmanage.user;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedhao.blogmanage.model.User;
import com.speedhao.blogmanage.service.UserService;

public class UserTest {
	
	private UserService userService;
	
	@Before
	public void addBefore(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml" ,"classpath:conf/spring-mybatis.xml"});
		userService = (UserService) context.getBean("userServiceImpl");
	}
	
	@Test
	public void addUser(){
		 User user = new User();
	     user.setUser_name("yuhao111");
	     System.out.println(userService.insertUser(user));
	}
}
