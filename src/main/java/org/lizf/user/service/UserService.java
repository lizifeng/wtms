package org.lizf.user.service;

import org.lizf.user.dao.UserDao;
import org.lizf.user.model.User;

public class UserService {
	
	private UserDao userDao;
	
	public User login(String username, String password) {
		return userDao.login(username, password);
	}
	
}
