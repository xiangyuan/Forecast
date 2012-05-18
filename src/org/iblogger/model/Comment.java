package org.iblogger.model;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:14:20 PM
 */
public class Comment {

	private int taskCode;
	
	private String taskName;
	
	private String commentContent;
	
	private int prdctTypeCode;
	/**
	 * 权重
	 */
	private int commWeight;//
	/**
	 * 综合评价法
	 */
	private int composeWay;
	
	private String createDate;
	
	private String userId;

	public int getTaskCode() {
		return taskCode;
	}

	public void setTaskCode(int taskCode) {
		this.taskCode = taskCode;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getPrdctTypeCode() {
		return prdctTypeCode;
	}

	public void setPrdctTypeCode(int prdctTypeCode) {
		this.prdctTypeCode = prdctTypeCode;
	}

	public int getCommWeight() {
		return commWeight;
	}

	public void setCommWeight(int commWeight) {
		this.commWeight = commWeight;
	}

	public int getComposeWay() {
		return composeWay;
	}

	public void setComposeWay(int composeWay) {
		this.composeWay = composeWay;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
}
