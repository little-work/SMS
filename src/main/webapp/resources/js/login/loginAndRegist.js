$(function(){
	

	/*$("#sadas").click(function(){wbs();}) */
	
//点击刷新验证码信息
$("#img").click(function(){reflushYanZhengMa();}) 
 

//按下enter键登录
$(document).keydown(function (event) {
	if (event.keyCode == 13) {toLogin();}
});
//点击登录按钮去校验登录
$(".mb2").click(function(){toLogin();});

//页面已加载就判断一下  用户是不是记住登录了
window.onload=ifRemember();

})

//用户是否点击了  那个记住密码按钮
function ifRemember(){
	if(getCookie("isRemember")=="true"){
		//填充用户名和密码
		$("#username").val(getCookie("username"));
		$("#password").val(getCookie("password"));
		//选中复选框
		$(".keeplogin").html("<input type='checkbox' checked='checked' name='loginkeeping' id='loginkeeping'"+
				"value='loginkeeping' /> <label for='loginkeeping'>记住登录</label>")
		
	}else{
		$(".keeplogin").html("<input type='checkbox'  name='loginkeeping' id='loginkeeping'"+
		"value='loginkeeping' /> <label for='loginkeeping'>记住登录</label>")
	}
}


//刷新验证码
function  reflushYanZhengMa(){
	 var url ="/wms/getImage?number="+Math.random();  
	   $("#img").attr("src",url);  
}
//登录校验
function toLogin(){
	$.ajax({
		url : "/wms/toLogin",
		type : "post",
		data : {
			"username":$("#username").val(),
			"password":$("#password").val(),
			"code":$("#code").val()
		},
		//dataType : "json",
		success : function(data) {
			for(var p in data){//遍历json对象的每个key/value对,p为key
				   if(p=="true"){
					   
					   //登录成功后如果用户记住登录  则记住用户的用户名
					   if($("#loginkeeping").prop("checked")){
						   setCookie("username",$("#username").val(),100);
						   setCookie("password",$("#password").val(),100);
						   setCookie("isRemember","true",100);
					   }
					   //如果用户登录成功  并且关闭了记住登录  则删除cookie  
					   if(!$("#loginkeeping").prop("checked")){
						   document.cookie = "username=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
						   document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 GMT";
						   setCookie("isRemember","false",100);
					   }
					
					   
					   //登录成功进行页面跳转
						window.location.href='/wms/main';
					}else{
						if(data[p]=="验证码错误"){
							$("#code").val('');
							reflushYanZhengMa();
						}
						layer.open({
							  title: '提示'
							  ,content: data[p]
							});
						return;
					}
				}
		},
		error : function() {
			layer.open({
				  title: '提示'
				  ,content: '登录失败'
				});
			return;
		}
	});
}

function wbs(){
	var websocket = null;
	var str=null;
    //判断当前浏览器是否支持WebSocket
    if ('WebSocket' in window) {
    	alert("发送wensocket")
        //建立连接，这里的/websocket ，是Servlet中注解中的那个值
        websocket = new WebSocket("ws://localhost:8080/wms/wbSocket");
    }
    else {
        alert('当前浏览器 Not support websocket');
    }
    //连接发生错误的回调方法
    websocket.onerror = function () {
        console.log("WebSocket连接发生错误");
    };
    //连接成功建立的回调方法
    websocket.onopen = function () {
        console.log("WebSocket连接成功");
    }
    //接收到消息的回调方法
    websocket.onmessage = function (event) {
    	
        console.log(event.data);
        
        $("#websocket").html(event.data);
    }
    //连接关闭的回调方法
    websocket.onclose = function () {
        console.log("WebSocket连接关闭");
    }
    //监听窗口关闭事件，当窗口关闭时，主动去关闭WebSocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
    window.onbeforeunload = function () {
        closeWebSocket();
    }
}
//关闭WebSocket连接
function closeWebSocket() {
    websocket.close();
}





