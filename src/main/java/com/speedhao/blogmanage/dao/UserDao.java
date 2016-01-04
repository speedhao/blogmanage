package com.speedhao.blogmanage.dao;

import com.speedhao.blogmanage.model.User;

public interface UserDao {
	/**
     * 添加新用户
     * @param user
     * @return
     */
    public int insertUser(User user);
}
