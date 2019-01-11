<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="/wms/resources/css/pages/openCourse.css" />

</head>
<body>
	
	<div id="toolbar_openCourse" class="btn-group">
	 		 <button id="add_course" type="button" class="btn btn-default">
		 		<span ><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;新增</span>
		 	</button>
	 		 <button id="course_query" type="button" class="btn btn-default">
		 		<span ><i class="fa-search"></i>&nbsp;&nbsp;查询</span>
		 	</button>
    </div>
	
	<div class="mainTable">
		<!-- 开设课程主表 -->
		<table id="openCourseTable"></table>  
	</div>
	
	
	
	
	
	
	
	
	
	
	
<script type="text/javascript" src="/wms/resources/js/pages/openCourse.js"></script>

</body>
</html>