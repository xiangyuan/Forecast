package org.iblogger.model;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:05:33 PM
 */
public class Product {

	private int prdctCode;
	
	private int cpnCode;//企业外健
	
	private String cpnName;
	

	private int prdctSeq;//产品排名
	
	private int prdctDesc;//产品细节
	
	private String prdctName;
	
	private String prdctModel;
	
	private String prdctParam;
	
	private String prdctPath;
	
	private String prdctIntro;//产品简介 
	
	private String postTime;//发布时间 

	public int getPrdctCode() {
		return prdctCode;
	}

	public void setPrdctCode(int prdctCode) {
		this.prdctCode = prdctCode;
	}

	public int getCpnCode() {
		return cpnCode;
	}

	public void setCpnCode(int cpnCode) {
		this.cpnCode = cpnCode;
	}
	
	public String getCpnName() {
		return cpnName;
	}

	public void setCpnName(String cpnName) {
		this.cpnName = cpnName;
	}

	private String prdctTypeName;
	
	public String getPrdctTypeName() {
		return prdctTypeName;
	}

	public void setPrdctTypeName(String prdctTypeName) {
		this.prdctTypeName = prdctTypeName;
	}

	public int getPrdctSeq() {
		return prdctSeq;
	}

	public void setPrdctSeq(int prdctSeq) {
		this.prdctSeq = prdctSeq;
	}

	public int getPrdctDesc() {
		return prdctDesc;
	}

	public void setPrdctDesc(int prdctDesc) {
		this.prdctDesc = prdctDesc;
	}

	public String getPrdctName() {
		return prdctName;
	}

	public void setPrdctName(String prdctName) {
		this.prdctName = prdctName;
	}

	public String getPrdctModel() {
		return prdctModel;
	}

	public void setPrdctModel(String prdctModel) {
		this.prdctModel = prdctModel;
	}

	public String getPrdctParam() {
		return prdctParam;
	}

	public void setPrdctParam(String prdctParam) {
		this.prdctParam = prdctParam;
	}

	public String getPrdctPath() {
		return prdctPath;
	}

	public void setPrdctPath(String prdctPath) {
		this.prdctPath = prdctPath;
	}

	public String getPrdctIntro() {
		return prdctIntro;
	}

	public void setPrdctIntro(String prdctIntro) {
		this.prdctIntro = prdctIntro;
	}

	public String getPostTime() {
		return postTime;
	}

	public void setPostTime(String postTime) {
		this.postTime = postTime;
	}

	@Override
	public String toString() {
		return this.prdctName + this.prdctModel;
	}
}
