package org.iblogger.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.iblogger.dao.UserDao;
import org.iblogger.exception.DaoException;
import org.iblogger.model.User;
import org.iblogger.utils.DateFormatUtils;
import org.iblogger.utils.Dbutils;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 19, 2012 4:44:07 PM
 */
public class UserDaoImpl implements UserDao {

	@Override
	public User registUser(User u) throws DaoException{
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet result = null;
		try {
			conn = Dbutils.getConn();
			String sql = "insert Users(UserName,UserPassword,UserEmail) values (?,?,?);";
			ptmt = Dbutils.getPtmt(conn, sql);
			
			ptmt.setString(1, u.getUserName());
			ptmt.setString(2, u.getPwd());
			ptmt.setString(3, u.getUserEmail());
			int c = ptmt.executeUpdate();
			if (c > 0) {
				return u;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("查找用户出现异常");
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteUser(int id) throws DaoException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUser(User u) throws DaoException{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User loginUser(String userName, String password) throws DaoException {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet result = null;
		User user = null;
		try {
			conn = Dbutils.getConn();
			String sql = " select * from Users where userName= ? and UserPassword = ?";
			ptmt = Dbutils.getPtmt(conn, sql);
			
			ptmt.setString(1, userName);
			ptmt.setString(2, password);
			
			result = ptmt.executeQuery();
			if (result != null && result.next()) {
				user = new User();
				user.setUserId(result.getInt("UserId"));
				user.setUserName(result.getString("UserName"));
				user.setRegDate(DateFormatUtils.formatDate(result.getDate("RegDate")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new DaoException("查找用户出现异常");
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (user);
	}

}
