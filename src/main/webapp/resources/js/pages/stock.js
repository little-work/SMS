$(function () { 
	initGoodsInfoTable();
		//点击新增按钮  添加商品信息
	$("#add_goods").click(function(){addGoods()})
		
		
	//时间选择器
		layui.use('laydate', function(){
			var laydate = layui.laydate;
			 //常规用法
			  laydate.render({
			    elem: '#test1'
			  });
		});
	
	//初始化查询按钮选项中的商品种类和供应商
	queryGoodsSupplier("Supplier","请选择");
	queryGoodsType("GoodsType","请选择");

	
	//点击查询按钮查询商品信息
	$("#goods_query").click(function(){
		 $.ajax({
		        type:"post",
		        url:"/wms/queryGoodsByCondition",
		        data:{
		        	"queryDate":$("#test1").val(),
		        	"queryGoodsSupplier":$("#Supplier").val(),
		        	"queryGoodsTypeCode":$("#GoodsType").val(),
		        },
		        success:function (result) {
		        	
		        	//alert(result.rows.length)
		        	$("#goodsinfotable").bootstrapTable('load',result.rows);
		        }
		    });
	})	
		
		
		
}); 
 

function editGoodsRow(thisdata){
	
	var row=[];
	
	$(thisdata).parent().parent().find("td").each(function(index,element){
		row.push($(element).text());
	})

	var editGoodsHTML='<form style="margin-left:10px;" class="addGoods" id="addGoods" action="">'+
	'<p>'+
		'<label for="goodsNameEdit">商&nbsp;&nbsp;品&nbsp;&nbsp;名：</label>'+
		 '<input type="text" class="inforecord" id="goodsNameEdit" name="goodsNameEdit" placeholder="1-5个字符" value="'+row[0]+'" onblur="myValidate(5,this)"/>'+
		 '<span class="name_waring"></span>'+
	'</p>'+
	'<p>'+
		'<label for="goodsPriceEdit">商品价格：</label>'+
		'<input type="text" class="inforecord" id="goodsPriceEdit" name="goodsPriceEdit" placeholder="￥0.00" value="'+row[3]+'" onblur="myValidate(1,this)"/>'+
		'<span class="price_waring"></span>'+
	'</p>'+
	'<p>'+
		'<label for="goodsNumberEdit">入库数量：</label>'+
		'<input type="text" class="inforecord" id="goodsNumberEdit" name="goodsNumberEdit" placeholder="清输入整数" value="'+row[2]+'" onblur="myValidate(2,this)"/>'+
		'<span class="number_waring"></span>'+
	'</p>'+
	'<p>'+
		'<label for="goodsSupplierEdit">供&nbsp;&nbsp;应&nbsp;&nbsp;商：</label>'+
		'<select style="height:22px;width:130px" id="goodsSupplierEdit" name="goodsSupplierEdit">'+
		'</select>'+
	'</p>'+
	'<p>'+
	'<label for="goodsTypeEdit">产品种类：</label>'+
	'<select style="height:22px;width:130px" id="goodsTypeEdit" name="goodsTypeEdit">'+
	'</select>'+
'</p>'+
	'</form>';
	
	
	queryGoodsSupplier("goodsSupplierEdit",row[4]);
	queryGoodsType("goodsTypeEdit",row[1]);


	 layer.open({
	  title: ['编辑商品', 'font-size:16px;'],
	  skin:'layui-layer-molv',
	  type: 1,
  	  area: ['400px', '300px'],
  	  content: editGoodsHTML, //这里content是一个普通的String
  	  btn: ['编辑', '取消'],
	  yes: function(index, layero){
			    $.ajax({
			        type:"post",
			        url:"/wms/editGoods",
			        data:{
			        	"goodsNameEdit":$("#goodsNameEdit").val(),
			        	"goodsPriceEdit":$("#goodsPriceEdit").val(),
			        	"goodsNumberEdit":$("#goodsNumberEdit").val(),
			        	"goodsSupplierEdit":$("#goodsSupplierEdit").val(),
			        	"goodsTypeCodeEdit":$("#goodsTypeEdit").val(),
			        	"goodsID":$(thisdata).attr("data-value")
			        },
			        success:function (data) {
			        	if(data=="ok"){
			        		//编辑成功后刷新表格
			        	    $("#goodsinfotable").bootstrapTable('refresh', {url: '/wms/queryAllGoods' });
			        	    layer.open({
								  title: '提示'
								  ,content: '修改成功'
								});
			        	    layer.close(index);
			        	}else{
			        		layer.open({
								  title: '提示'
								  ,content: '修改商品异常'
								});
			        	    layer.close(index);
			        	}
			        	
			        }
			    });
	  },
	  btn2: function(index, layero){
		  layer.close(index);
	    //return false 开启该代码可禁止点击该按钮关闭
	  }
  	});
}

