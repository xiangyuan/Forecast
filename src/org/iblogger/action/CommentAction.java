package org.iblogger.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iblogger.dao.FactorDao;
import org.iblogger.dao.ProductDao;
import org.iblogger.dao.impl.FactorDaoImpl;
import org.iblogger.dao.impl.ProductDaoImpl;
import org.iblogger.model.FactorCharacter;
import org.iblogger.model.Product;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 27, 2012 8:25:18 PM
 */
public class CommentAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5818500857408290130L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String action = req.getParameter("action");
		if (action == null) {
			ProductDao dao = new ProductDaoImpl();
			List<Product> datas = dao.queryProduct();
			if (datas == null || datas.size() <= 0) {
				resp.sendRedirect("commenterror.jsp");
			} else {
				req.setAttribute("datas", datas);
				req.getRequestDispatcher("/comments.jsp").forward(req, resp);
			}
		} else if ("all".equals(action)) {
			ProductDao dao = new ProductDaoImpl();
			List<Product> datas = dao.getResultProduct();
			req.setAttribute("datas", datas);
			req.getRequestDispatcher("/report.jsp").forward(req, resp);
			
		} else if ("add".equals(action)) {
			int pid = Integer.parseInt(req.getParameter("prdctId"));
			float funNo = Float.parseFloat(req.getParameter("functionNum"));
			float uiNum = Float.parseFloat(req.getParameter("uiNum"));
			float mmNo = Float.parseFloat(req.getParameter("memoryNum"));
			float ueNo = Float.parseFloat(req.getParameter("ueNum"));
			FactorCharacter factor = new FactorCharacter();
			factor.setPrdctCode(pid);
			factor.setBaseMin(funNo);
			factor.setBaseMax(uiNum);
			factor.setMinValue(mmNo);
			factor.setMaxValue(ueNo);
			FactorDao dao = new FactorDaoImpl();
			boolean isOk = dao.updateProduct(factor, 1);
			if (isOk) {
				resp.sendRedirect("commentAction?action=all");
			} else {
				resp.getWriter().write("添加综全评价异常");
			}
		}
	}
}
