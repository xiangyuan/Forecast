package org.iblogger.model;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:43:05 PM
 */
public class TaskResult {

	private int commentCode;
	/**
	 * 外健
	 */
	private int commendPrdctCode;
	
	private String reportURL;

	public int getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}

	public int getCommendPrdctCode() {
		return commendPrdctCode;
	}

	public void setCommendPrdctCode(int commendPrdctCode) {
		this.commendPrdctCode = commendPrdctCode;
	}

	public String getReportURL() {
		return reportURL;
	}

	public void setReportURL(String reportURL) {
		this.reportURL = reportURL;
	}
	
}
