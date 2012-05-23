<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>
<%@ page language="java" import="org.iblogger.utils.Dbutils"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<%
	//取得产品类型
	Connection conn = Dbutils.getConn();
	PreparedStatement ps = conn.prepareStatement("SELECT PRDCTTYPECODE, PRDCTTYPENAME FROM PRODUCTTYPE");
	ResultSet rs = ps.executeQuery();
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>新建评价</title>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <script type="text/javascript">
  	function eval_submit() {
  		var evaluateName = document.getElementById("evaluateName").value;
  		if(evaluateName.length <= 0) {
  			alert("评价任务名称不能为空.");
  			return false;
  		}
  		
  		var evaluateMSG = document.getElementById("evaluateMSG").value;
  		if(evaluateMSG.length <= 0) {
  			alert("描述信息不能为空.");
  			return false;
  		}
  		document.addEvaluate.submit();
  	}
  </script>
  
  <body>
    <form action="addEvaluate" id="addEvaluate" name="addEvaluate" method="post">
    	<input type="hidden" name="method" value="ADD"/>
    	评价任务名称:<input id="evaluateName" type="text" class="text" size="30" name="evaluateName"/><br/>
    	描述信息:<input id="evaluateMSG" type="text" class="text" size="30" name="evaluateMSG"/><br/>
    	评价产品类型:<select name="prdctType">
    		<%
    			while(rs.next()) {
    		%>
    		<option value="<%=rs.getString(1) %>"><%=rs.getString(2) %></option>
    		<%
    			}
    		%>
    	</select>
 		<br/>
 		权重够着方法:
 		<select name="evalWeightWay">
 			<option value="1">AHP法</option>
 			<option value="2">DELPHI法</option>
 			<option value="3">直接赋权法</option>
 			<option value="4">逐对比较法</option>
 		</select>
 		<br/>
 		综合评价方法:
 		<select name="composeWar">
 			<option value="1">加权线性和法</option>
 			<option value="2">理想点法</option>
 			<option value="3">乘积合成法</option>
 			<option value="4">模糊综合评价方法</option>
 		</select>
 		<br/>
 		<input type="button" value="提交信息" onclick="eval_submit();"/>
 		<input type="reset" value="重置"/>
    </form>
  </body>
</html>

<%
	rs = null;
	ps = null;
	conn = null;
%>