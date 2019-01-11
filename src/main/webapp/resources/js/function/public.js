//点击垂直导航进行切换
function changeLeftNav(ClassSuffix){
		
	
	if($("."+ClassSuffix).length>0){
		//其他子元素隐藏起来
		$("."+ClassSuffix).siblings().hide();
		$("."+ClassSuffix).show();
		
		changeStyle(ClassSuffix);
		
	}else{
		$("#pages").append('<div class="'+ClassSuffix+'" style="display:block"></div>')
		
		$(".elements").append("<li class='level_nav_"+ClassSuffix+"' onclick='changeNav(this)'><span style='line-height:39px'>"+$(".left_nav_"+ClassSuffix+"").text()+"</span><img class='image_"+ClassSuffix+"' src='/wms/resources/images/error.png'></li>")
		
		$("."+ClassSuffix).load("/wms/"+ClassSuffix+"");
		
		$("."+ClassSuffix).siblings().hide();
		
		changeStyle(ClassSuffix);
		
		//鼠标悬停和离开事件
		$(".image_"+ClassSuffix+"").mouseover(function(){
			 $(this).attr("src","/wms/resources/images/error2.png");
		});
		$(".image_"+ClassSuffix+"").mouseleave(function(){
			$(this).attr("src","/wms/resources/images/error.png");
		});
		
		//点击关闭按钮
		$(".image_"+ClassSuffix+"").click(function(e){
			e.stopPropagation();
			$(this).parent().remove();
			if($("."+ClassSuffix).css("display")=="none"){
				$("."+ClassSuffix).remove();
			}else{
				if($("."+ClassSuffix).next().length>0){
					$("."+ClassSuffix).next().show();
					
				}else{
					if($("."+ClassSuffix).prev().length>0){
						$("."+ClassSuffix).prev().show();
					}
				}
				$("."+ClassSuffix).remove();
			}
		
			
		})
	}

}

function changeStyle(ClassSuffix){
	$(".level_nav_"+ClassSuffix).css("font-size","15px");
	$(".level_nav_"+ClassSuffix).css("color","black");
	$(".level_nav_"+ClassSuffix).css("font-weight","bold");
	$(".level_nav_"+ClassSuffix).css("background-color","rgb(150, 173, 182)");
	
	$(".level_nav_"+ClassSuffix).siblings().css("font-size","13px");
	$(".level_nav_"+ClassSuffix).siblings().css("color","black");
	$(".level_nav_"+ClassSuffix).siblings().css("font-weight","normal");
	$(".level_nav_"+ClassSuffix).siblings().css("background-color","#fff");
}

//点击水平导航进行切换
function changeNav(x){
		$(x).css("font-size","15px");
		$(x).css("color","black");
		$(x).css("font-weight","bold");
		$(x).css("background-color","rgb(150, 173, 182)");
		
		
		$(x).siblings().css("font-size","13px");
		$(x).siblings().css("color","black");
		$(x).siblings().css("font-weight","normal");
		$(x).siblings().css("background-color","#fff");
		
		var thisclass=$(x).attr("class").substring(10);
		var x="."+thisclass;
		//其他子元素隐藏起来
		$(x).siblings().hide();
		$(x).show();
	
}



//查询所有的供应商
function queryGoodsSupplier(x,y){
	 $.ajax({
	        type:"post",
	        url:"/wms/queryAllSupplier",
	        success:function (result) {
	        	if(result!=null || result!=""){
	        		var str="<option value ='"+y+"'>"+y+"</option>";
		        	var data=result.rows;
		        	for(var i=0;i<data.length;i++){
		        		if(y!=data[i].supplier_name){
		        			str += "<option value ='"+data[i].supplier_name+"'>"+data[i].supplier_name+"</option>";
		        		}
			        	
		        	}
		        	$("#"+x).html(str);
	        	}else{
	        		layer.open({
	    				  title: '提示'
	    				  ,content: '查找供应商为空或者异常'
	    				});
	        	}
	        	
	        	
	        },
			error : function() {
				layer.open({
					  title: '提示'
					  ,content: '查询供应商失败'
					});
				return;
			}
	    });
}


