$(function(){
	
	//初始化打开开设课程表格
	initOpenCourseTable();
	
	//打开添加课程窗口
	$("#add_course").click(function(){
		
		//alert(new Date().Format("yyyy-MM-dd"));
		addCourse();
	})
	
	
	
});

//点击添加按钮添加供应商
function addCourse(){
			
			var addCourse='<div class="courses">'+
					'<div class="course1">'+
						'<form style="margin-left:10px;" action="">'+
						 ' <p>'+
							'<label for="course_name">课&nbsp;&nbsp;程&nbsp;&nbsp;名：</label>'+
								'<select id="course_name">'+
									'<option value="">请选择课程</option>'+
									'<option value="Chinese">语文</option>'+
									'<option value="maths">数学</option>'+
									'<option value="English">英语</option>'+
									'<option value="Politics">政治</option>'+
									'<option value="History">历史</option>'+
									'<option value="Geography">地理</option>'+
									'<option value="Physics">物理</option>'+
									'<option value="Chemistry">化学</option>'+
									'<option value="Biology">生物</option>'+
									'<option value="All">全科</option>'+
								'</select>'+
							'<span class="course_name_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="course_class">年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;级：</label>'+
							'<select id="course_class">'+
								'<option value="">请选择年级</option>'+
								'<option value="Kindergarten">幼儿园</option>'+
								'<option value="first_grade">一年级</option>'+
								'<option value="second_grade">二年级</option>'+
								'<option value="three_grade">三年级</option>'+
								'<option value="fourth_grade">四年级</option>'+
								'<option value="fifth_grade">五年级</option>'+
								'<option value="six_grade">六年级</option>'+
								'<option value="junior_one">初一</option>'+
								'<option value="junior_two">初二</option>'+
								'<option value="junior_three">初三</option>'+
							'</select>'+
							'<span class="course_class_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="course_type">课程类型：</label>'+
							'<select id="course_type">'+
								'<option value="">请选择课程类型</option>'+
								'<option value="01">晚托班</option>'+
								'<option value="02">寒暑假辅导班</option>'+
								'<option value="03">仅周末辅导</option>'+
								'<option value="04">平时（周一到周五）</option>'+
								'<option value="05">冲刺班</option>'+
								'<option value="06">平时加周末</option>'+
								'<option value="07">一对一</option>'+
								'<option value="00">全科</option>'+
							'</select>'+
							'<span class="course_type_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="course_time">每节时长：</label>'+
							'<input type="text" id="course_time" class="inputbox" name="course_time" placeholder="每节课多少分钟，请输入正整数(分钟)" />'+
							'<span class="course_time_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="class_hour">每期课时：</label>'+
							'<input type="text" id="class_hour" class="inputbox" name="class_hour" placeholder="每期多少个课时，请输入正整数" />'+
							'<span class="class_hour_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="course_teacher">任课老师：</label>'+
							'<input type="text" id="course_teacher" class="inputbox" name="course_teacher" placeholder="请输入姓名" />'+
							'<span class="course_teacher_waring"></span>'+
						'</p>'+
						'<p>'+
							'<label for="course_detail">课程描述：</label>'+
							'<input type="text" id="course_detail" class="inputbox" name="course_detail" placeholder="介绍一下该课程或者套餐" />'+
							'<span class="course_detail_waring"></span>'+
						'</p>'+
						'<p>'+
							 '<label for="if_package">是否套餐：</label>'+
							 '<span class="radio_box">'+
							               '<input onclick="opentext()" type="radio" id="radio_package" name="radio_package" value="yes" checked>'+
							               '<label for="radio_package"></label>'+
							               '<em>是</em>'+
							  '</span>'+
							  '<span class="radio_box">'+
							                '<input onclick="closetext()" type="radio" id="radio_package2" name="radio_package" value="no">'+
							                '<label for="radio_package2"></label>'+
							                '<em>不是</em>'+
							  '</span>'+
						'</p>'+
						'<p>'+
							'<label for="pachage_name">套&nbsp;&nbsp;餐&nbsp;&nbsp;名：</label>'+
							'<input type="text" class="inputbox" id="pachage_name" name="pachage_name" placeholder="如：A套餐" />'+
							'<span class="pachage_name_waring"></span>'+
						'</p>'+
						'</form>'+
					'</div>'+
					'<div class="course2">'+
						'<form style="margin-left:10px;" action="">'+
							'<p>'+
								'<label for="course_cost_stud">学生付款：</label>'+
								'<input type="text" class="inputbox" id="course_cost_stud" name="course_cost_stud" placeholder="学生每节课时费" />'+
								'<span class="course_cost_stud_waring"></span>'+
							'</p>'+
							'<p>'+
								'<label for="course_cost_teach">教师付款：</label>'+
								'<input type="text" class="inputbox" id="course_cost_teach" name="course_cost_teach" placeholder="老师每节课时费" />'+
								'<span class="course_cost_teach_waring"></span>'+
							'</p>'+
							'<p>'+
								'<label for="course_discount">优惠金额：</label>'+
								'<input type="text" class="inputbox" id="course_discount" name="course_discount" placeholder="活动优惠金额" />'+
								'<span class="course_discount_waring"></span>'+
							'</p>'+
							'<p>'+
								'<label for="course_activity">活动描述：</label>'+
								'<input type="text" class="inputbox" id="course_activity" name="course_activity" placeholder="描述该优惠活动" />'+
								'<span class="course_activity_waring"></span>'+
							'</p>'+
							'<p>'+
								'<label for="course_cost_total_stud">学生应付：</label>'+
								'<input type="text" class="inputbox" id="course_cost_total_stud" name="course_cost_total_stud" placeholder="课时和学生课时费总和" />'+
								'<span class="course_cost_total_stud_waring"></span>'+
							'</p>'+
							'<p>'+
								'<label for="course_cost_total_teach">教师应付：</label>'+
								'<input type="text" class="inputbox" id="course_cost_total_teach" name="course_cost_total_teach" placeholder="课时和老师课时费总和" />'+
								'<span class="course_cost_total_teach_waring"></span>'+
							'</p>'+
							'<p>'+
								'<label for="actual_cost_stud">实际应付：</label>'+
								'<input type="text" class="inputbox" id="actual_cost_stud" name="actual_cost_stud" placeholder="学生应付总和减去优惠金额" />'+
								'<span class="actual_cost_stud_waring"></span>'+
							'</p>'+
						'</form>'+
					'</div>'+
				'</div>';
					
					
				
				
				
				layer.open({
				title: ['开设课程', 'font-size:16px;'],
				skin:'layui-layer-molv',
				type: 1,
				area: ['700px', '580px'],
				content: addCourse, //这里content是一个普通的String
				btn: ['添加', '取消'],
				yes: function(index, layero){
					
					//常用js正则验证
					//00代表不为空验证   01代表正整数验证  02代表姓名验证  03代表金額的验证
					myRegx("course_name","course_name_waring","00");
					myRegx("course_type","course_type_waring","00");
					myRegx("course_class","course_class_waring","00");
					myRegx("course_time","course_time_waring","01");
					myRegx("class_hour","class_hour_waring","01");
					myRegx("course_teacher","course_teacher_waring","02");
					myRegx("course_cost_stud","course_cost_stud_waring","03");
					myRegx("course_cost_teach","course_cost_teach_waring","03");
					myRegx("course_discount","course_discount_waring","03");
					myRegx("course_cost_total_stud","course_cost_total_stud_waring","03");
					myRegx("course_cost_total_teach","course_cost_total_teach_waring","03");
					myRegx("actual_cost_stud","actual_cost_stud_waring","03");
					//特殊正则验证 字符范围位数验证
					myRegxforString("course_detail","course_detail_waring","2","20");
					myRegxforString("pachage_name","pachage_name_waring","1","5");
					myRegxforString("course_activity","course_activity_waring","4","20");
				
					var data={
							"course_name":$("#course_name").val(),
							"course_class":$("#course_class").val(),
							"course_type":$("#course_type").val(),
							"course_time":$("#course_time").val(),
							"class_hour":$("#class_hour").val(),
							"course_teacher":$("#course_teacher").val(),
							"course_detail":$("#course_detail").val(),
							"if_package":$("input[name='radio_package']:checked").val(),
							"pachage_name":$("#pachage_name").val(),
							
							"course_cost_stud":$("#course_cost_stud").val(),
							"course_cost_teach":$("#course_cost_teach").val(),
							"course_discount":$("#course_discount").val(),
							"course_activity":$("#course_activity").val(),
							"course_cost_total_stud":$("#course_cost_total_stud").val(),
							"course_cost_total_teach":$("#course_cost_total_teach").val(),
							"actual_cost_stud":$("#actual_cost_stud").val(),
					}
					
					
					
					
			
				/*$.ajax({
				type:"post",
				url:"/wms/addCourse",
				data:data,
				success:function (data) {
					for(var p in data){
							if(p=="true"){
					    		//添加成功后刷新表格
					        	$("#openCourseTable").bootstrapTable('refresh', {url: '/wms/queryAllOpenedCourse' });
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
				});*/
				
				
				},
				btn2: function(index, layero){
					
					
					layer.close(index);
					//return false 开启该代码可禁止点击该按钮关闭
					}
				});
}

//选择是套餐后显示填写套餐名的输入框
function opentext(){
	$(".pachage_name_p").show();
}
function closetext(){
	$(".pachage_name_p").hide();
}

//删除开设的课程
function deleteOpenCourse(thisID){
	alert($(thisID).attr("data-value"));
}



