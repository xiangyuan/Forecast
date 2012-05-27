package org.iblogger.action;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.iblogger.dao.EvaluateDao;
import org.iblogger.dao.impl.EvaluateDaoImpl;
import org.iblogger.model.User;

/**
 * 用来处理评价服务类
 * @author Kingiol
 * @date 2012-5-21
 */
public class EvaluateAction extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String method = req.getParameter("method");
		if(method.compareTo("ADD") == 0) {
			boolean falg = this.addEvaluate(req, resp);
			if(falg) {
				resp.sendRedirect("Show_evaluate.jsp");
			}
		}else if(method.compareTo("del") == 0) {
			int code = Integer.parseInt(req.getParameter("task_id"));
			EvaluateDao dao = new EvaluateDaoImpl();
			boolean flag = dao.delEvaluate(code);
			if(flag)resp.sendRedirect("Show_evaluate.jsp");
		}
		
	}
	
	/**
	 * 新建评论
	 * @param req
	 * @param resp
	 */
	private boolean addEvaluate(HttpServletRequest req, HttpServletResponse resp)  {
		HashMap<String, String> map = new HashMap<String, String>();
		String evaluateName = req.getParameter("evaluateName");
		String evaluateMSG = req.getParameter("evaluateMSG");
		String prdctType = req.getParameter("prdctType");
		String evalWeigthWay = req.getParameter("evalWeightWay");
		String composeWar = req.getParameter("composeWar");
		map.put("TASKNAME", evaluateName);
		map.put("TASKINFO", evaluateMSG);
		map.put("CEPRDCTTYPECODE", prdctType);
		map.put("CREATEWEIGHTWAY", evalWeigthWay);
		map.put("COMPOSEWAY", composeWar);
		HttpSession session = req.getSession();
		User user = (User) session.getAttribute("user");
		map.put("USERID", String.valueOf(user.getUserId()));
		EvaluateDao dao = new EvaluateDaoImpl();
		return dao.addEvaluate(map);
	}

}
