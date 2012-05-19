package org.iblogger.dao;

import java.util.List;

import org.iblogger.model.Product;

/**
 * 
 * @title
 * 产品搜索页面信息
 * @author ForYY
 * @version 1.0 May 18, 2012 11:48:29 PM
 */
public interface ProductAction extends Action{

	/**
	 * 
	 * @return
	 */
	public List<Product> queryProduct();
	/**
	 * 
	 * @param prdctId
	 * @return
	 */
	public boolean deleteProduct(int prdctId);
	/**
	 *  update the product information
	 * @param product
	 * @return
	 */
	public boolean updateProduct(Product product);
	
	/**
	 * 查看某一个产品
	 * @param id
	 * @return
	 */
	public Product queryProduct(int id);
}
