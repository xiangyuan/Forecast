package org.iblogger.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.iblogger.dao.UserDao;
import org.iblogger.dao.impl.UserDaoImpl;
import org.iblogger.exception.DaoException;
import org.iblogger.model.User;
/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 19, 2012 5:38:07 PM
 */
public class UserAction extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String action = req.getParameter("action");
		UserDao dao = new UserDaoImpl();
		if ("regist".equals(action)) {
			String username = req.getParameter("regstName");
			String password = req.getParameter("regstPwd");
			String email = req.getParameter("email");
			System.out.println(email + " " + username + " " + password);
			try {
				User user = new User();
				user.setUserEmail(email);
				user.setUserName(username);
				user.setPwd(password);
				user = dao.registUser(user);
				if (user != null) {
					req.getSession().setAttribute("user", user);
					resp.sendRedirect("productAction?action=all");
				}
			} catch (DaoException e) {
				e.printStackTrace();
				resp.sendRedirect("message.jsp");
			}
		} else if ("logout".equals(action)) {
			req.getSession().removeAttribute("user");
			resp.sendRedirect("login.jsp");
		} else {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			try {
				User user = dao.loginUser(username, password);
				if (user != null) {
					req.getSession().setAttribute("user", user);
					//到达主页
//					req.getRequestDispatcher("/productAction?action=all").forward(req, resp);
					resp.sendRedirect("productAction?action=all");
				} else {
					resp.sendRedirect("message.jsp");
//					req.getRequestDispatcher("/message.jsp").forward(req, resp);
				}
			} catch (DaoException e) {
				e.printStackTrace();
				resp.sendRedirect("message.jsp");
			}
		}
	}
}
