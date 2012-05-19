package org.iblogger.dao;

import java.util.List;

import org.iblogger.model.Product;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 19, 2012 12:59:12 PM
 */
public interface TaskAction extends Action {

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
	public Product queryProduct(int id);}
