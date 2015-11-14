package com.bright.estore.order.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.bright.estore.order.dao.IUserOrderDAO;
import com.bright.estore.order.model.OrderModel;
import com.bright.util.Utils;

public class UserOrderSqlServerDAOImpl implements IUserOrderDAO {

	public boolean saveOrder(OrderModel orderModel) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean flag = false;
		try{
			conn = Utils.getConnection();
			String sql = "insert into BOokOrder(username,zipcode,phone,creditcard,total) values(?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,orderModel.getUserName());
			pstmt.setString(2, orderModel.getZipcode());
			pstmt.setString(3,orderModel.getPhone());
			pstmt.setString(4,orderModel.getCreditCard());
			pstmt.setDouble(5,orderModel.getTotal());
			int i = pstmt.executeUpdate();
			if(i>0){
				flag = true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			Utils.close(pstmt, conn);
		}
		return flag;
	}

}
