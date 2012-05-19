package org.iblogger.dao;

import org.iblogger.exception.DaoException;
import org.iblogger.model.User;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 19, 2012 4:41:11 PM
 */
public interface UserDao extends Dao{

	/**
	 * 
	 * @param u
	 * @return
	 */
	public User registUser(User u) throws DaoException;
	
	
	public boolean deleteUser(int id) throws DaoException;
	
	/**
	 * update the user information
	 * @param u
	 * @return
	 */
	public boolean updateUser(User u) throws DaoException;
	
	/**
	 * 用户登录操作信息
	 * @param userName
	 * @param password
	 * @return
	 */
	public User loginUser(String userName,String password) throws DaoException;
}
