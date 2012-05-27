package org.iblogger.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.iblogger.dao.ProductDao;
import org.iblogger.model.Company;
import org.iblogger.model.Product;
import org.iblogger.model.ProductType;
import org.iblogger.utils.Dbutils;

/**
 * 
 * @title
 * @author ForYY
 * @version 1.0 May 20, 2012 7:21:33 PM
 */
public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> queryProduct() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<Product> datas = null;
		try {
			conn = Dbutils.getConn();
			String sql = " select p.PrdctCode,p.PrdctSequence,p.PrdctName,p.PrdctModel"
					+ ",p.PrdctPara,p.PrdctPicturePath,p.PrdctIntro,c.cpnName, "
					+ " pt.PrdctTypeName from Product p,Company c,ProductType pt where p.CpnCode = c.cid and p.PrdctKindCode = pt.PrdctTypeCode ;";
			ptmt = Dbutils.getPtmt(conn, sql);

			rs = ptmt.executeQuery();

			if (rs != null) {
				Product p = null;
				datas = new ArrayList<Product>();
				while (rs.next()) {
					p = new Product();
					p.setPrdctCode(rs.getInt("PrdctCode"));
					p.setPrdctSeq(rs.getInt("PrdctSequence"));
					p.setPrdctName(rs.getString("PrdctName"));
					p.setPrdctModel(rs.getString("PrdctModel"));
					p.setPrdctParam(rs.getString("PrdctPara"));
					p.setPrdctPath(rs.getString("PrdctPicturePath"));
					p.setPrdctIntro(rs.getString("PrdctIntro"));
					p.setCpnName(rs.getString("cpnName"));
					p.setPrdctTypeName(rs.getString("PrdctTypeName"));
					datas.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return (datas);
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
	public boolean updateProduct(Product p, int type) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		boolean re = false;
		try {
			conn = Dbutils.getConn();
			String sql = "";
			if (type == 1) {
				sql = "insert into Product(CpnCode,PrdctSequence,PrdctKindCode,PrdctName"
						+ ", PrdctModel,PrdctPara,PrdctPicturePath,PrdctIntro,SubmitTime) values (?,?,?,?,?,?,?,?,sysdate());";
			} else if (type == 2) {
				sql = "update Product set";
			}

			ptmt = Dbutils.getPtmt(conn, sql);
			if (type == 1) {
				int index = 1;
				ptmt.setInt(index++, p.getCpnCode());
				ptmt.setInt(index++, p.getPrdctSeq());
				ptmt.setInt(index++, p.getPrdctKindCode());
				ptmt.setString(index++, p.getPrdctName());
				ptmt.setString(index++, p.getPrdctModel());
				ptmt.setString(index++, p.getPrdctParam());
				ptmt.setString(index++, p.getPrdctPath());
				ptmt.setString(index++, p.getPrdctIntro());
			} else if (type == 2) {

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
	public Product queryProduct(int id) {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		Product p = null;
		try {
			conn = Dbutils.getConn();
			String sql = " select p.PrdctCode,p.PrdctSequence,p.PrdctName,p.PrdctModel"
					+ ",p.PrdctPara,p.PrdctPicturePath,p.PrdctIntro,c.cpnName, "
					+ " pt.PrdctTypeName from Product p,Company c,ProductType pt where p.CpnCode = c.cid and p.PrdctKindCode = pt.PrdctTypeCode and p.PrdctCode = ? ";
			ptmt = Dbutils.getPtmt(conn, sql);

			ptmt.setInt(1, id);
			rs = ptmt.executeQuery();

			if (rs != null) {
				while (rs.next()) {
					p = new Product();
					p.setPrdctCode(rs.getInt("PrdctCode"));
					p.setPrdctSeq(rs.getInt("PrdctSequence"));
					p.setPrdctName(rs.getString("PrdctName"));
					p.setPrdctModel(rs.getString("PrdctModel"));
					p.setPrdctParam(rs.getString("PrdctPara"));
					p.setPrdctPath(rs.getString("PrdctPicturePath"));
					p.setPrdctIntro(rs.getString("PrdctIntro"));
					p.setCpnName(rs.getString("cpnName"));
					p.setPrdctTypeName(rs.getString("PrdctTypeName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return (p);
	}

	@Override
	public List<Company> queryCompany() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<Company> datas = null;
		try {
			conn = Dbutils.getConn();
			String sql = "select * from Company";
			ptmt = Dbutils.getPtmt(conn, sql);

			rs = ptmt.executeQuery();

			if (rs != null) {
				Company p = null;
				datas = new ArrayList<Company>();
				while (rs.next()) {
					p = new Company();
					p.setId(rs.getInt(1));
					p.setcName(rs.getString(2));
					datas.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return (datas);
	}

	@Override
	public List<ProductType> queryPType() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<ProductType> datas = null;
		try {
			conn = Dbutils.getConn();
			String sql = "select * from ProductType;";
			ptmt = Dbutils.getPtmt(conn, sql);

			rs = ptmt.executeQuery();

			if (rs != null) {
				ProductType p = null;
				datas = new ArrayList<ProductType>();
				while (rs.next()) {
					p = new ProductType();
					p.setPrdctCode(rs.getInt(1));
					p.setPrdctName(rs.getString(2));
					datas.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return (datas);
	}

	@Override
	public List<Product> getResultProduct() {
		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;
		List<Product> datas = null;
		try {
			conn = Dbutils.getConn();
			String sql = "select * from (select p.PrdctCode,p.PrdctSequence,p.PrdctName,p.PrdctPara,p.PrdctPicturePath,p.PrdctModel,p.PrdctIntro,c.cpnName,pt.PrdctTypeName from Product p,Company c,ProductType pt where p.CpnCode = c.cid and p.PrdctKindCode = pt.PrdctTypeCode) t,FactorCharacter fc where PrdctCode = fc.PrdctTypeCode order by StandardizeWay desc";
			ptmt = Dbutils.getPtmt(conn, sql);

			rs = ptmt.executeQuery();

			if (rs != null) {
				Product p = null;
				datas = new ArrayList<Product>();
				while (rs.next()) {
					p = new Product();
					p.setPrdctCode(rs.getInt("PrdctCode"));
					p.setPrdctSeq(rs.getInt("PrdctSequence"));
					p.setPrdctName(rs.getString("PrdctName"));
					p.setPrdctModel(rs.getString("PrdctModel"));
					p.setPrdctParam(rs.getString("PrdctPara"));
					p.setPrdctPath(rs.getString("PrdctPicturePath"));
					p.setPrdctIntro(rs.getString("PrdctIntro"));
					p.setCpnName(rs.getString("cpnName"));
					p.setPrdctTypeName(rs.getString("PrdctTypeName"));
					p.setStarCore(String.valueOf(rs.getFloat("StandardizeWay")));
					datas.add(p);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			// throw new DaoException("查找用户出现异常");
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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
		return (datas);
	}
}
