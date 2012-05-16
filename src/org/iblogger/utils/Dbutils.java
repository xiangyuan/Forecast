package org.iblogger.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @title
 * @author ForYY
 * @version 1.0 May 16, 2012 8:52:26 PM
 */
public final class Dbutils {

	public static final String driverName = "com.mysql.jdbc.Driver";

	public static final String url = "jdbc:mysql://127.0.0.1:3306/yytest";

	public static final String userName = "root";

	public static final String uPwd = "";

	/**
	 * @return
	 */
	public final Connection getConn() {
		Connection conn = null;
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, userName, uPwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (conn);
	}
	
	/**
	 * 查询相关的ptmt信息
	 * @param conn
	 * @param sql
	 * @return
	 */
	public final PreparedStatement getPtmt(Connection conn,String sql) {
		PreparedStatement ptmt = null;
		try {
			ptmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (ptmt);
	}
	
}
