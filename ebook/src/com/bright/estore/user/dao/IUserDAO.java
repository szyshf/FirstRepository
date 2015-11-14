package com.bright.estore.user.dao;

import com.bright.estore.user.model.UserModel;

public interface IUserDAO {
	public boolean verifyUser(UserModel userModel);
}
