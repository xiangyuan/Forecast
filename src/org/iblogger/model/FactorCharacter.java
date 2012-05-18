package org.iblogger.model;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 18, 2012 11:27:01 PM
 */
public class FactorCharacter {

	private int factorCode;

	private String factorUnit;

	private int isQuality;

	private int factorType;

	private float fixValue;
	/**
	 * 区间下限
	 */
	private float minValue;

	private float maxValue;

	private float baseMin;

	private float baseMax;
	/*
	 * 一致性方法
	 */
	private int standardWay;
	/**
	 * 无量化方法
	 */
	private int noValueWay;
	/**
	 * 所属产品的编号
	 */
	private int prdctCode;

	public int getFactorCode() {
		return factorCode;
	}

	public void setFactorCode(int factorCode) {
		this.factorCode = factorCode;
	}

	public String getFactorUnit() {
		return factorUnit;
	}

	public void setFactorUnit(String factorUnit) {
		this.factorUnit = factorUnit;
	}

	public int getIsQuality() {
		return isQuality;
	}

	public void setIsQuality(int isQuality) {
		this.isQuality = isQuality;
	}

	public int getFactorType() {
		return factorType;
	}

	public void setFactorType(int factorType) {
		this.factorType = factorType;
	}

	public float getFixValue() {
		return fixValue;
	}

	public void setFixValue(float fixValue) {
		this.fixValue = fixValue;
	}

	public float getMinValue() {
		return minValue;
	}

	public void setMinValue(float minValue) {
		this.minValue = minValue;
	}

	public float getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(float maxValue) {
		this.maxValue = maxValue;
	}

	public float getBaseMin() {
		return baseMin;
	}

	public void setBaseMin(float baseMin) {
		this.baseMin = baseMin;
	}

	public float getBaseMax() {
		return baseMax;
	}

	public void setBaseMax(float baseMax) {
		this.baseMax = baseMax;
	}

	public int getStandardWay() {
		return standardWay;
	}

	public void setStandardWay(int standardWay) {
		this.standardWay = standardWay;
	}

	public int getNoValueWay() {
		return noValueWay;
	}

	public void setNoValueWay(int noValueWay) {
		this.noValueWay = noValueWay;
	}

	public int getPrdctCode() {
		return prdctCode;
	}

	public void setPrdctCode(int prdctCode) {
		this.prdctCode = prdctCode;
	}
}
