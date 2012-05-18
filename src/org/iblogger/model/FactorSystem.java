package org.iblogger.model;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:24:50 PM
 */
public class FactorSystem {

	private int factorCode;
	
	private String factorName;
	
	private int parentCode;//上层编码
	
	private int commentCode;//评价编号
	
	private int isLeaf;

	public int getFactorCode() {
		return factorCode;
	}

	public void setFactorCode(int factorCode) {
		this.factorCode = factorCode;
	}

	public String getFactorName() {
		return factorName;
	}

	public void setFactorName(String factorName) {
		this.factorName = factorName;
	}

	public int getParentCode() {
		return parentCode;
	}

	public void setParentCode(int parentCode) {
		this.parentCode = parentCode;
	}

	public int getCommentCode() {
		return commentCode;
	}

	public void setCommentCode(int commentCode) {
		this.commentCode = commentCode;
	}

	public int getIsLeaf() {
		return isLeaf;
	}

	public void setIsLeaf(int isLeaf) {
		this.isLeaf = isLeaf;
	}
	
}
