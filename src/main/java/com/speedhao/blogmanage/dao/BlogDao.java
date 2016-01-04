package com.speedhao.blogmanage.dao;

import java.util.List;
import java.util.Map;

import com.speedhao.blogmanage.model.Blog;

public interface BlogDao {
	
	/**
	 * 添加博客
	 * @param blog
	 * @return 成功返回1
	 */
	public int insertBlog(Blog blog);
	
	/**
	 * 按条件分页查询
	 * @return
	 */
	public List<Blog> selectBlog(Map<String,Object> map);
	
	/**
	 * 按条件查询数量
	 * @param blog
	 * @return
	 */
	public int countBlog(Blog blog);
	
	/**
	 * 逻辑删除博客
	 * @param blog
	 * @return 成功返回1
	 */
	public int delBlog(Blog blog);
	
	/**
	 * 发布博客
	 * @param blog
	 * @return 成功返回1
	 */
	public int openBlog(Blog blog);
	
	/**
	 * 按id查询
	 * @param blog
	 * @return
	 */
	public List<Blog> getBlog(Blog blog);
	
	/**
	 * 更新博客内容
	 * @param blog
	 * @return 成功返回1
	 */
	public int updateBlog(Blog blog);
}
