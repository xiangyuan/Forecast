<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%><%@page import="java.sql.Connection"%><%@page import="org.iblogger.utils.Dbutils"%><%@page import="java.sql.PreparedStatement"%><%@page import="java.sql.ResultSet"%><%@page import="org.iblogger.model.User"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	User user = (User)request.getSession().getAttribute("user");
	int userid = user.getUserId();
	System.out.println(userid);
	Connection conn = Dbutils.getConn();
	String sql = "select taskcode, taskname, taskintro, ceprdcttypecode, (select prdcttypename from producttype where prdcttypecode = ceprdcttypecode) as prdctname," 
	+ "case createweightway when 1 then 'AHP法' when 2 then 'DELPHI法' when 3 then '直接赋权法' when 4 then '逐对比较法' end as weightway,"
	+ "case composeway when 1 then '加权线性和法' when 2 then '理想点法' when 3 then '乘积合成法' when 4 then '模糊综合评价方法' end as composewayname,"
	+ "createdate,userid from task where userid = ?";
	PreparedStatement ps = conn.prepareStatement(sql);
	ps.setInt(1, userid);
	ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
  </head>
  
  <body>
  	<table>
  		<tr>
  			<th>名称</th>
  			<th>描述</th>
  			<th>评价产品类型</th>
  			<th>权重构造方法</th>
  			<th>综合评价方法</th>
  			<th>评价时间</th>
  			<th>操作</th>
  		</tr>
  		<%
  			while(rs.next()) {
  		%>
  			<tr>
  				<td><%=rs.getString(2) %></td>
  				<td><%=rs.getString(3) %></td>
  				<td><%=rs.getString(5) %></td>
  				<td><%=rs.getString(6) %></td>
  				<td><%=rs.getString(7) %></td>
  				<td><%=rs.getDate(8)  %></td>
  				<td><form action="addEvaluate" name='delform' id='delform' method='get'><input type="hidden" name="method" value="del"/><input type="hidden" name="task_id" value="<%=rs.getInt(1) %>"/><input type="submit" value="删除"/></form></td>
  			</tr>
  		<%
  			}
  		%>
  	</table>
  </body>
</html>

<%
rs = null;
ps = null;
rs = null;
%>