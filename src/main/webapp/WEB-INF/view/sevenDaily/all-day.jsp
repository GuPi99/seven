<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>菜单管理</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<!-- 图标文件引入 -->
		<!-- css公共样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/common.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/page.css" />
		<!-- layui框架css文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<!-- 表格样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/table.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/plan/plan.css"/>
		<style>
			.zyc_content{
				margin: 0;
				padding: 0;
			}
		</style>
</head>
<body>
<!-- 页面内容——开始 -->
		<div id="app">
			<div class="zyc_content">
				<!-- 页面内容：头部——查询框 开始 -->
				<!-- 页面内容：头部——开始 -->
				<ul class="zyc_query zyc_clear">
					<form class="layui-form" id="zyc_search" style="display: inline-block;">
						<!-- 页面内容：头部——查询框或下拉框 开始 -->
						<li>
							<div class="layui-form-item">
								<select name="dSid" id="dSid" >
									<option value="">请选择员工</option>
								</select> 
							</div>
						</li>
						
						<li>
							<div class="layui-form-item">
								 <input type="text" name="dDate" class="layui-input" id="date" placeholder="选择时间">
							</div>
						</li>
						<!-- 页面内容：头部——查询框或下拉框 结束 -->
						<li>
							<div class="layui-form-item">
								<button id="zyc_btn_search" lay-submit lay-filter="search" class="layui-btn layui-btn-normal">搜索 <i class="iconfont icon-chazhao"></i></button>
							</div>
						</li>
					</form>
				</ul>
				<!-- 页面内容：列表绑定——开始 -->
				<div class="zyc_table">
					<table id="demo" lay-filter="test"></table>
				</div>
				<!-- 页面内容：列表绑定——结束 -->
			</div>
		</div>
		<!-- 页面内容——结束 -->
		<!-- 列表：操作按钮绑定——开始 -->
		<script type="text/html" id="tool">
			<a class="layui-btn layui-btn-xs layui-btn-normal" lay-event="detail">查看</a>
		</script>
		<!-- 列表：操作按钮绑定——结束 -->
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			layui.use(['laydate','form','table','layer','element'], function(){
				var laydate = layui.laydate;
				var form    = layui.form;
				var table   = layui.table;
				var layer   = layui.layer;
				var element = layui.element;
					//执行一个laydate实例
				laydate.render({
					elem: '#date' //指定元素
				});
				$.ajax({
					url:'${pageContext.request.contextPath}/sevenStaff/selectAll',
					dataType:'json',
					success:function(res){
						var str='<option value=""></option>'
						res['data'].forEach(function(e){
							str+='<option value="'+e.id+'">'+e.sName+'</option>'
						})
						$('#dSid').html(str);
						form.render('select')
					}
				})
				var url='${pageContext.request.contextPath}/sevenDaily/getAllDayList';
				var data=new Object();
				data.dSid='';
			    data.dDate='';
				search(url,data);
				form.on('submit(search)',function(data){
					search(url,data.field);
					return false;
				})
				table.on('tool(test)', function(obj){
					var data = obj.data;
					if(obj.event === 'detail'){
						$("#open",parent.document).attr('src','${pageContext.request.contextPath}/sevenDaily/toDaySelect?id='+data.id);
					}
				});
				function search(url,data){
					table.render({
						elem: '#demo'
						,height: 418
						,url:url
						,page: true
						,method: 'get'
						,where: data
						,cols: [[ //表头
								{field: 'id', title: 'ID', width:'5%', sort: true}
								,{field: 'staffName', title: '员工级别', width:'10%'}
								,{field: 'dDate', title: '工作计划日期', width:'20%'}
								,{field: 'dWork', title: '工作计划内容', width:'60%'} ,
								,{field: 'classify', title: '操作',toolbar:"#tool", width:'5%'}
							]]
					})
				}
			});
		</script>
</body>
</html>