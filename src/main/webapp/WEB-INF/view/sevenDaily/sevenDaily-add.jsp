<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>员工工作报告</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- 图标文件引入 -->
		<link rel="stylesheet" href="http://at.alicdn.com/t/font_1242623_rd4735gfmt.css" />
		<!-- css公共样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/common.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/page.css" />
		<!-- layui框架css文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<!-- 表格样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/table.css" />
		<!-- 表单公共样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form/staff.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form/form.css" />
	</head>
	<body>
		<!-- 页面内容——开始 -->
		<div id="app">
			<div class="zyc_content">
				<!-- 表单——开始 -->
				<form class="layui-form" lay-filter="formTest">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>报告类型 : </label>
						<div class="layui-input-block">
							<select name="dType" lay-filter="type">
								<option value="1">日报</option>
								<option value="2">月报</option>
								<option value="3">季报</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item" id="date" style="display: block;">
						<label class="layui-form-label"><span>*</span>日期 : </label>
						<div class="layui-input-block">
							<input type="text" name="d_date1" placeholder="请输入日期" class="layui-input date">
						</div>
						<div class="zyc_verify" data-name="d_date"></div>
					</div>
					<div class="layui-form-item" id="month" style="display: none;">
						<label class="layui-form-label"><span>*</span>月份 : </label>
						<div class="layui-input-block">
							<input type="text" name="d_date2" placeholder="请输入月份" class="layui-input dates">
						</div>
						<div class="zyc_verify" data-name="d_date"></div>
					</div>
					<div class="layui-form-item" id="quarter" style="display: none;">
						<label class="layui-form-label"><span>*</span>季度 : </label>
						<div class="layui-input-block">
							<select name="d_date3">
								
							</select>
						</div>
						<div class="zyc_verify" data-name="d_date"></div>
					</div>
					<div class="layui-form-item">
						<textarea id="demo"></textarea>
					</div>
				<!-- 提交按钮——开始 -->
					<div class="layui-form-item">
						<div class="layui-input-block">
							<input type="hidden" name="id" />
							<button lay-filter="formDemo" lay-submit class="layui-btn">立即提交</button>
							<button type="reset" class="layui-btn layui-btn-primary">重置</button>
						</div>
					</div>
					<!-- 提交按钮——结束 -->
				</form>
				<!-- 表单——结束 -->
			</div>
		</div>
		<!-- 页面内容——结束 -->
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			var SCOPE = {
				'operate': '${pageContext.request.contextPath}/sevenDaily/addSevenDaily'
			}
			layui.extend({
				tinymce: '${pageContext.request.contextPath}/static/js/common/layui_exts/tinymce/tinymce'
			}).use(['tinymce', 'util', 'form', 'laydate', 'layedit', 'upload'], function() {
				var form = layui.form,
					laydate = layui.laydate,
					tinymce = layui.tinymce,
					util = layui.util,
					layedit = layui.layedit,
					upload = layui.upload;
				
				var myDate = new Date();  //获取当前时间
				lay('.date').each(function() {
					laydate.render({
						elem: this,
						trigger: 'click',
						max:myDate.toLocaleString()
					});
				});
				
				lay('.dates').each(function() {
					laydate.render({
						elem: this,
						type: 'month',
						trigger: 'click',
						max:myDate.toLocaleString()
					});
				});
				
				var year = myDate.getFullYear();
				var month = myDate.getMonth();
				var years = [];
				if(month <= 2){
					for(var i=1; i<2; i++){
						years[i] = year+'<option>第'+i+'季度</option>';
					}
				}else if(2 < month <= 5){
					for(var i=1; i<3; i++){
						years[i] = year+'<option>第'+i+'季度</option>';
					}
				}else if(5 < month <= 8){
					for(var i=3; i<4; i++){
						years[i] = year+'<option>第'+i+'季度</option>';
					}
				}else if(8 < month <= 11){
					for(var i=4; i<5; i++){
						years[i] = year+'<option>第'+i+'季度</option>';
					}
				}
				$('#quarter select').html(years.join(''));
				form.render('select');
				
				form.on('select(type)', function(data){
				  if(data.value == 1){
					  $('#date').css('display','block');
					  $('#month').css('display','none');
					  $('#quarter').css('display','none');
				  }else if(data.value == 2){
					  $('#month').css('display','block');
					  $('#date').css('display','none');
					  $('#quarter').css('display','none');
				  }else if(data.value == 3){
					  $('#quarter').css('display','block');
					  $('#month').css('display','none');
					  $('#date').css('display','none');
				  }
				});      
				
				var edit = tinymce.render({
					elem: "#demo",
					height: 500
				});
			
				form.on('submit(formDemo)', function(data) {
					$(this).addClass('layui-btn-disabled');
					$(this).attr('disabled', 'disabled');
					var that = $(this);
					data.field.dWork = edit.getContent();
					if(data.field.dType == 1){
						data.field.dDate = data.field.d_date1;
					}else if(data.field.dType == 2){
						data.field.dDate = data.field.d_date2;
					}else if(data.field.dType == 3){
						data.field.dDate = data.field.d_date3;
					}
					$.ajax({
						type: "post",
						url: SCOPE.operate,
						data: data.field,
						dataType: 'json',
						success: function(result) {
							if (result.status == 0) {
								var msg = result.msg;
								layer.msg(msg);
								setTimeout(function() {
									window.parent.cloae();
								}, 300)
							} else {
								that.removeClass('layui-btn-disabled');
								that.removeAttr('disabled');
								var msg = result.msg;
								layer.msg(msg);
							}
						}
				
					});
					return false;
				});
			})
			
		</script>
	</body>
</html>
