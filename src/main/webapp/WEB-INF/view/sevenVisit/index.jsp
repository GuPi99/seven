<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>出差申请访问客户</title>
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
		<style>
			.layui-form-item{
				height: 26px;
				width: 230px;
			}
			.layui-form-item input{
				height: 100%;
			}
			.layui-form-item button{
				height: 100%;
				line-height: 26px;
				border-radius: 8px;
			}
			#zyc_add span{
				margin-right: 20px;
				display: inline-block;
			}
			.layui-table-view,
			.layui-table-header{
				border: 0;
			}
			.layui-table-view th{
				border: 0;
			}
			.layui-table thead tr{
				background: #DEF1FB;
			}
			.layui-table-tool{
				border: 0;
			}
			.layui-table tbody td{
				border-right: 0;
			}
			.layui-table-view .layui-table{
				text-align: center;
			}
		</style>
	</head>
	<body>
			<body>
		<!-- 页面内容——开始 -->
		<div id="app">
			<div class="zyc_content">
				<div class="headBlock">
					<div></div>
				</div>
				<!-- 页面内容：头部——查询框 开始 -->
				<!-- 页面内容：头部——开始 -->
				<ul class="zyc_query zyc_clear">
					<form class="layui-form" id="zyc_search" style="display: inline-block;">
						<!-- 页面内容：头部——查询框或下拉框 开始 -->
						<li>
							<div class="layui-form-item">
								 <input type="text" name="rDate" class="layui-input" id="date" placeholder="选择时间">
							</div>
						</li>
						<li>
							<div class="layui-form-item">
								<input type="text" name="rTitle" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
							</div>
						</li>
						<li>
							<div class="layui-form-item">
								<button id="zyc_btn_search" lay-submit lay-filter="search" class="layui-btn layui-btn-normal">搜索 <i class="iconfont iconchazhao"></i></button>
								<button id="zyc_add" lay-submit lay-filter="add" class="layui-btn layui-btn-normal">
									<span>
										添加报告
									</span>
									<i class="iconfont iconxinzeng"></i>
								</button>
							</div>
						</li>
						<!-- 页面内容：头部——查询框或下拉框 结束 -->
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
			layui.use(['laydate','form','table','layer'], function(){
				var laydate = layui.laydate;
				var form    = layui.form;
				var table   = layui.table;
				var layer   = layui.layer;
					//执行一个laydate实例
				laydate.render({
					elem: '#date' //指定元素
				});
				var url='${pageContext.request.contextPath}/sevenVisit/getSevenVisitList';
				search(url);
				form.on('submit(search)',function(data){
					var date  = data.field.rDate;
					var title = data.field.rTitle;
					var str=url+'?rDate='+date+'&rTitle='+title;
					search(str);
					return false;
				})
				form.on('submit(add)',function(data){
					layer.open({
						type: 2,
						content:'add.html',
						area : ['1200px', '800px'],
						maxmin : true,
						title : '添加报告'
					})
					return false;
				})
				table.on('tool(test)', function(obj){
					var data = obj.data;
					var url='check.html?id='+data.id;
					if(obj.event === 'detail'){
						layer.open({
							type: 2,
							content:url,
							area : ['1200px', '800px'],
							maxmin : true,
							title : '查看报告'
						})
					}
				});
				function search(url){
					table.render({
						elem: '#demo'
						,height: 418
						,url:url
						,page: true
						,cols: [[ //表头
								{field: 'id', title: 'ID', width:'5%', sort: true}
								,{field: 'rSid', title: '员工级别', width:'10%'}
								,{field: 'rDate', title: '报告日期', width:'15%'}
								,{field: 'rCrew', title: '同行人员', width:'15%'} 
								,{field: 'rTitle', title: '项目名称', width: '20%'}
								,{field: 'rFirm', title: '拜访公司', width: '15%'}
								,{field: 'rUser', title: '最终用户', width: '15%'}
								,{field: 'classify', title: '操作',toolbar:"#tool", width: '5%'}
							]]
					})
				}
			});
			
			//关闭所有弹框，并重新加载当前页面
			function cloae(){
				layer.closeAll();
				location.reload();
			}
		</script>
		<script>
			
		</script>
	</body>
	</body>
</html>
