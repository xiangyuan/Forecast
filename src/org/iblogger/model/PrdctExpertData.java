package org.iblogger.model;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:36:57 PM
 */
public class PrdctExpertData {

	private int prdctCode;
	
	private int factorCode;
	
	private int expertCdoe;
	/**
	 * 优 良 中 差 误差
	 */
	private String rankLevel;
	public int getPrdctCode() {
		return prdctCode;
	}
	public void setPrdctCode(int prdctCode) {
		this.prdctCode = prdctCode;
	}
	public int getFactorCode() {
		return factorCode;
	}
	public void setFactorCode(int factorCode) {
		this.factorCode = factorCode;
	}
	public int getExpertCdoe() {
		return expertCdoe;
	}
	public void setExpertCdoe(int expertCdoe) {
		this.expertCdoe = expertCdoe;
	}
	public String getRankLevel() {
		return rankLevel;
	}
	public void setRankLevel(String rankLevel) {
		this.rankLevel = rankLevel;
	}
	
}
