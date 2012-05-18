package org.iblogger.model;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:33:32 PM
 */
public class ProductFactor {

	private int prdctCode;

	private int factorCode;

	private float quantityVal;
	/**
	 * 量化级别
	 */
	private float quantityLevel;

	private float standardizedVal;
	/**
	 * 无量化结果
	 */
	private float noValResult;

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

	public float getQuantityVal() {
		return quantityVal;
	}

	public void setQuantityVal(float quantityVal) {
		this.quantityVal = quantityVal;
	}

	public float getQuantityLevel() {
		return quantityLevel;
	}

	public void setQuantityLevel(float quantityLevel) {
		this.quantityLevel = quantityLevel;
	}

	public float getStandardizedVal() {
		return standardizedVal;
	}

	public void setStandardizedVal(float standardizedVal) {
		this.standardizedVal = standardizedVal;
	}

	public float getNoValResult() {
		return noValResult;
	}

	public void setNoValResult(float noValResult) {
		this.noValResult = noValResult;
	}
}
