package com.bright.estore.user.dao.impl;

import com.bright.estore.user.dao.IUserDAO;
import com.bright.estore.user.model.UserModel;
import com.bright.util.Utils;

import java.sql.*;

public class UserSqlServerDAOImpl implements IUserDAO {

	public boolean verifyUser(UserModel userModel) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		boolean flag = false;
		try{
			conn = Utils.getConnection();
			String sql = "select 1 from userinfo where loginName = ? and password = ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userModel.getUserName());
			pstmt.setString(2, userModel.getPassword());
			
			rst = pstmt.executeQuery();
			if (rst.next()){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//close
		}
		return flag;
	}

}
