package org.iblogger.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iblogger.dao.ProductDao;
import org.iblogger.dao.impl.ProductDaoImpl;
import org.iblogger.model.Product;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 20, 2012 8:07:23 PM
 */
public class ProductAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		ProductDao dao = null;
		if (!"".equals(action)) {
			dao = new ProductDaoImpl();
			if ("all".equals(action)) {
				List<Product> datas = dao.queryProduct();
				req.setAttribute("datas", datas);
				req.getRequestDispatcher("/home.jsp").forward(req, resp);
			} else if ("delete".equals(action)) {
				
			} else if ("modify".equals(action)) {
				
			} else if ("get".equals(action)) {
				
			} else if ("add".equals(action)) {
				//查找出company,产品类别信息
			}
		}
	}

}
