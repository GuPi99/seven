<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>工作计划</title>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/plan/plan.css"/>
		<style>
			.layui-tab-content{
				padding: 0;
				padding-top: 20px;
			}
			#id{
				height: 500px !important;
			}
		</style>
	</head>
	<body>
		<!-- 页面内容——开始 -->
		<div class="planBlock">
			<div class="topBtn">
				<div class="addicon">
					<i class="left iconfont icon-jihua"></i>
					<div class="left"> 工作计划</div>
				</div>
			</div>
			<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
				<ul class="layui-tab-title">
					<li id="${pageContext.request.contextPath}/sevenDaily/selfDay" class="layui-this">日报</li>
					<li id="${pageContext.request.contextPath}/sevenDaily/selfWeek">周报</li>
					<li id="${pageContext.request.contextPath}/sevenDaily/selfMonth">月报</li>
				</ul>
				<div class="layui-tab-content">
					<div class="layui-tab-item layui-show" style="height: 500px">
						<iframe style="height:500px !important" id="open" class="planIf" name="" width="100%" height="100%" frameborder="0" src="${pageContext.request.contextPath}/sevenDaily/selfDay"></iframe>
					</div>
				</div>
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
				var url='${pageContext.request.contextPath}/sevenDaily/getSelfPlanList';
				search(url);
				planIf();
				element.on('tab(docDemoTabBrief)', function(data){
					var str=$(this).attr('id')
					var url=str
					$('.planIf').attr('src',url)
				});
				form.on('submit(search)',function(data){
					var date  = data.field.rDate;
					var title = data.field.rTitle;
					var str=url+'?dpDate='+date+'&dpEid='+title;
					search(str);
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
								,{field: 'dSid', title: '员工级别', width:'10%'}
								,{field: 'dDate', title: '工作计划日期', width:'20%'}
								,{field: 'dWork', title: '工作计划内容', width:'60%'} ,
								,{field: 'classify', title: '操作',toolbar:"#tool", width:'5%'}
							]]
					})
				}
				function planIf(){
					$(".planIf").load(function () {
						var mainheight = $(this).contents().find("body").height() + 30;
						$(this).height(mainheight);
					});
				}
			});
			
			//关闭所有弹框，并重新加载当前页面
			function cloae(){
				layer.closeAll();
				location.reload();
			}
		</script>
	</body>
</html>
