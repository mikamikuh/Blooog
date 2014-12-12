package com.mikamikuh.blooog.dao.impl;

import org.springframework.stereotype.Repository;

import com.mikamikuh.blooog.dao.UserDAO;
import com.mikamikuh.blooog.entity.User;

@Repository
public class UserDAOImpl extends AbstractDAOImpl<User, String> implements
		UserDAO {

	protected UserDAOImpl() {
		super(User.class);
	}

	@Override
	public void saveUser(User user) {
		saveOrUpdate(user);
	}
}
