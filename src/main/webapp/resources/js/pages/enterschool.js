$(function(){
	
	//切换步骤（目前只用来演示）
	$('.processorBox li').click(function(){
		var i = $(this).index(); //0  1   2
		$('.processorBox li').removeClass('current').eq(i).addClass('current');
		
		//$('.step').fadeOut(300).eq(i).fadeIn(500);
		
		$(".content").children().eq(i).show();
		$(".content").children().eq(i).siblings().hide();
		
	});
	
	//付钱页面的tab切换功能
	layui.use('element', function(){
		  var $ = layui.jquery
		  ,element = layui.element; //Tab的切换功能，切换事件监听等，需要依赖element模块
		});
	
	
	
	
})