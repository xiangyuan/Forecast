package org.iblogger.dao;

import java.util.List;

import org.iblogger.model.Comment;

/**
 * 
 * @title
 * 	查看某一个评价任务信息
 * @author ForYY
 * @version 1.0 May 19, 2012 12:59:12 PM
 */
public interface TaskAction extends Action {

	/**
	 * 
	 * @return
	 */
	public List<Comment> queryTask();
	/**
	 * 
	 * @param taskId
	 * @return
	 */
	public boolean deleteTask(int taskId);
	/**
	 * 查看某一个评价任务信息
	 * @param product
	 * @return
	 */
	public boolean updateTask(Comment task);
	
	/**
	 * 查看某一个评价任务信息
	 * @param id
	 * @return
	 */
	public Comment queryTask(int id);}
