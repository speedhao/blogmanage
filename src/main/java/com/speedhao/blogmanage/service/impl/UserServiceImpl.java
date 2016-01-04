package com.speedhao.blogmanage.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.speedhao.blogmanage.dao.UserDao;
import com.speedhao.blogmanage.model.User;
import com.speedhao.blogmanage.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public int insertUser(User user) {
		return userDao.insertUser(user);
	}

}
