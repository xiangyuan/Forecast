
<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
			
	//String currentUser = session.getAttribute("UserId").toString();
	
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>

		<title>Login Page</title>
	</head>

	<body>
		<%
			String info = request.getParameter("info");
			if (!("".equals(info) || info == null))
				out.println(info);
		%>
		<p>
			<a href="<%=basePath%>register/register.jsp">用户注册</a>|用户登录
		</p>
		<form action="login2.jsp" method="post">
			<table>
				<tr>
					<td style="text-align: right">
						用户名
					</td>
					<td>
						<input type="text" name="userName" />

					</td>
				</tr>
				<tr>
					<td style="text-align: right">
						密码
					</td>
					<td>
						<input type="text" name="password" />
					</td>
				</tr>
				<%-- <tr>
					<td style="text-align: right">
						验证码
					</td>
					<td>
						<input type="text" name="inputCertCode" cssStyle="width:100px" />
						<img id="certfCode"
							src="<%=basePath%>pagefunction/makeCertPic.jsp"
							style="width: 60px; height: 25px">
						<a href="" onclick="reloadcode();">看不清,换一张</a>
					</td>
				</tr> --%>
				<tr>
					<td style="text-align: left">
						<input type="submit" value="登录" />
					</td>
					<td style="text-align: left">
						<input type="reset" value="取消" />
					</td>
				</tr>
			</table>
		</form>
		<label id="errorInfo" style="color: red"></label>
	</body>

	<script language="JavaScript">
function reloadcode(){
var verify=document.getElementById("certfCode");
verify.setAttribute("src","<%=basePath%>pagefunction/makeCertPic.jsp");
		//这里必须加入随机数不然地址相同我发重新加载
	}
</script>
</html>