//查询所有的商品种类
function queryGoodsType(y,x){
	$.ajax({
        type:"post",
        url:"/wms/queryAllGoodsType",
        success:function (result) {
        	
        	if(result!=null || result!=""){
        		var str="";
            	if(x=="请选择"){
            		str +="<option value =''>"+x+"</option>";
            	}
            	var data=result.rows;
            	for(var i=0;i<data.length;i++){
            		if(data[i].goods_type_name==x){
            			str += "<option selected value ='"+data[i].goods_type_code+"'>"+data[i].goods_type_name+"</option>";
            		}else{
            			str += "<option  value ='"+data[i].goods_type_code+"'>"+data[i].goods_type_name+"</option>";
            		}
            	}
            	$("#"+y).html(str);
        	}else{
        		layer.open({
  				  title: '提示'
  				  ,content: '查找商品种类为空或者异常'
  				});
        	}
        	
        },
		error : function() {
			layer.open({
				  title: '提示'
				  ,content: '查找商品种类失败'
				});
			return;
		}
    });
}



//js中设置cookie的值和过时时间  天计算的
function setCookie(cname,cvalue,exdays)
{
  var d = new Date();
  d.setTime(d.getTime()+(exdays*24*60*60*1000));
  var expires = "expires="+d.toGMTString();
  document.cookie = cname + "=" + cvalue + "; " + expires;
}



//获取cookie的值
function getCookie(cname)
{
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) 
  {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}

//制保留2位小数，如：2，会在2后面补上00.即2.00    
function toDecimal2(x) {    
        var f = parseFloat(x);    
        if (isNaN(f)) {    
            return false;    
        }    
        var f = Math.round(x*100)/100;    
        var s = f.toString();    
        var rs = s.indexOf('.');    
        if (rs < 0) {    
            rs = s.length;    
            s += '.';    
        }    
        while (s.length <= rs + 2) {    
            s += '0';    
        }    
        return s;    
}    


//初始化表单的公共方法  直接带进去参数即可使用
function initTable(id,url,toolbar,columns,queryfunction){
	$(id).bootstrapTable({  
        url: url,  
        queryParamsType: 'limit',
        toolbar: toolbar, //工具按钮用哪个容器
        contentType:"application/json",//默认值为 'limit' ,在默认情况下 传给服务端的参数为：offset,limit,sort  
        queryParams: queryfunction,  
        method: "get",  
        pagination: true,   //设置为 true 会在表格底部显示分页条
        showColumns: false,   //是否显示 内容列下拉框
        //search: true,
		clickToSelect: true,  //设置true 将在点击行时，自动选择rediobox 和 checkbox
        pageNumber: 1,  
        pageSize: 10,  
        pageList: [10, 20, 50, 100],
        showPaginationSwitch:true,   //是否显示 数据条数选择框
        showRefresh: true,
        sidePagination: "server",         //分页方式：client客户端分页，server服务端分页（*）  设置 ‘server’时，必须设置 服务器数据地址（url）或者重写ajax方法
        striped: false,                    //是否显示行间隔色  
        cache: false,  
        uniqueId:"idid",               //每一行的唯一标识，一般为主键列  
        height:550,  
        paginationPreText: "》》》",  
        paginationNextText: "《《《",
        columns: columns,
		rowStyle:function(row,index){  
        	if(index%2 == 0)  
        	   {  
        		return {css:{"background-color":"#ffffff","color":"#000000"}};   
        	   }else{  
        		return {css:{"background-color":"#ffffff","color":"#000000"}};  
        	   }    
        },
        onLoadSuccess: function (data) {
        	
        	//得到当前页数据
        	 var data = $('#openCourseTable').bootstrapTable('getData', true);
             //合并单元格
             myMergeCells(data, "pachage_name", 1, $('#openCourseTable'));
        	
             myMergeCells(data, "course_type", 1, $('#openCourseTable'));
           /* $(id).bootstrapTable('mergeCells', {index: 0, field: 'pachage_name', rowspan: 2});
            $(id).bootstrapTable('mergeCells', {index: 0, field: 'course_type', rowspan: 2});
            $(id).bootstrapTable('mergeCells', {index: 0, field: 'if_package', rowspan: 2});*/
        },
    });
}
/**
 * 合并单元格
 * @param data  原始数据（在服务端完成排序）
 * @param fieldName 合并属性名称
 * @param colspan   合并列
 * @param target    目标表格对象
 */
