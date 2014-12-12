package com.mikamikuh.blooog.service;

import com.mikamikuh.blooog.entity.User;

public interface UserService {

	User findByUserName(String userName);

	void saveUser(User user);

	void deleteUser(String userName);

}