function deleteGoodsRow(thisdata){
	
	//询问框
	layer.confirm('你确定要删除这条记录吗？', {
	  btn: ['是的','取消'] //按钮
	}, function(){
		$.ajax({
			url : "/wms/deleteGoods",
			type : "post",
			data : {
				"goodsid":$(thisdata).attr("data-value")
			},
			//dataType : "json",
			success : function(data) {
				if(data=="ok"){
					layer.open({
						  title: '提示'
						  ,content: '删除成功'
						});
					$("#goodsinfotable").bootstrapTable('refresh', {url: '/wms/queryAllGoods' });
				}else{
					layer.open({
						  title: '提示'
						  ,content: data
						});
				}
			},
			error : function() {
				layer.open({
					  title: '提示'
					  ,content: '删除异常'
					});
				return;
			}
		});
	}, function(){
	  return;
	});
	
	
}
//点击添加按钮添加商品信息
function addGoods(){
	 
	var addGoodsHTML='<form style="margin-left:10px;" class="addGoods" id="addGoods" action="">'+
						'<p>'+
							'<label for="goodsName">商&nbsp;&nbsp;品&nbsp;&nbsp;名：</label>'+
							 '<input type="text" id="goodsName" name="goodsName" placeholder="1-5个字符" onblur="myValidate(5,this)"/>'+
							 '<span class="name_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="goodsPrice">商品价格：</label>'+
							'<input type="text" id="goodsPrice" name="goodsPrice" placeholder="￥0.00" onblur="myValidate(1,this)"/>'+
							'<span class="price_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="goodsNumber">入库数量：</label>'+
							'<input type="text" id="goodsNumber" name="goodsNumber" placeholder="清输入整数" onblur="myValidate(2,this)"/>'+
							'<span class="number_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="goodsSupplier">供&nbsp;&nbsp;应&nbsp;&nbsp;商：</label>'+
							'<select style="height:22px;width:130px" id="goodsSupplier" name="goodsSupplier">'+
							'</select>'+
						'</p>'+
						'<p>'+
						'<label for="goodsType">产品种类：</label>'+
						'<select style="height:22px;width:130px" id="goodsType" name="goodsType">'+
						'</select>'+
					'</p>'+
						'</form>';
	

	
	queryGoodsSupplier("goodsSupplier","请选择");
	queryGoodsType("goodsType","请选择");


	 layer.open({
	  title: ['添加商品', 'font-size:16px;'],
	  skin:'layui-layer-molv',
	  type: 1,
  	  area: ['400px', '300px'],
  	  content: addGoodsHTML, //这里content是一个普通的String
  	  btn: ['添加', '取消'],
	  yes: function(index, layero){
		  	
		  		if($("#goodsName").val()=="" || !(/^[0-9a-zA-Z\u4e00-\u9fa5]{1,5}$/.test($("#goodsName").val()))){
		  			$("#goodsName").addClass("warning");
    				$("#goodsNameEdit").addClass("warning");
    				$(".name_waring").html("1-5个字符");
    				$("#goodsName").focus();
    				$("#goodsNameEdit").focus();
    				return;
		  		}else{
    				$("#goodsName").removeClass("warning");
    				$("#goodsNameEdit").removeClass("warning");
    				$(".name_waring").html("");
    			}
		  		
		  		
		  		if($("#goodsPrice").val()=="" || !(/(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/.test($("#goodsPrice").val()==""))){
		  			$("#goodsPrice").addClass("warning");
    				$("#goodsPriceEdit").addClass("warning");
    				$(".price_waring").html("请输入正确的金额格式");
    				$("#goodsPrice").focus();
    				$("#goodsPriceEdit").focus();
    				return;
    			}else{
    				$("#goodsPrice").removeClass("warning");
    				$("#goodsPriceEdit").removeClass("warning");
    				$(".price_waring").html("");
    			}
		  		
		  		if($("#goodsNumber").val()=="" || !(/^\+?[1-9][0-9]*$/.test($("#goodsNumber").val()==""))){
		  			$("#goodsNumber").addClass("warning");
    				$("#goodsNumberEdit").addClass("warning");
    				$(".number_waring").html("请输入正整数");
    				$("#goodsNumber").focus();
    				$("#goodsNumberEdit").focus();
    				return;
    			}else{
    				$("#goodsNumber").removeClass("warning");
    				$("#goodsNumberEdit").removeClass("warning");
    				$(".number_waring").html("");
    			}
		  
		  		if($("#goodsSupplier").val()=="请选择"){
		  			layer.open({
						  title: '提示'
						  ,content: "请选择供应商"
						});
		  			return;
		  		}
		  		if($("#goodsType").val()==""){
		  			layer.open({
						  title: '提示'
						  ,content: "请选择商品种类"
						});
		  			return;
		  		}
		  		
			    $.ajax({
			        type:"post",
			        url:"/wms/addGoods",
			        data:{
			        	"goodsName":$("#goodsName").val(),
			        	"goodsPrice":$("#goodsPrice").val(),
			        	"goodsNumber":$("#goodsNumber").val(),
			        	"goodsSupplier":$("#goodsSupplier").val(),
			        	"goodsTypeCode":$("#goodsType").val()
			        },
			        success:function (data) {
			        	for(var p in data){
			        		if(p=="true"){
				        		//添加成功后刷新表格
					        	$("#goodsinfotable").bootstrapTable('refresh', {url: '/wms/queryAllGoods' });
					        	layer.open({
									  title: '提示'
									  ,content: data[p]
									});
					        	layer.close(index);
			        		}else{
			        			layer.open({
									  title: '提示'
									  ,content: data[p]
									});
					        	layer.close(index);
			        		}
			        	}
			        }
			    });
		  
		  
	  },
	  btn2: function(index, layero){
	   
		  layer.close(index);
	    //return false 开启该代码可禁止点击该按钮关闭
	  }
  	});

}


