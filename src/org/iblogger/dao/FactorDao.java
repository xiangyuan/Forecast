package org.iblogger.dao;

import java.util.List;

import org.iblogger.model.FactorCharacter;

/**
 * 
 * @title
 * 产品搜索页面信息
 * @author ForYY
 * @version 1.0 May 18, 2012 11:48:29 PM
 */
public interface FactorDao extends Dao{

	/**
	 * 
	 * @return
	 */
	public List<FactorCharacter> queryProduct();
	
	public List<FactorCharacter> queryCompany();
	
	public List<FactorCharacter> queryPType();
	/**
	 * 
	 * @param prdctId
	 * @return
	 */
	public boolean deleteProduct(int prdctId);
	/**
	 *  update the product information
	 * @param product
	 * @param type 1:插入 2: 更新
	 * @return
	 */
	public boolean updateProduct(FactorCharacter product,int type);
	
	/**
	 * 查看某一个产品
	 * @param id
	 * @return
	 */
	public FactorCharacter queryProduct(int id);
}
