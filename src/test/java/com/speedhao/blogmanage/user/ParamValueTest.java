package com.speedhao.blogmanage.user;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.speedhao.blogmanage.service.ParamValueService;

public class ParamValueTest {
	
	private ParamValueService paramValueService;
	
	@Before
	public void addBefore(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:conf/spring.xml" ,"classpath:conf/spring-mybatis.xml"});
		paramValueService = (ParamValueService) context.getBean("paramValueServiceImpl");
	}
	
	@Test
	public void addUser(){
		//System.out.println(paramValueService.getValue("reply_type", "2"));
		System.out.println(paramValueService.getCVbyName("blog_type").size());
	}
	
}
