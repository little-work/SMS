$(function(){
	initSupplierTable();
	
	//点击某行获得 这行 的数据
	$("#getSelectData").click(function(){
		var getSelectRows = $("#supplierTable").bootstrapTable('getSelections');
		
		for(var x=0;x<getSelectRows.length;x++){
			alert(getSelectRows[x].supplier_id);
		}
	})
	
	
	
	
	$("#add_supplier").click(function(){
		addSupplier();
	})
	
	//时间选择器
	layui.use('laydate', function(){
		var laydate = layui.laydate;
		 //常规用法
		  laydate.render({
		    elem: '#test2'
		  });
	});
	
	queryGoodsSupplier("supplier_supplier","请选择");
	
	$("#supplier_query").click(function(){
		
		
		 $.ajax({
		        type:"post",
		        url:"/wms/querySupplierByCondition",
		        data:{
		        	"queryDate":$("#test2").val(),
		        	"querycontacts":$("#contactsName").val(),
		        	"querySupplier":$("#supplier_supplier").val(),
		        },
		        success:function (result) {
		        	
		        	//alert(result.rows.length)
		        	$("#supplierTable").bootstrapTable('load',result.rows);
		        }
		    });
	})
	
	
})
function editSupplierRow(thisdata){
	
var row=[];
	
	$(thisdata).parent().parent().find("td").each(function(index,element){
		row.push($(element).text());
	})
	
	var editSupplierEdit='<form style="margin-left:10px;" class="addSupplier" id="addSupplier" action="">'+
	'<p>'+
		'<label for="supplierNameEdit">供应商名：</label>'+
		 '<input type="text" class="inforecord" id="supplierNameEdit" name="supplierNameEdit" value="'+row[0]+'" placeholder="1-10个字符" onblur="myValidate(3,this)"/>'+
		 '<span class="name_waring"></span>'+
	'</p>'+
	'<p>'+
		'<label for="contactsEdit">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label>'+
		'<input type="text" class="inforecord" id="contactsEdit" name="contactsEdit" value="'+row[1]+'" placeholder="请输入联系人" onblur="myValidate(4,this)"/>'+
		'<span class="contacts_waring"></span>'+
	'</p>'+
	'<p>'+
		'<label for="contactsPhoneEdit">联系方式：</label>'+
		'<input type="text" class="inforecord" id="contactsPhoneEdit" name="contactsPhoneEdit" value="'+row[2]+'" placeholder="请输入手机号码" onblur="myValidate(6,this)"/>'+
		'<span class="contactsPhone_waring"></span>'+
	'</p>'+
	'</form>';
	
	
	 layer.open({
		  title: ['修改供应商', 'font-size:16px;'],
		  skin:'layui-layer-molv',
		  type: 1,
	  	  area: ['400px', '300px'],
	  	  content: editSupplierEdit, //这里content是一个普通的String
	  	  btn: ['编辑', '取消'],
		  yes: function(index, layero){
				    $.ajax({
				        type:"post",
				        url:"/wms/editSupplier",
				        data:{
				        	"supplierNameEdit":$("#supplierNameEdit").val(),
				        	"contactsEdit":$("#contactsEdit").val(),
				        	"contactsPhoneEdit":$("#contactsPhoneEdit").val(),
				        	"supplierID":$(thisdata).attr("data-value")
				        },
				        success:function (data) {
				        	if(data=="ok"){
				        		//编辑成功后刷新表格
				        	    $("#supplierTable").bootstrapTable('refresh', {url: '/wms/queryAllSupplierInfo' });
				        	    layer.open({
									  title: '提示'
									  ,content: '修改成功'
									});
				        	    layer.close(index);
				        	}else{
				        		layer.open({
									  title: '提示'
									  ,content: '修改供应商异常'
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
function deleteSupplierRow(thisdata){
	//询问框
	layer.confirm('你确定要删除这条记录吗？', {
	  btn: ['是的','取消'] //按钮
	}, function(){
		$.ajax({
			url : "/wms/deleteSupplier",
			type : "post",
			data : {
				"supplierID":$(thisdata).attr("data-value")
			},
			//dataType : "json",
			success : function(data) {
				if(data=="ok"){
					layer.open({
						  title: '提示'
						  ,content: '删除成功'
						});
					$("#supplierTable").bootstrapTable('refresh', {url: '/wms/queryAllSupplierInfo' });
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

//点击添加按钮添加供应商
function addSupplier(){
					var addSupplier='<form style="margin-left:10px;" class="addSupplier" id="addSupplier" action="">'+
					'<p>'+
						'<label for="supplierName">供应商名：</label>'+
						 '<input type="text" id="supplierName" name="supplierName" placeholder="1-10个字符" />'+
						 '<span class="name_waring"></span>'+
					'</p>'+
					'<p>'+
						'<label for="contacts">联&nbsp;&nbsp;系&nbsp;&nbsp;人：</label>'+
						'<input type="text" id="contacts" name="contacts" placeholder="请输入联系人" />'+
						'<span class="contacts_waring"></span>'+
					'</p>'+
					'<p>'+
						'<label for="contactsPhone">联系方式：</label>'+
						'<input type="text" id="contactsPhone" name="contactsPhone" placeholder="请输入手机号码" />'+
						'<span class="contactsPhone_waring"></span>'+
					'</p>'+
					'</form>';
				
				
				
				layer.open({
				title: ['添加供应商', 'font-size:16px;'],
				skin:'layui-layer-molv',
				type: 1,
				area: ['400px', '300px'],
				content: addSupplier, //这里content是一个普通的String
				btn: ['添加', '取消'],
				yes: function(index, layero){
					
				
					if($("#supplierName").val()=="" || !(/^[0-9a-zA-Z\u4e00-\u9fa5]{1,10}$/.test($("#supplierName").val()))){
						$("#supplierName").addClass("warning");
	    				//$("#goodsNameEdit").addClass("warning");
	    				$(".name_waring").html("1-10个字符");
	    				$("#supplierName").focus();
	    				//$("#goodsNameEdit").focus();
	    				
						
						return;
					}else{
	    				$("#supplierName").removeClass("warning");
	    				//$("#goodsNameEdit").removeClass("warning");
	    				$(".name_waring").html("");
	    			}
					
					
					if($("#contacts").val()=="" || !(/^[0-9a-zA-Z\u4e00-\u9fa5]{1,4}$/.test($("#contacts").val()))){
						$("#contacts").addClass("warning");
	    				//$("#goodsNameEdit").addClass("warning");
	    				$(".contacts_waring").html("1-4个字符");
	    				$("#contacts").focus();
	    				//$("#goodsNameEdit").focus();
						
						
						return;
					}else{
	    				$("#contacts").removeClass("warning");
	    				//$("#goodsNameEdit").removeClass("warning");
	    				$(".contacts_waring").html("");
	    			}
					
					
					
					
					if($("#contactsPhone").val()=="" || !(/(^1[3|4|5|7|8]\d{9}$)|(^09\d{8}$)/.test($("#contactsPhone").val()))){
						
						$("#contactsPhone").addClass("warning");
	    				//$("#goodsNameEdit").addClass("warning");
	    				$(".contactsPhone_waring").html("请输入正确的手机号码");
	    				$("#contactsPhone").focus();
	    				//$("#goodsNameEdit").focus();
						
						
						
						return;
					}else{
	    				$("#contactsPhone").removeClass("warning");
	    				//$("#goodsNameEdit").removeClass("warning");
	    				$(".contactsPhone_waring").html("");
	    			}
					
			
				$.ajax({
				type:"post",
				url:"/wms/addSupplier",
				data:{
					"supplierName":$("#supplierName").val(),
					"contacts":$("#contacts").val(),
					"contactsPhone":$("#contactsPhone").val()
				},
				success:function (data) {
					for(var p in data){
						if(p=="true"){
				    		//添加成功后刷新表格
				        	$("#supplierTable").bootstrapTable('refresh', {url: '/wms/queryAllSupplierInfo' });
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




