package org.iblogger.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;

import org.iblogger.dao.EvaluateDao;
import org.iblogger.utils.Dbutils;

/**
 * 评价处理实现类-Model
 * @author Kingiol
 * @date 2012-5-21
 */
public class EvaluateDaoImpl implements EvaluateDao {

	
	@Override
	public boolean addEvaluate(HashMap<String, String> map) {
		StringBuffer sb = new StringBuffer("INSERT INTO TASK(TASKNAME, TASKINTRO, CEPRDCTTYPECODE, CREATEWEIGHTWAY, COMPOSEWAY, CREATEDATE,USERID) ");
		sb.append(" VALUES ('").append(map.get("TASKNAME")).append("','").append(map.get("TASKINFO")).append("',")
		.append(map.get("CEPRDCTTYPECODE")).append(",").append(map.get("CREATEWEIGHTWAY")).append(",")
		.append(map.get("COMPOSEWAY")).append(",").append("now(),").append(map.get("USERID")).append(")");
		
		Connection conn;
		PreparedStatement ps;
		try {
			conn = Dbutils.getConn();
			ps = conn.prepareStatement(sb.toString());
			int result = ps.executeUpdate();
			if(result > 0) {
				return true; 
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ps = null;
			conn = null;
		}
		
		return false;
	}

	@Override
	public boolean delEvaluate(int evaluateId) {
		Connection conn;
		PreparedStatement ps;
		try {
			conn = Dbutils.getConn();
			ps = conn.prepareStatement("delete from task where taskcode = ?");
			ps.setInt(1, evaluateId);
			ps.executeUpdate();
			return true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			ps = null;
			conn = null;
		}
		return false;
	}

	@Override
	public boolean editEvaluate(HashMap<String, String> map) {
		return false;
	}

}
