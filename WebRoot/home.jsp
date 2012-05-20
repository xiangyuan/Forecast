<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import="org.iblogger.model.*"%>
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
<title>系统主页</title>
<link rel="stylesheet" href="css/screen.css" type="text/css"
	media="screen" title="default" />
<!--[if IE]>
<link rel="stylesheet" media="all" type="text/css" href="css/pro_dropline_ie.css" />
<![endif]-->

<!--  jquery core -->
<script src="js/jquery/jquery-1.4.1.min.js" type="text/javascript"></script>

<!--  checkbox styling script -->
<script src="js/jquery/ui.core.js" type="text/javascript"></script>
<script src="js/jquery/ui.checkbox.js" type="text/javascript"></script>
<script src="js/jquery/jquery.bind.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('input').checkBox();
		$('#toggle-all').click(function() {
			$('#toggle-all').toggleClass('toggle-checked');
			$('#mainform input[type=checkbox]').checkBox('toggle');
			return false;
		});
	});
</script>

<![if !IE 7]>

<!--  styled select box script version 1 -->
<script src="js/jquery/jquery.selectbox-0.5.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect').selectbox({
			inputClass : "selectbox_styled"
		});
	});
</script>


<![endif]>

<!--  styled select box script version 2 -->
<script src="js/jquery/jquery.selectbox-0.5_style_2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect_form_1').selectbox({
			inputClass : "styledselect_form_1"
		});
		$('.styledselect_form_2').selectbox({
			inputClass : "styledselect_form_2"
		});
	});
</script>

<!--  styled select box script version 3 -->
<script src="js/jquery/jquery.selectbox-0.5_style_2.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$('.styledselect_pages').selectbox({
			inputClass : "styledselect_pages"
		});
	});
</script>

<!--  styled file upload script -->
<script src="js/jquery/jquery.filestyle.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {
		$("input.file_1").filestyle({
			image : "images/forms/choose-file.gif",
			imageheight : 21,
			imagewidth : 78,
			width : 310
		});
	});
</script>

<!-- Custom jquery scripts -->
<script src="js/jquery/custom_jquery.js" type="text/javascript"></script>

<!-- Tooltips -->
<script src="js/jquery/jquery.tooltip.js" type="text/javascript"></script>
<script src="js/jquery/jquery.dimensions.js" type="text/javascript"></script>
<script type="text/javascript">
	$(function() {
		$('a.info-tooltip ').tooltip({
			track : true,
			delay : 0,
			fixPNG : true,
			showURL : false,
			showBody : " - ",
			top : -35,
			left : 5
		});
	});
</script>


<!--  date picker script -->
<link rel="stylesheet" href="css/datePicker.css" type="text/css" />
<script src="js/jquery/date.js" type="text/javascript"></script>
<script src="js/jquery/jquery.datePicker.js" type="text/javascript"></script>
<script type="text/javascript" charset="utf-8">
	$(function() {

		// initialise the "Select date" link
		$('#date-pick').datePicker(
		// associate the link with a date picker
		{
			createButton : false,
			startDate : '01/01/2005',
			endDate : '31/12/2020'
		}).bind(
		// when the link is clicked display the date picker
		'click', function() {
			updateSelects($(this).dpGetSelected()[0]);
			$(this).dpDisplay();
			return false;
		}).bind(
		// when a date is selected update the SELECTs
		'dateSelected', function(e, selectedDate, $td, state) {
			updateSelects(selectedDate);
		}).bind('dpClosed', function(e, selected) {
			updateSelects(selected[0]);
		});

		var updateSelects = function(selectedDate) {
			var selectedDate = new Date(selectedDate);
			$('#d option[value=' + selectedDate.getDate() + ']').attr(
					'selected', 'selected');
			$('#m option[value=' + (selectedDate.getMonth() + 1) + ']').attr(
					'selected', 'selected');
			$('#y option[value=' + (selectedDate.getFullYear()) + ']').attr(
					'selected', 'selected');
		}
		// listen for when the selects are changed and update the picker
		$('#d, #m, #y').bind('change', function() {
			var d = new Date($('#y').val(), $('#m').val() - 1, $('#d').val());
			$('#date-pick').dpSetSelected(d.asString());
		});

		// default the position of the selects to today
		var today = new Date();
		updateSelects(today.getTime());

		// and update the datePicker to reflect it...
		$('#d').trigger('change');
	});
