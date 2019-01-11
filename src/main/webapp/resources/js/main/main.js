$(function(){
	
//插件加载垂直导航
$.sidebarMenu($('.sidebar-menu'))
//退出按钮
$(".exit").click(function(){
	exit();
})


//学生入学流程
$(".left_nav_enterschool").click(function(){
	changeLeftNav("enterschool");
})

//开设课程
$(".left_nav_openCourse").click(function(){
	changeLeftNav("openCourse");
})




//商品入库
$(".left_nav_stock").click(function(){
	changeLeftNav("stock");
})
//供应商管理
$(".left_nav_supplier").click(function(){
	changeLeftNav("supplier");
})

	
//滑动的下拉菜单
$(".username").click(function(){
	$(".slideTxtBox").slideToggle("fast",function(){
		
	});
});


//鼠标悬停图标改变
$(".who").mouseover(function(){
	$(".option").show();
	
	if($(".option").css("display")=="block"){
		$(".who i").attr("class","fa fa-caret-down fa-lg");
	}else{
		$(".who i").attr("class","fa fa-caret-right fa-lg");
	}
	
})
$(".who").mouseleave(function(){
	$(".option").hide();
	
	if($(".option").css("display")=="none"){
		$(".who i").attr("class","fa fa-caret-right fa-lg");
	}else{
		$(".who i").attr("class","fa fa-caret-down fa-lg");
	}
})

$(".option").mouseover(function(){
	$(".option").show();

	if($(".option").css("display")=="block"){
		$(".who i").attr("class","fa fa-caret-down fa-lg");
	}else{
		$(".who i").attr("class","fa fa-caret-right fa-lg");
	}
})
$(".option").mouseleave(function(){
	$(".option").hide();
	
	if($(".option").css("display")=="none"){
		$(".who i").attr("class","fa fa-caret-right fa-lg");
	}else{
		$(".who i").attr("class","fa fa-caret-down fa-lg");
	}
})

$(".option ul").find("li").each(function(){
	$(this).mouseover(function(){
		$(this).css("background-color","#4b6470");
		$(this).siblings().css("background-color","#222d32");
	})
})



})

//点击退出按钮 退出当前页面
function exit(){
	//询问框
	layer.confirm('你确定要退出当前登录？', {
	  btn: ['是的','取消'] //按钮
	}, function(){
		window.location.href='/wms/loginout';
	}, function(){
	  return;
	});
}

		



