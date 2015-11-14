package com.bright.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class Utils {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			// dataSource :java:comp/env/jdbc/books
			Context ic = getContext();
			DataSource source = (DataSource) ic.lookup("jdbc/books");
			conn = source.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Context getContext() {
		Context ct = null;
		try {
			Properties props = new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,
					"weblogic.jndi.WLInitialContextFactory");
			props.put(Context.PROVIDER_URL, "t3://localhost:7001");
			props.put(Context.SECURITY_PRINCIPAL, "weblogic");
			props.put(Context.SECURITY_CREDENTIALS, "weblogic");
			ct = new InitialContext(props);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ct;
	}

	public static void close(PreparedStatement pstmt, Connection conn) {
		close(null, pstmt, conn);
	}

	public static void close(ResultSet rst, PreparedStatement pstmt,
			Connection conn) {
		try {

			if (rst != null) {
				rst.close();
				rst = null;
			}

			if (pstmt != null) {
				pstmt.close();
				pstmt = null;
			}

			if (conn != null || !conn.isClosed()) {
				conn.close();
				conn = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
