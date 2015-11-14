package com.bright.estore.service.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bright.estore.service.dao.IServiceDAOSqlServer;
import com.bright.util.Utils;

public class ServiceDAOSqlServerImpl implements IServiceDAOSqlServer {

	public int creditProcess(String creditCard, double total) {
		// TODO Auto-generated method stub
		int ret = 0;
		Connection  conn = null;
		PreparedStatement pstmt = null;
		ResultSet rst = null;
		String sql = "update account set balance = balance - ? where creditcard = ?";
		try{
			conn = Utils.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1,total);
			pstmt.setString(2,creditCard);
			ret = pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			Utils.close(rst,pstmt, conn);
		}
		return ret;
	}

}
