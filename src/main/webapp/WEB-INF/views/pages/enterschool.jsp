<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<html>
<head>
<title>Home</title>

<link rel="stylesheet" href="/wms/resources/css/pages/enterschool.css" />
<link rel="stylesheet" href="/wms/resources/css/chaos/demo.css" />

</head>
<body>
	
	<div class="containers">
		<div id="processor">
				<ol class="processorBox">
					<li class="current">
						<div class="step_inner fl">
							<span class="icon_step">1</span>
							<h4>填写基本信息</h4>
						</div>
					</li>
					<li>
						<div class="step_inner">
							<span class="icon_step">2</span>
							<h4>选择课程</h4>
						</div>
					</li>
					<li>
						<div class="step_inner fr">
							<span class="icon_step">3</span>
							<h4>完成</h4>
						</div>
					</li>
				</ol>
			<div class="step_line"></div>
		</div>


		<div class="content">
			<div id="step1" class="step">
				<div class="pages">
					<div class="form-div1">
						<ul>
							<li>
								<span>学生姓名：</span><input type="text" class="stud-name" placeholder="学生姓名"/>
							</li>
							<li>
								<span>学生年龄：</span><input type="text" class="stud-age" placeholder="学生的年龄"/>
							</li>
							<li>
								<span>性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
								 <span class="radio_box">
						               <input type="radio" id="radio_1" name="radio" value="man" checked>
						               <label for="radio_1"></label>
						               <em>男</em>
						         </span>
								<span class="radio_box">
						                <input type="radio" id="radio_2" name="radio" value="man">
						                <label for="radio_2"></label>
						                <em>女</em>
						        </span>
							</li>
							<li>
								<span>成绩水平：</span><input type="text" class="phone" placeholder="待提高/中等/优秀"/>
							</li>
							<li>
								<span>家庭住址：</span><input type="text" class="address" placeholder="家庭住址"/>
							</li>
							<li>
								<span>兴趣爱好：</span><input type="text" class="hobby" placeholder="学生的兴趣爱好"/>
							</li>
						</ul>
						
					</div>
				</div>
				
				<div class="pages">
					<div class="form-div1">
						<ul>
							<li>
								<span>就读学校：</span><input type="text" class="phone" placeholder="学生现就读于那个学校"/>
							</li>
							<li>
								<span>父母姓名：</span><input type="text" class="parent-name" placeholder="父亲或者母亲的名字"/>
							</li>
							<li>
								<span>联系方式：</span><input type="text" class="phone" placeholder="请填写联系方式"/>
							</li>
							<li>
								<span>备&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;注：</span>
								<textarea class="remarks" maxlength="100">
									
								</textarea>
							</li>
						</ul>
						<div class="buttonn">
							<button class="layui-btn layui-btn-normal">下一步</button>
						</div>
					</div>
				</div>
				
				
				
			</div>
			<div id="step2" class="step">
				<div class="jyTable">
					<div class="clearfix">
						<ul class="title title1 left">
							<li class='cur'>星期一</li>
							<li>星期二</li>
							<li>星期三</li>
							<li>星期四</li>
							<li>星期五</li>
							<li>星期六</li>
							<li>星期日</li>
						</ul>
					</div>
					<div class='zong'>
						<div class="list list1">
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s1">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
				
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s2">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s3">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
				
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s4">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
				
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s5">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
				
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s6">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
				
							<div class="tabCon">
								<ul>
									<li class="tabth clearfix">
										<span style="width: 13%">时间/上午</span>
										<span style="width: 12%">校区</span>
										<span style="width: 10%">教室</span>
										<span style="width: 16%">班级</span>
										<span style="width: 16%">课程内容</span>
										<span style="width: 16%">教员/班主任</span>
										<span style="width: 15%">操作</span>
									</li>
								</ul>
								<div id="s7">
									<ul class="tabUl">
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房一</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房二</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房三</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房四</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
										<li class="tabtr clearfix">
											<span style="width: 13%; color: #F7001E">2017-08-21</span>
											<span style="width: 12%;color: #AB9C08">东湖</span>
											<span style="width: 10%;color: #067D14">机房五</span>
											<span style="width: 15%">S2T110</span>
											<span style="width: 17%">上机</span>
											<span style="width: 17%">王喆单</span>
											<a style="width: 12%;color: #F7001E"><em class="clickbtn hot">查看</em></a>
										</li>
				
									</ul>
								</div>
							</div>
						</div>
						</div>
						<div class="buttons">
							<div class="but1"><button class="layui-btn layui-btn-normal">上一步</button></div>
							<div class="but2"><button class="layui-btn layui-btn-normal">下一步</button></div>
						</div>
						

			</div>
				
			</div>
			<div id="step3" class="step">
				<div class="step3-main1">
					<div class="Order-title">
						<img  src="/wms/resources/images/right.png"/>
						<span>xx订单创建成功，请仔细核对下面的订单信息</span>
					</div>
					<div class="Order-details">
							<ul class="order-header">
								<li><span>课程</span></li>
								<li><span>详情</span></li>
								<li><span>价格</span></li>
								<li><span>操作</span></li>
							</ul>
							<ul class="order-body">
								<li>
									<span>小学英语</span>
									<span>辅导小学英语</span>
									<span>200/课时</span>
									<span>删除</span>
								</li>
								<li>
									<span>小学英语</span>
									<span>辅导小学英语</span>
									<span>200/课时</span>
									<span>删除</span>
								</li>
								<li>
									<span>小学英语</span>
									<span>辅导小学英语</span>
									<span>200/课时</span>
									<span>删除</span>
								</li>
							</ul>
							
					</div>
					<div class="pays">
						<div class="layui-tab">
						  <ul class="layui-tab-title">
						    <li class="layui-this">合同管理</li>
						    <li>支付方式</li>
						    <li>票据管理</li>
						  </ul>
						  <div class="layui-tab-content">
						    <div class="layui-tab-item layui-show">
						    	<ul class="pay-ways">
						    		<li>
						    			<img alt="预览" src="/wms/resources/images/yulan.png">
							    		<br>
							    		<div class="pay-way-txt"><span>预览</span></div>
						    		</li>
						    		<li>
						    			<img alt="打印" src="/wms/resources/images/dayin.png">
							    		<br>
							    		<div class="pay-way-txt"><span>打印</span></div>
						    		</li>
						    	</ul>
						    </div>
						    <div class="layui-tab-item">
						    	<ul class="pay-ways">
						    		<li>
						    			<img alt="支付宝" src="/wms/resources/images/zhifubao.png">
							    		<br>
							    		<div class="pay-way-txt"><span>支付宝</span></div>
						    		</li>
						    		<li>
						    			<img alt="微信" src="/wms/resources/images/weixin.png">
							    		<br>
							    		<div class="pay-way-txt"><span>微信</span></div>
						    		</li>
						    		<li>
						    			<img alt="银行卡" src="/wms/resources/images/yinhangka.png">
							    		<br>
							    		<div class="pay-way-txt"><span>银行卡</span></div>
						    		</li>
						    		<li>
						    			<img alt="现金" src="/wms/resources/images/xianjin.png">
							    		<br>
							    		<div class="pay-way-txt"><span>现金</span></div>
						    		</li>
						    	</ul>
						    
						    </div>
						    <div class="layui-tab-item">
						    	<ul class="pay-ways">
						    		<li>
						    			<img alt="预览" src="/wms/resources/images/yulan.png">
							    		<br>
							    		<div class="pay-way-txt"><span>预览</span></div>
						    		</li>
						    		<li>
						    			<img alt="打印" src="/wms/resources/images/dayin.png">
							    		<br>
							    		<div class="pay-way-txt"><span>打印</span></div>
						    		</li>
						    		<li>
						    			<img alt="入账" src="/wms/resources/images/ruzhang.png">
							    		<br>
							    		<div class="pay-way-txt"><span>入账</span></div>
						    		</li>
						    	</ul>
						    </div>
						  </div>
						</div>
					</div>
				</div>
				<div class="step3-main2">
					<div class="invoice">
						<div class="invoice-div1">
							<span>订单详情</span>
						</div>
						<div class="invoice-div2">
							<ul class="dub-title1">	
								<li>订单号</li>
								<li>创建时间</li>
								<li>数量</li>
								<li>应付金额</li>
								<li>优惠金额</li>
								<li>实付金额</li>
								<li>支付方式</li>
								<li style="margin-top: 50px;font-size: 19px;font-weight:bold">总价</li>
							</ul>
							<ul class="dub-title2">	
								<li>2659852</li>
								<li>2018-07-30</li>
								<li>3</li>
								<li>￥1200.00</li>
								<li>￥200.00</li>
								<li>￥1000.00</li>
								<li>支付宝</li>
								<li style="margin-top: 50px;font-size: 19px;font-weight:bold">￥1000.00</li>
							</ul>
							
							
						</div>
					</div>
					 <div class="but">
						<button class="layui-btn layui-btn-normal">上一步</button>
					</div>
				</div>
			</div>
		</div>
</div>
	
 <script type="text/javascript" src="/wms/resources/js/pages/enterschool.js"></script>
<script type="text/javascript" src="/wms/resources/js/pages/tab.js"></script>
</body>
</html>