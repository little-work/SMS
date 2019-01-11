<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>



<link rel="stylesheet" href="/wms/resources/css/pages/supplier.css" />

</head>
<body>
	<input type="hidden" id="testParame_supplier" value="lilinsupplier"/>
	
	
	<div id="toolbar_supplier" class="btn-group">
	 		 <button id="add_supplier" type="button" class="btn btn-default">
		 		<span ><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;新增</span>
		 	</button>
	 		 <button id="supplier_query" type="button" class="btn btn-default">
		 		<span ><i class="fa-search"></i>&nbsp;&nbsp;查询</span>
		 	</button>
		 	 <button id="getSelectData" type="button" class="btn btn-default">
		 		<span ><i class="fa-search"></i>&nbsp;&nbsp;查询</span>
		 	</button>
		
		 	<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期</span>
	      	<div class="layui-input-inline">
	        	<input style="color:#96adb6" type="text" class="layui-input" id="test2" placeholder="请选择日期">
      	  	</div>
			
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;联系人名</span>
			<input type="text" id="contactsName" class="toolbars" />
			
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;供应商</span>
			<select id="supplier_supplier">
		        
     		 </select>
    </div>
	
	
	
	<div class="mainTable">
	<!-- 供应商主表 -->
	<table id="supplierTable"></table>  
	</div>
	

	<script type="text/javascript" src="/wms/resources/js/pages/supplier.js"></script>

</body>
</html>
