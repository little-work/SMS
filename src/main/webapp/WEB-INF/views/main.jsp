<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title> 主页</title>

 <jsp:include page="./JSPinclude/common.jsp"></jsp:include>
 
<link href="/wms/resources/css/main/main.css" rel="stylesheet" type="text/css" />
<link href="/wms/resources/css/main/sidebar-menu.css" rel="stylesheet" type="text/css" />

</head>
<body>

	<div class="slideTxtBox">
		 <div class="who">
			欢迎,<%= session.getAttribute("username") %>&nbsp;&nbsp;<i class="fa fa-caret-right fa-lg"></i>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div class="option">
			<ul>
				<li><span>&nbsp;&nbsp;<i class="fa fa-gear"></i>&nbsp;&nbsp;修改密码</span></li>
				<li><span class="exit">&nbsp;&nbsp;<i class="fa fa-close"></i>&nbsp;&nbsp;退出登录</span></li>
			</ul>
		</div>
	</div>
	<!-- 水平导航 -->
	   <div id="header_nav">
	   <div class="touxiang"><img src="/wms/resources/images/user.png" />  </div>
		<!-- <div class="nav_font_left">未来星<i class="fa fa-star"></i>辅导班</div> -->
	</div>
	
	<!-- 主要内容区域 -->
	<div id="main_container">
	 <div id="vertical_nav" tabindex="5000">
				<aside class="main-sidebar">
				<section class="sidebar">
					<ul class="sidebar-menu">
					  <li class="header">主导航</li>
					  <li class="treeview">
						<a href="#"> 
						  <i class="fa fa-user-circle-o "></i> <span>学生管理</span> <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li class="left_nav_enterschool"><a href="#"><i class="fa fa-circle-o"></i>学生入学</a></li>
						   <li class="left_nav_role"><a href="#"><i class="fa fa-circle-o"></i>在校学生</a></li>
						  <li class="left_nav_role"><a href="#"><i class="fa fa-circle-o"></i>学生退学</a></li>
						</ul>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-book"></i>
						  <span>课程管理</span>
						  <!-- <span class="label label-primary pull-right">4</span> -->
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu" style="display: none;">
						  <li class="left_nav_stock"><a href="#"><i class="fa fa-circle-o"></i>小学辅导</a></li>
						  <li class="left_nav_supplier"><a href="#"><i class="fa fa-circle-o"></i>供应商管理</a></li>
						  <li class="left_nav_openCourse"><a href="#"><i class="fa fa-circle-o"></i>开设课程</a></li>
						  <li class=""><a href="#"><i class="fa fa-circle-o"></i>课程表</a>
						  </li>
						</ul>
					  </li>
					  <li>
						<a href="#">
						  <i class="fa fa-th"></i> <span>窗口小部件</span>
						  <!-- <small class="label pull-right label-info">新的</small> -->
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-pie-chart"></i>
						  <span>图表</span>
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li><a href="#"><i class="fa fa-circle-o"></i> ChartJS</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> Morris</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> Flot</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> Inline charts</a></li>
						</ul>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-laptop"></i>
						  <span>UI 元素</span>
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li><a href="#"><i class="fa fa-circle-o"></i> 一般</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> Icons图标</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 按钮</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 滑块</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 时间表</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 模态框</a></li>
						</ul>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-edit"></i> <span>表单</span>
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li><a href="#"><i class="fa fa-circle-o"></i> 一般表单</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 高级表单</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 可编辑表单</a></li>
						</ul>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-table"></i> <span>表格</span>
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li><a href="#"><i class="fa fa-circle-o"></i> 简单表格</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 时间表格</a></li>
						</ul>
					  </li>
					  <li>
						<a href="#">
						  <i class="fa fa-calendar"></i> <span>日历</span>
						  <!-- <small class="label pull-right label-danger">3</small> -->
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
					  </li>
					  <li>
						<a href="#">
						  <i class="fa fa-envelope"></i> <span>邮箱</span>
						  <!-- <small class="label pull-right label-warning">12</small> -->
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-folder"></i> <span>实例</span>
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li><a href="#"><i class="fa fa-circle-o"></i> 清单</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 简况</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 登录</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 注册</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 锁频</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 404 错误</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 500 错误</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 空白页面</a></li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 自适应页面</a></li>
						</ul>
					  </li>
					  <li class="treeview">
						<a href="#">
						  <i class="fa fa-share"></i> <span>多级</span>
						  <i class="fa fa-angle-right pull-right"></i>
						</a>
						<ul class="treeview-menu">
						  <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
						  <li>
							<a href="#"><i class="fa fa-circle-o"></i> 一级 <i class="fa fa-angle-right pull-right"></i></a>
							<ul class="treeview-menu">
							  <li><a href="#"><i class="fa fa-circle-o"></i> 二级</a></li>
							  <li>
								<a href="#"><i class="fa fa-circle-o"></i> 二级 <i class="fa fa-angle-right pull-right"></i></a>
								<ul class="treeview-menu">
								  <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
								  <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
								</ul>
							  </li>
							</ul>
						  </li>
						  <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
						</ul>
					  </li>
					  <li><a href="#"><i class="fa fa-book"></i> <span>文档</span></a></li>
					  <li class="header">标签</li>
					  <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>重要</span></a></li>
					  <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>警告</span></a></li>
					  <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>通知</span></a></li>
					</ul>
				  </section>
		 </aside>
	
	
	</div> 
		<!-- 显示信息 -->
		<div id="main_info">
			 <div class="page22_navs">
				<ul class="elements">
					<li class="level_nav_main">
						<span style="line-height:39px">
							<i class="fa fa-home fa-lg"></i>&nbsp;&nbsp;&nbsp;<span style="font-size:15px">主页</span>
						</span>
					</li>
				</ul>
			</div>
			<div class="underline"></div>
			<div id="pages">
				
			</div>
		</div>
	</div>
	

	
<script type="text/javascript" src="/wms/resources/js/main/main.js"></script>
<script type="text/javascript" src="/wms/resources/js/main/sidebar-menu.js"></script>
</body>
</html>
