package org.iblogger.model;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 19, 2012 1:17:33 PM
 */
public class User {

	private int userId;
	
	private String pwd;
	
	private int userType;
	
	private String userName;
	
	private String userCompany;
	
	private String userEmail;
	
	private String regDate;
	
	private int isPast;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCompany() {
		return userCompany;
	}

	public void setUserCompany(String userCompany) {
		this.userCompany = userCompany;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getIsPast() {
		return isPast;
	}

	public void setIsPast(int isPast) {
		this.isPast = isPast;
	}
	
}
