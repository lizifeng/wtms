package org.lizf.user.dao;

import org.lizf.user.model.User;

public interface UserDao {

	public User login(String username, String password);

	public User findUserById(String id);

	public boolean changePassword(User user);

	public boolean removeUserById(String id);

}
