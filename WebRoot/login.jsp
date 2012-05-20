<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";

	//String currentUser = session.getAttribute("UserId").toString();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>登录</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/screen.css" type="text/css"
	media="screen" title="default" />
<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>

<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>

<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(document).pngFix();
	});

	function userLogin() {
		var uername = document.getElementById("username").value;
		var password = document.getElementById("password").value;
		if (uername == '') {
			alert("please enter UserName ");
			return;
		}
		if (password == '') {
			alert("please enter the password");
			return;
		}
		document.myForm.submit();

	}
	
	function userRegist() {
		var email = document.getElementById("email").value;
		var uername = document.getElementById("regstName").value;
		var password = document.getElementById("regstPwd").value;
		if (email == '') {
			alert("please enter Email address ");
			return;
		}
		if (uername == '') {
			alert("please enter UserName ");
			return;
		}
		if (password == '') {
			alert("please enter the password");
			return;
		}
		document.myRegistForm.submit();
	}
</script>
</head>
<body id="login-bg">

	<!-- Start: login-holder -->
	<div id="login-holder">

		<!-- start logo -->
		<div id="logo-login">
			<a href="index.html"><img src="images/shared/logo.png"
				width="156" height="40" alt="" /> </a>
		</div>
		<!-- end logo -->

		<div class="clear"></div>

		<!--  start loginbox ................................................................................. -->
		<div id="loginbox">

			<!--  start login-inner -->
			<div id="login-inner">
				<form name="myForm" action="userAction" method="post">
					<table border="0" cellpadding="0" cellspacing="0">
						<tr>
							<th>用户名</th>
							<td><input type="text" name="username" id="username"
								value="请输入用户名" onfocus="this.value=''" class="login-inp" /></td>
						</tr>
						<tr>
							<th>密 码</th>
							<td><input type="password" name="password" id="password"
								class="login-inp" /></td>
						</tr>
						<!-- <tr>
						<th></th>
						<td valign="top"><input type="checkbox" class="checkbox-size"
							id="login-check" /><label for="login-check">Remember me</label>
						</td>
					</tr>
					
 -->
						<tr></tr>
						<tr>
							<th></th>
							<td><input type="button" class="submit-login"
								onclick="javascript:userLogin();" /></td>
						</tr>
					</table>
				</form>
			</div>
			<!--  end login-inner -->
			<div class="clear"></div>
			<a href="" class="forgot-pwd">注册</a>
		</div>
		<!--  end loginbox -->

		<!--  start forgotbox ................................................................................... -->
		<div id="forgotbox">
			<!--  start forgot-inner -->
			<div id="forgot-inner">
			<form name="myRegistForm" action="userAction?action=regist" method="post">
				<table border="0" cellpadding="0" cellspacing="0">
					<tr>
						<th>邮  箱</th>
						<td><input type="text" id="email" name="email" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th>用户名</th>
						<td><input type="text" id="regstName" name="regstName" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th>密  码</th>
						<td><input type="password" id="regstPwd" name="regstPwd" value="" class="login-inp" /></td>
					</tr>
					<tr>
						<th></th>
						<td><input type="button" class="submit-login" onclick="javascrip:userRegist();"/></td>
					</tr>
				</table>
				</form>
			</div>
			<!--  end forgot-inner -->
			<div class="clear"></div>
			<a href="" class="back-login">Back to login</a>
		</div>
		<!--  end forgotbox -->

	</div>
	<!-- End: login-holder -->
</body>
</html>