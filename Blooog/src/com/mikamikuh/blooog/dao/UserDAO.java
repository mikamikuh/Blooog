package com.mikamikuh.blooog.dao;

import com.mikamikuh.blooog.entity.User;

public interface UserDAO extends AbstractDAO<User, String> {
	void saveUser(User user);
}
