<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*"%>

<%
    ResourceBundle resource = ResourceBundle.getBundle("mysql");
%>
<!DOCTYPE html>
<html lang="en" class="no-js">
<head>
<meta charset="UTF-8" />
<title>欢迎登陆</title>
<link rel="stylesheet" type="text/css" href="/wms/resources/css/login/normalize.css" />
<link rel="stylesheet" type="text/css" href="/wms/resources/css/login/demo.css" />
<!--必要样式-->
<link rel="stylesheet" type="text/css" href="/wms/resources/css/login/component.css" />
<link rel="stylesheet" href="/wms/resources/layui/css/layui.css">
</head>
<body>
		<div class="container demo-1">
			<div class="content">
				<div id="large-header" class="large-header">
					<canvas id="demo-canvas"></canvas>
					<div class="logo_box">
					<%-- <input type="hidden" id="properties" value="<%=resource.getString("driverClassName")%>"/>
					<%=resource.getString("driverClassName") %> --%>
						 <h3>未来星辅导班管理系统<span id="websocket"></span></h3>
						<%-- <h3><%=resource.getString("driverClassName") %></h3> --%>
							<div class="input_outer">
								<span class="u_user"></span>
								<input name="username" id="username" class="text account" style="color: #FFFFFF !important" type="text" placeholder="请输入用户名">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="password" id="password" class="text pwd" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="password" placeholder="请输入密码">
							</div>
							<div class="input_outer">
								<span class="us_uer"></span>
								<input name="code" id="code" class="text pwd" style="color: #FFFFFF !important; position:absolute; z-index:100;"value="" type="text" placeholder="请输入验证码">
							</div>
							<label for="code" class="code" data-icon="p">验证码： </label>
							<img id="img" src="/wms/getImage"  style="cursor:pointer"> 
							
							<p class="keeplogin" style="margin-top: 18px">
							<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" /> <label for="loginkeeping">记住登录</label>
							</p>
							<div class="mb2 login"><a class="act-but submit" href="#" style="color: #FFFFFF">登录</a></div>
					</div>
				</div>
			</div>
		</div>
		
		<script type="text/javascript"  src="/wms/resources/js/jquery-3.3.1.min.js"></script>
		<script type="text/javascript" src="/wms/resources/js/login/TweenLite.min.js"></script>
		<script type="text/javascript" src="/wms/resources/js/login/EasePack.min.js"></script>
		<script type="text/javascript" src="/wms/resources/js/login/demo-1.js"></script>
		<script type="text/javascript" src="/wms/resources/layui/layui.all.js"></script>
		<script type="text/javascript" src="/wms/resources/js/function/public.js"></script>
  		<script type="text/javascript"  src="/wms/resources/js/login/loginAndRegist.js"></script>
  		
	</body>
</html>