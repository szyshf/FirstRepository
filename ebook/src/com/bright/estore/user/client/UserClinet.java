package com.bright.estore.user.client;

import com.bright.estore.user.biz.IUserService;
import com.bright.estore.user.biz.impl.UserServiceImpl;
import com.bright.estore.user.model.UserModel;

public class UserClinet {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		IUserService service = new UserServiceImpl();
		UserModel userModel = new UserModel();
		userModel.setUserName("accp");
		userModel.setPassword("accp");
		if (service.verifyUser(userModel)) {
			System.out.println("合法用户!");
		} else {
			System.out.println("非法用户!");
		}

	}

}
