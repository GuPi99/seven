<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>菜单管理</title>
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
		<!-- 表单公共样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form/staff.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/form/form.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<style>
			.planBlock{
				padding: 10px 0;
				border: 1px solid #E6E6E6;
				position: relative;
			}
			.planTitle{
				width: 20px;
				padding: 0 20px;
				text-align: center;
				height: 76px;
				position: absolute;
				top: 50%;
				margin-top: -38px;
			}
			.tableBlock{
				margin-left: 60px;
				text-align: center;
			}
			.btn{
				margin-left: 60px;
				margin-top: 30px;
			}
			.btn button{
				height: 28px;
				line-height: 28px;
				border-radius: 8px;
			}
			#table tr{
				height: 36px;
				line-height: 36px;
			}
			#text{
				width: 400px;
				height: 100px;
			}
			.xsbtn{
				margin: 10px 0;
			}
			.xsbtn a{
				height: 28px;
				line-height: 28px;
				border-radius: 8px;
			}
			.w1200{
				width: 1200px;
				table-layout: fixed;
			}
			td{
				white-space: nowrap;
				text-overflow: ellipsis;
				overflow: hidden;
			}
			.w60{
				width: 60px;
			}
			.w140{
				width: 140px;
			}
			.w200{
				width: 200px;
			}
		</style>
</head>
<body>
	<div class="planBlock">
			<div class="planTitle">计划内容</div>
			<div class="tableBlock">
				<table class="layui-table w1200">
					<thead>
						<tr>
							<th class="w60">序号</th>
							<th class="w200">客户名称</th>
							<th class="w200">项目名称</th>
							<th class="w200">项目内容</th>
							<th class="w200">时间安排</th>
							<th class="w200">陪同人</th>
							<th class="w140">备注</th>
						</tr>
					</thead>
					<tbody id="table">
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
						<tr>
							<td class="w60"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w200"></td><td class="w140"></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="btn">
			<button class="layui-btn layui-btn-normal" id="formDemo">立即提交</button>
		</div>
		<div id="text"  style="display: none;">
			<form class="layui-form" lay-filter="formTest">
				<textarea name="desc" placeholder="请输入内容" class="layui-textarea"></textarea>
				<div class="xsbtn">
					<a lay-filter="add" lay-submit class="layui-btn layui-btn-xs layui-btn-normal">保存</a>
				</div>
			</form>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			layui.use(['form','layer'], function(){
				var form	=layui.form;
				var layer	=layui.layer;
				$('#table td').on('click',function(){
					var dom=$(this);
					var dimStr=dom.text();
					text(dimStr);
					form.on('submit(add)',function(data){
						var str=data.field.desc;
						dom.text(str);
						return false
					})
				})
				function text(dimStr){
					$('textarea').val(dimStr);
					layer.open({
					  type: 1,
					  area: ['400px', '200px'],
					  content: $('#text'),
					  cancel: function(index, layero){ 
							$('textarea').val('');
							layer.close(index)
						}
					});
				}
				$('#formDemo').on('click',function(){
					$(this).addClass('layui-btn-disabled');
					$(this).attr('disabled', 'disabled');
					var data=new Object();
					data.str=$('#table').html();
					var url='';
					$.ajax({
						url:url,
						data:data,
						type:'post',
						dataType:'json',
						success:function(str){
							if(str.status==0){
								layer.msg('已提交');
								setTimeout(function() {
									$("#open",parent.document).attr('src','../../page/plan/week.html');
								})
							}
						}
					})
				})
			})
			
		</script>
	</body>
</body>
</html>