</script>

<!-- MUST BE THE LAST SCRIPT IN <HEAD></HEAD></HEAD> png fix -->
<script src="js/jquery/jquery.pngFix.pack.js" type="text/javascript"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$(document).pngFix();
	});
</script>
</head>
<body>
	<!-- Start: page-top-outer -->
	<div id="page-top-outer">

		<!-- Start: page-top -->
		<div id="page-top">

			<!-- start logo -->
			<div id="logo">
				<a href=""><img src="images/shared/logo.png" width="156"
					height="40" alt="" /> </a>
			</div>
			<!-- end logo -->

			<!--  start top-search -->
			<!-- <div id="top-search">
		<table border="0" cellpadding="0" cellspacing="0">
		<tr>
		<td><input type="text" value="Search" onblur="if (this.value=='') { this.value='Search'; }" onfocus="if (this.value=='Search') { this.value=''; }" class="top-search-inp" /></td>
		<td>
		<select  class="styledselect">
			<option value=""> All</option>
			<option value=""> Products</option>
			<option value=""> Categories</option>
			<option value="">Clients</option>
			<option value="">News</option>
		</select> 
		</td>
		<td>
		<input type="image" src="images/shared/top_search_btn.gif"  />
		</td>
		</tr>
		</table>
	</div> -->
			<!--  end top-search -->
			<div class="clear"></div>

		</div>
		<!-- End: page-top -->

	</div>
	<!-- End: page-top-outer -->

	<div class="clear">&nbsp;</div>

	<!--  start nav-outer-repeat................................................................................................. START -->
	<div class="nav-outer-repeat">
		<!--  start nav-outer -->
		<div class="nav-outer">

			<!-- start nav-right -->
			<div id="nav-right">

				<div class="nav-divider">&nbsp;</div>
				<a href="" id="logout"><img
					src="images/shared/nav/nav_logout.gif" width="64" height="14"
					alt="" /> </a>
				<div class="clear">&nbsp;</div>

				<!--  start account-content -->
				<div class="account-content">
					<div class="account-drop-inner">
						<a href="" id="acc-settings">Settings</a>
						<div class="clear">&nbsp;</div>
						<div class="acc-line">&nbsp;</div>
						<a href="" id="acc-details">Personal details </a>
						<div class="clear">&nbsp;</div>
						<div class="acc-line">&nbsp;</div>
						<a href="" id="acc-project">Project details</a>
						<div class="clear">&nbsp;</div>
						<div class="acc-line">&nbsp;</div>
						<a href="" id="acc-inbox">Inbox</a>
						<div class="clear">&nbsp;</div>
						<div class="acc-line">&nbsp;</div>
						<a href="" id="acc-stats">Statistics</a>
					</div>
				</div>
				<!--  end account-content -->

			</div>
			<!-- end nav-right -->


			<!--  start nav -->
			<div class="nav">
				<div class="table">

					<!-- 
		<ul class="select"><li><a href="#nogo"><b>Dashboard</b>[if IE 7]><!</a><![endif]
		[if lte IE 6]><table><tr><td><![endif]
		<div class="select_sub">
			<ul class="sub">
				<li><a href="#nogo">Dashboard Details 1</a></li>
				<li><a href="#nogo">Dashboard Details 2</a></li>
				<li><a href="#nogo">Dashboard Details 3</a></li>
			</ul>
		</div> -->
					<!-- <!--[if lte IE 6]></td></tr></table></a><![endif]-->

					<!-- </li>
				<div class="nav-divider">&nbsp;</div>
		</ul>
		-->

					<ul class="current">
						<li><a href="#nogo"><b>产品</b> <!--[if IE 7]><!--> </a> <!--<![endif]-->
							<!--[if lte IE 6]><table><tr><td><![endif]-->
							<div class="select_sub show">
								<ul class="sub">
									<li class="sub_show"><a href="#nogo">查看所有产品</a></li>
									<li><a href="<%=basePath%>postproduct.jsp">添加产品</a></li>
								</ul>
							</div> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
						</li>
					</ul>

					<div class="nav-divider">&nbsp;</div>

					<ul class="select">
						<li><a href="#nogo"><b>评价任务</b> <!--[if IE 7]><!--> </a> <!--<![endif]-->
							<!--[if lte IE 6]><table><tr><td><![endif]-->
							<div class="select_sub">
								<ul class="sub">
									<li><a href="#nogo">评价任务</a></li>
									<li><a href="#nogo">创建评价任务</a></li>
									<li><a href="#nogo">删除评价任务</a></li>
								</ul>
							</div> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
						</li>
					</ul>

					<div class="nav-divider">&nbsp;</div>

					<ul class="select">
						<li><a href="#nogo"><b>综合评测</b> <!--[if IE 7]><!--> </a> <!--<![endif]-->
							<!--[if lte IE 6]><table><tr><td><![endif]-->
							<div class="select_sub">
								<ul class="sub">
									<li><a href="#nogo">Clients Details 1</a></li>
									<li><a href="#nogo">Clients Details 2</a></li>
									<li><a href="#nogo">Clients Details 3</a></li>

								</ul>
							</div> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
						</li>
					</ul>

					<div class="nav-divider">&nbsp;</div>

					<ul class="select">
						<li><a href="#nogo"><b>报告<b> <!--[if IE 7]><!-->
						</a> <!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
							<div class="select_sub">
								<ul class="sub">
									<li><a href="#nogo">News details 1</a></li>
									<li><a href="#nogo">News details 2</a></li>
									<li><a href="#nogo">News details 3</a></li>
								</ul>
							</div> <!--[if lte IE 6]></td></tr></table></a><![endif]-->
						</li>
					</ul>
					<div class="nav-divider">&nbsp;</div>
					<%
						User user = (User) request.getSession().getAttribute("user");
						String t = user == null ? "" : user.getUserName();
					%>
					<ul class="select">
						<li><a href="#nogo"><b>用户:<%=t%><b> <!--[if IE 7]><!-->
						</a> <!--<![endif]--> <!--[if lte IE 6]><table><tr><td><![endif]-->
						</li>
					</ul>

					<div class="clear"></div>
				</div>
				<div class="clear"></div>
			</div>
			<!--  start nav -->

		</div>
		<div class="clear"></div>
		<!--  start nav-outer -->
	</div>
	<!--  start nav-outer-repeat................................................... END -->

	<div class="clear"></div>

	<!-- start content-outer ........................................................................................................................START -->
	<div id="content-outer">
		<!-- start content -->
		<div id="content">

			<!--  start page-heading -->
			<div id="page-heading">
				<h1>所有产品</h1>
			</div>
			<!-- end page-heading -->

			<table border="0" width="100%" cellpadding="0" cellspacing="0"
				id="content-table">
				<tr>
					<th rowspan="3" class="sized"><img
						src="images/shared/side_shadowleft.jpg" width="20" height="300"
						alt="" /></th>
					<th class="topleft"></th>
					<td id="tbl-border-top">&nbsp;</td>
					<th class="topright"></th>
					<th rowspan="3" class="sized"><img
						src="images/shared/side_shadowright.jpg" width="20" height="300"
						alt="" /></th>
				</tr>
				<tr>
					<td id="tbl-border-left"></td>
					<td>
						<!--  start content-table-inner ...................................................................... START -->
						<div id="content-table-inner">

							<!--  start table-content  -->
							<div id="table-content">

								<!--  start product-table ..................................................................................... -->
								<form id="mainform" action="">
									<table border="0" width="100%" cellpadding="0" cellspacing="0"
										id="product-table">
										<tr>
											<%--<th class="table-header-check"><a id="toggle-all"></a>
											</th>
											--%>
											<th class="table-header-repeat line-left minwidth-1"><a
												href="">Last Name</a>
											</th>
											<th class="table-header-repeat line-left minwidth-1"><a
												href="">First Name</a></th>
											<th class="table-header-repeat line-left"><a href="">Email</a>
											</th>
											<th class="table-header-repeat line-left"><a href="">Due</a>
											</th>
											<th class="table-header-repeat line-left"><a href="">Website</a>
											</th>
											<th class="table-header-options line-left"><a href="">Options</a>
											</th>
										</tr>
										<%
											List<Product> datas = (List<Product>) request.getAttribute("datas");
											if (datas == null || datas.size() == 0) {
										%>
										<tr>
											<td>没有产品信息</td>
										</tr>
										<%
											} else {
												int i = 0;
												for (Product p : datas) {

													if (i % 2 != 0) {
										%>
										<tr>
											<td>Sabev</td>
											<td>George</td>
											<td><a href="">george@mainevent.co.za</a></td>
											<td>R250</td>
											<td><a href="">www.mainevent.co.za</a></td>
											<td class="options-width"><a href="" title="Edit"
												class="icon-1 info-tooltip"></a> <a href="" title="Edit"
												class="icon-2 info-tooltip"></a> <a href="" title="Edit"
												class="icon-3 info-tooltip"></a> <a href="" title="Edit"
												class="icon-4 info-tooltip"></a> <a href="" title="Edit"
												class="icon-5 info-tooltip"></a>
											</td>
										</tr>
										<%
											} else {
										%>
										<tr class="alternate-row">
											<td>Sabev</td>
											<td>George</td>
											<td><a href="">george@mainevent.co.za</a></td>
											<td>R250</td>
											<td><a href="">www.mainevent.co.za</a></td>
											<td class="options-width"><a href="" title="Edit"
												class="icon-1 info-tooltip"></a> <a href="" title="Edit"
												class="icon-2 info-tooltip"></a> <a href="" title="Edit"
												class="icon-3 info-tooltip"></a> <a href="" title="Edit"
												class="icon-4 info-tooltip"></a> <a href="" title="Edit"
												class="icon-5 info-tooltip"></a>
											</td>
										</tr>
										<%
											}
													i += 2;
												}
											}
										%>
									</table>
									<!--  end product-table................................... -->
								</form>
							</div>
							<!--  end content-table  -->

							<!--  start actions-box ............................................... -->
							<%--<div id="actions-box">
								<a href="" class="action-slider"></a>
								<div id="actions-box-slider">
									<a href="" class="action-edit">Edit</a> <a href=""
										class="action-delete">Delete</a>
								</div>
								<div class="clear"></div>
							</div>
							--%>
							<!-- end actions-box........... -->

							<!--  start paging..................................................... -->
							<table border="0" cellpadding="0" cellspacing="0"
								id="paging-table">
								<tr>
									<td><a href="" class="page-far-left"></a> <a href=""
										class="page-left"></a>
										<div id="page-info">
											Page <strong>1</strong> / 15
										</div> <a href="" class="page-right"></a> <a href=""
										class="page-far-right"></a>
									</td>
									<td><select class="styledselect_pages">
											<option value="">Number of rows</option>
											<option value="">1</option>
											<option value="">2</option>
											<option value="">3</option>
									</select>
									</td>
								</tr>
							</table>
							<!--  end paging................ -->

							<div class="clear"></div>

						</div> <!--  end content-table-inner ............................................END  -->
					</td>
					<td id="tbl-border-right"></td>
				</tr>
				<tr>
					<th class="sized bottomleft"></th>
					<td id="tbl-border-bottom">&nbsp;</td>
					<th class="sized bottomright"></th>
				</tr>
			</table>
			<div class="clear">&nbsp;</div>

		</div>
		<!--  end content -->
		<div class="clear">&nbsp;</div>
	</div>
	<!--  end content-outer........................................................END -->

	<div class="clear">&nbsp;</div>

	<!-- start footer -->
	<div id="footer">
		<!--  start footer-left -->
		<div id="footer-left">

			Love &copy; For YY. <span id="spanYear"></span> <a href="#">System</a>.
			版权保护.
		</div>
		<!--  end footer-left -->
		<div class="clear">&nbsp;</div>
	</div>
	<!-- end footer -->

</body>
</html>