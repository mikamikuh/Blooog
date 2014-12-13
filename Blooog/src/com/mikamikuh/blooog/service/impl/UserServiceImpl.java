package com.mikamikuh.blooog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mikamikuh.blooog.dao.UserDAO;
import com.mikamikuh.blooog.entity.User;
import com.mikamikuh.blooog.service.UserService;

@Service("userService")
@Transactional(readOnly = false)
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDao;

	@Override
	public User findByUserName(String userName) {
		return userDao.findById(userName);
	}

	@Override
	@Transactional(readOnly = false)
	public void saveUser(User user) {
		userDao.saveUser(user);
	}

	@Override
	@Transactional(readOnly = false)
	public void deleteUser(String userName) {
		User user = userDao.findById(userName);
		if (user != null) {
			userDao.delete(user);
		}
	}
}
