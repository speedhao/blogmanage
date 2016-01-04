package com.speedhao.blogmanage.service;

import java.util.List;

import com.speedhao.blogmanage.model.Blog;

public interface BlogService {
	
	/**
	 * 添加文章
	 * @param blog
	 * @return 成功返回1
	 */
	public int addBlog(Blog blog);
	
	/**
	 * 按条件分页查询博客
	 * @param title
	 * @param type
	 * @param page 当前页
	 * @param size 每页数量
	 * @return
	 */
	public List<Blog> listBlog(String title,int type,int page,int size);
	
	/**
	 * 按条件获取博客的数量
	 * @param title 名称中包含
	 * @param type 类型
	 * @return 数量
	 */
	public int countBlog(String title,int type);
	
	/**
	 * 逻辑删除博客
	 * @param bid 博客id
	 * @return 成功返回1
	 */
	public int delBlog(int bid);
	
	/**
	 * 发布博客
	 * @param bid 博客id
	 * @return 成功返回1
	 */
	public int openBlog(int bid);
	
	/**
	 * 按id查询单个博客
	 * @param bid
	 * @return
	 */
	public Blog getBlogById(int bid);
	
	/**
	 * 更新博客
	 * @param blog
	 * @return  成功返回1
	 */
	public int updateBlog(Blog blog);
}
