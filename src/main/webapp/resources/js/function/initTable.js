//初始化商品入库表格中的参数
function initGoodsInfoTable(){
	var id='#goodsinfotable';
	var url='/wms/queryAllGoods';
	var toolbar='#toolbar_stock';
	var columns=[  
        { checkbox: true },
        { title: '商品名称', field: 'goods_name',align:"center",valign:"middle" },
        { title: '商品种类', field: 'goods_type_name',align:"center",valign:"middle" },
        { title: '商品数量', field: 'goods_number',align:"center",valign:"middle"},  
        { title: '商品价格', field: 'goods_price',align:"center",valign:"middle",formatter: function (value, row, index) { 
            return toDecimal2(value);  
        }},  
        { title: '供应商', field: 'goods_supplier' ,align:"center",valign:"middle"},
        { title: '入库时间', field: 'store_time' ,align:"center",valign:"middle"
        },
        { title: '更新时间', field: 'update_time' ,align:"center",valign:"middle"
        },
        {  
            title: '操作', field: 'goods_id', align:"center",valign:"middle",formatter: function (value, row, index) { 
            	
                var html = '<span onclick="editGoodsRow(this)" data-value="'+value+'"  class="editGoods"><i class="fa fa-pencil-square-o fa-lg"></i>&nbsp;&nbsp;编辑&nbsp;&nbsp;&nbsp;&nbsp;</span>';  
                html += '<span onclick="deleteGoodsRow(this)" data-value="'+value+'" class="deleteGoods"><i class="fa fa-trash fa-lg"></i>&nbsp;&nbsp;删除</span>';  
                return html;  
            }  
        }  
    ];
	//一个公共的方法  带进去参数即可
	initTable(id,url,toolbar,columns);
}
//商品入库表格的查询条件  
function queryParamsStock(params) {  
  return {  
  	limit: params.limit, //页面大小
  	 offset: params.offset, //页码
      queryParamTest:$("#testParame_stock").val()
  };  
} 


//-----------------------------------------------------------------------------------------


//商品供应商表格初始化
function initSupplierTable(){
	var id='#supplierTable';
	var url='/wms/queryAllSupplierInfo';
	var toolbar='#toolbar_supplier';
	var columns=[  
        { checkbox: true },
        { title: '供应商', field: 'supplier_name',align:"center",valign:"middle",rowspan:2 },
        { title: '联系人', field: 'contacts',align:"center",valign:"middle" },
        { title: '联系人号码', field: 'contacts_phone',align:"center",valign:"middle"},  
        { title: '添加时间', field: 'entry_time',align:"center",valign:"middle"},
        {  
            title: '操作', field: 'supplier_id', align:"center",valign:"middle",formatter: function (value, row, index) { 
            	
                var html = '<span onclick="editSupplierRow(this)" data-value="'+value+'"  class="editSupplier"><i class="fa fa-pencil-square-o fa-lg"></i>&nbsp;&nbsp;编辑&nbsp;&nbsp;&nbsp;&nbsp;</span>';  
                html += '<span onclick="deleteSupplierRow(this)" data-value="'+value+'" class="deleteSupplier"><i class="fa fa-trash fa-lg"></i>&nbsp;&nbsp;删除</span>';  
                return html;  
            }  
        }
    ];
	
	//一个公共的方法  带进去参数即可
	initTable(id,url,toolbar,columns,queryParamsSupplier);
}
//供应商初始化表单查询条件
function queryParamsSupplier(params) {  
  return {  
  	limit: params.limit, //页面大小
  	 offset: params.offset, //页码
      queryParamTest:$("#testParame_supplier").val()
  };  
} 


//-----------------------------------------------------------------------------------------


//商品供应商表格初始化
function initUserTable(){
	var id='#userTable';
	var url='/wms/queryAllUserInfo';
	var toolbar='#toolbar_user';
	var columns=[  
        { checkbox: true },
        { title: '用户名', field: 'user_name',align:"center",valign:"middle" },
        { title: '角色', field: 'role_name',align:"center",valign:"middle" },
        { title: '添加时间', field: 'rigist_time',align:"center",valign:"middle"},
        { title: '状态', field: 'status',align:"center",valign:"middle",formatter: function (value, row, index) { 
        	if(value=="0"){
        		return "<span style='color:green'>正常</span>";
        	}
        }},  
        {  
            title: '操作</span>', field: 'user_id', align:"center",valign:"middle",formatter: function (value, row, index) { 
            	var html ='<span onclick="deleteSupplierRow(this)" data-value="'+value+'" class="deleteSupplier"><i class="fa fa-trash fa-lg"></i>&nbsp;&nbsp;删除</span>';  
                return html;  
            }  
        }
    ];
	
	//一个公共的方法  带进去参数即可
	initTable(id,url,toolbar,columns,queryParamsSupplier);
	
}

//供应商初始化表单查询条件
function queryParamsSupplier(params) {  
  return {  
  	limit: params.limit, //页面大小
  	 offset:params.offset, //页码
      queryParamTest:$("#testParame_supplier").val()
  };  
}

//-----------------------------------------------------------------------------------------

function initOpenCourseTable(){
	
	var id='#openCourseTable';
	var url='/wms/queryAllOpenedCourse';
	var toolbar='#toolbar_openCourse';
	var columns=[  
		 { checkbox: true },
	        { title: '课程类型', field: 'course_type',align:"center",valign:"middle"},
	         { title: '套餐名', field: 'pachage_name',align:"center",valign:"middle"},
	        { title: '是否套餐课程', field: 'if_package',align:"center",valign:"middle",formatter: function (value, row, index) { 
	            if(value=="0"){
	                return "<span style='color:green'>不是</span>";
	            }else if(value=="1"){
	                return "<span style='color:green'>是</span>";
	            }
	        }},
	        { title: '课程名', field: 'course_name',align:"center",valign:"middle"},
	        { title: '节时/分钟', field: 'course_time',align:"center",valign:"middle" },
	        { title: '几年级', field: 'course_class',align:"center",valign:"middle"},
	        { title: '课时', field: 'class_hour',align:"center",valign:"middle"},
	        { title: '任课老师', field: 'course_teacher',align:"center",valign:"middle"},
	        { title: '课时描述', field: 'course_detail',align:"center",valign:"middle"},
	        
	       
	        { title: '创建时间', field: 'create_time',align:"center",valign:"middle"},
	        { title: '更新时间', field: 'update_time',align:"center",valign:"middle"},
	          
	        {  
	            title: '操作', field: 'course_id', align:"center",valign:"middle",formatter: function (value, row, index) { 
	            	var html ='<span onclick="deleteOpenCourse(this)" data-value="'+value+'" class="deleteSupplier"><i class="fa fa-trash fa-lg"></i>&nbsp;&nbsp;删除</span>';  
	                return html;  
	            }  
	        }
    ];
	
	//供应商初始化表单查询条件
	function queryParamsOpenCourse(params) {  
		return {  
			limit: params.limit, //页面大小
			offset:params.offset //页码
		};  
	}
	//一个公共的方法  带进去参数即可
	initTable(id,url,toolbar,columns,queryParamsOpenCourse);
}



