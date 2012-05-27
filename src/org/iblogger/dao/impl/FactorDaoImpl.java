package org.iblogger.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.iblogger.dao.FactorDao;
import org.iblogger.model.FactorCharacter;
import org.iblogger.utils.Dbutils;

public class FactorDaoImpl implements FactorDao {

	@Override
	public List<FactorCharacter> queryProduct() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FactorCharacter> queryCompany() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FactorCharacter> queryPType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(int prdctId) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		boolean re = false;
		try {
			conn = Dbutils.getConn();
			String sql = "delete from Product where PrdctCode = ?";
			ptmt = Dbutils.getPtmt(conn, sql);

			ptmt.setInt(1, prdctId);

			int c = ptmt.executeUpdate();
			if (c > 0) {
				re = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (re);
	}

	@Override
	public boolean updateProduct(FactorCharacter p, int type) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		boolean re = false;
		try {
			conn = Dbutils.getConn();
			String sql = "";
			if (type == 1) {
				sql = "insert into FactorCharacter(PrdctTypeCode,IsQualitative,BestLowValue,BestUpValue"
						+ ", min,max,StandardizeWay) values (?,1,?,?,?,?,?);";
			} else if (type == 2) {
				sql = "update Product set";
			}

			ptmt = Dbutils.getPtmt(conn, sql);
			if (type == 1) {
				int index = 1;
				ptmt.setInt(index++, p.getPrdctCode());
				ptmt.setFloat(index++, p.getBaseMin());
				ptmt.setFloat(index++, p.getBaseMax());
				ptmt.setFloat(index++, p.getMinValue());
				ptmt.setFloat(index++, p.getMaxValue());
				ptmt.setFloat(
						index++,
						p.getPrdctCode() + p.getBaseMax() + p.getBaseMin()
								+ p.getMinValue() + p.getMaxValue());
			} else if (type == 2) {// 更新

			}
			int c = ptmt.executeUpdate();
			if (c > 0) {
				re = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (ptmt != null) {
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return (re);
	}

	@Override
	public FactorCharacter queryProduct(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
