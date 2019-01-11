<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>
<link rel="stylesheet" href="/wms/resources/css/pages/stock.css" />



</head>
<body>
	<input type="hidden" id="testParame_stock" value="lilinstock"/>
	
	 <div id="toolbar_stock" class="btn-group">
	 	
	 		 <button id="add_goods" type="button" class="btn btn-default">
		 		<span ><i class="fa fa-plus-square fa-lg"></i>&nbsp;&nbsp;新增</span>
		 	</button>
	 		 <button id="goods_query" type="button" class="btn btn-default">
		 		<span ><i class="fa-search"></i>&nbsp;&nbsp;查询</span>
		 	</button>
		
		 	<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期</span>
	      	<div class="layui-input-inline">
	        	<input style="color:#96adb6" type="text" class="layui-input" id="test1" placeholder="请选择日期">
      	  	</div>
			
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;商品种类</span>
			 <select id="GoodsType" >
		        
     		 </select>
			
			<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;供应商</span>
			<select id="Supplier">
		        
     		 </select>
			
		
    </div>
	 		
	 	
 	
	<div class="mainTable">
	 <table id="goodsinfotable"></table>  
	</div>
	
	
	
	<script type="text/javascript" src="/wms/resources/js/pages/stock.js"></script>
</body>
</html>
