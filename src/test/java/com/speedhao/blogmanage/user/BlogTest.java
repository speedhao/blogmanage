package com.speedhao.blogmanage.user;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.speedhao.blogmanage.model.Blog;
import com.speedhao.blogmanage.service.BlogService;

public class BlogTest {
	
	private BlogService blogService;
	
	@Before
	public void addBefore(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml" ,"classpath:conf/spring-mybatis.xml"});
		blogService = (BlogService) context.getBean("blogServiceImpl");
	}
	
	@Test
	public void addUser(){
//		Blog blog = new Blog();
//		blog.setTitle("余豪");
//		System.out.println(blogService.addBlog(blog));
		
//		List<Blog> list = blogService.listBlog("",0,1,5);
//		System.out.println(list.size());
		
//		int count = blogService.countBlog("123",3);
//		System.out.println(count);
		
//		System.out.println(blogService.delBlog(2));
		System.out.println(blogService.getBlogById(2).getContent());
	}
}
