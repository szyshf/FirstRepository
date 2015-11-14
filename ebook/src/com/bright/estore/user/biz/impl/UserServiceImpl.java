package com.bright.estore.user.biz.impl;

import com.bright.estore.user.biz.IUserService;
import com.bright.estore.user.dao.IUserDAO;
import com.bright.estore.user.dao.impl.UserSqlServerDAOImpl;
import com.bright.estore.user.model.UserModel;

public class UserServiceImpl implements IUserService {

	public boolean verifyUser(UserModel userModel) {
		// TODO Auto-generated method stub
		IUserDAO userDAO = new UserSqlServerDAOImpl();
		return userDAO.verifyUser(userModel);
	}

}