function myMergeCells(data,fieldName,colspan,target){
    //声明一个map计算相同属性值在data对象出现的次数和
    var sortMap = {};
    for(var i = 0 ; i < data.length ; i++){    //这里的data是当前页的数据  是一个json数组，每个json中的键是列名， 值是每一行该列的值
        for(var prop in data[i]){
            if(prop == fieldName){ 			//判断传入的列名是不是当前遍历得到的列名
                var key = data[i][prop]
                if(sortMap.hasOwnProperty(key)){
                    sortMap[key] = sortMap[key] * 1 + 1;  //给这个json赋值
                } else {
                    sortMap[key] = 1;
                }
                break;
            } 
        }
    }
   
    var index = 0;
    for(var prop in sortMap){   //遍历这个json
        var count = sortMap[prop] * 1;
        $(target).bootstrapTable('mergeCells',{index:index, field:fieldName, colspan: colspan, rowspan: count});   
        index += count;
    }
}

//js函数原型  可以直接调用的  new Date().Format("yyyy-MM-dd")
Date.prototype.Format = function (fmt) { // author: meizz
    var o = {
        "M+": this.getMonth() + 1, // 月份
        "d+": this.getDate(), // 日
        "h+": this.getHours(), // 小时
        "m+": this.getMinutes(), // 分
        "s+": this.getSeconds(), // 秒
        "q+": Math.floor((this.getMonth() + 3) / 3), // 季度
        "S": this.getMilliseconds() // 毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
            return fmt;
}


//常用的正则js正则验证
function myRegx(which,tishi,type){
	//00不为空验证
	if(type=="00"){
		if($("#"+which).val()==""){
			$("."+tishi).html("<span style='color:red'>不得为空</span>");
			return;
		}else{
			$("."+tishi).html("");
		}
	}
	//01代表正整数验证
	if(type=="01"){
		if($("#"+which).val()=="" || !/^[1-9]\d*$/.test($("#"+which).val())){
			$("."+tishi).html("<span style='color:red'>请输入正整数</span>");
			return;
		}else{
			$("."+tishi).html("");
		}
	}
	//02代表姓名验证过
	if(type=="02"){
		if($("#"+which).val()=="" || !/^[\u4E00-\u9FA5]{2,4}$/.test($("#"+which).val())){
			$("."+tishi).html("<span style='color:red'>请输入正确的姓名</span>");
			return;
		}else{
			$("."+tishi).html("");
		}
	}
	
	//03代表金额的验证
	if(type=="03"){
		if($("#"+which).val()=="" || !/^(([1-9][0-9]*)|(([0]\.\d{1,2}|[1-9][0-9]*\.\d{1,2})))$/.test($("#"+which).val())){
			$("."+tishi).html("<span style='color:red'>请输入正确金额格式</span>");
			return;
		}else{
			$("."+tishi).html("");
		}
	}
	
	
	
}
function myRegxforString(which,tishi,min,max){
	
		
		if($("#"+which).val().length<min){
			if($("#"+which).val()==""){
				$("."+tishi).html("<span style='color:red'>不得为空</span>");
				return;
			}
			$("."+tishi).html("<span style='color:red'>最少输入"+min+"个字符，你已经输入"+$("#"+which).val().length+"个</span>");
			return;
		}
		
		if($("#"+which).val().length>max){
			$("."+tishi).html("<span style='color:red'>最多输入"+max+"个字符，你已经输入"+$("#"+which).val().length+"个</span>");
			return;
		}else{
			$("."+tishi).html("");
		}
}
	





