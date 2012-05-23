package org.iblogger.dao;

import java.util.HashMap;

/**
 *  处理评价的接口类
 * @author Kingiol
 * @date 2012-5-21
 */
public interface EvaluateDao extends Dao {

	public boolean addEvaluate(HashMap<String, String> map);
	
	public boolean delEvaluate(int evaluateId);
	
	public boolean editEvaluate(HashMap<String, String> map);
	
}
