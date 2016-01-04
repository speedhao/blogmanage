package com.speedhao.blogmanage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedhao.blogmanage.dao.BlogDao;
import com.speedhao.blogmanage.model.Blog;
import com.speedhao.blogmanage.service.BlogService;

@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Override
	public int addBlog(Blog blog) {
		blog.setCreate_time(new Date());
		return blogDao.insertBlog(blog);
	}

	@Override
	public List<Blog> listBlog(String title,int type,int page,int size) {
		Map<String,Object> map = new HashMap<String, Object>();
		if(!title.equals(""))
		{
			map.put("title", title);
		}
		if(type != 0)
		{
			map.put("type", type);
		}
		map.put("page", (page-1)*size);
		map.put("size", size);
		return blogDao.selectBlog(map);
	}

	@Override
	public int countBlog(String title,int type) {
		Blog blog = new Blog();
		if(!title.equals(""))
		{
			blog.setTitle(title);
		}
		if(type != 0)
		{
			blog.setType(type);
		}
		return blogDao.countBlog(blog);
	}

	@Override
	public int delBlog(int bid) {
		Blog blog = new Blog();
		blog.setId(bid);
		return blogDao.delBlog(blog);
	}

	@Override
	public int openBlog(int bid) {
		Blog blog = new Blog();
		blog.setId(bid);
		return blogDao.openBlog(blog);
	}

	@Override
	public Blog getBlogById(int bid) {
		Blog blog = new Blog();
		blog.setId(bid);
		List<Blog> list = blogDao.getBlog(blog);
		if(list!=null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}

	@Override
	public int updateBlog(Blog blog) {
		return blogDao.updateBlog(blog);
	}

}
