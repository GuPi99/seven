<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>SIMCO订单管理系统</title>
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
	</head>
	<body>
		<!-- 页面内容——开始 -->
		<div id="app">
			<div class="zyc_content">
				<!-- 页面内容：头部——开始 -->
				<!-- 页面内容：头部——按钮组 开始 -->
				<ul class="zyc_clear zyc_handle">
					<li><button id="zyc_add" class="layui-btn layui-btn-normal"><i class="iconfont iconxinzeng"></i>职位调动</button></li>
				</ul>
				<!-- 页面内容：头部——按钮组 结束 -->
				<!-- 页面内容：头部——结束 -->
				<!-- 页面内容：列表绑定——开始 -->
				<div class="zyc_table">
					<table id="demo" lay-filter="test"></table>
				</div>
				<!-- 页面内容：列表绑定——结束 -->
			</div>
		</div>
		<!-- 页面内容——结束 -->
		<!-- 列表：操作按钮绑定——开始 -->
		<script type="text/html" id="zyc_btn">
			<a class="layui-btn layui-btn-xs layui-btn-danger" title="删除" href="#" lay-event="delete">删除</a>
		</script>
		<!-- 列表：操作按钮绑定——结束 -->
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<!-- 页面操作js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/spost/load.js"></script>
		<script>
			var SCOPE = {
				'table_url': '${pageContext.request.contextPath}/sevenOffice/getSevenOfficeList', //列表数据查询来源（json文件或接口地址，可自行修改）；模糊搜索查询接口地址（menu指当前控制器，selects指查询方法，可自行修改）
				'add_url': '${pageContext.request.contextPath}/sevenOffice/toAdd',					  //新增页面跳转路径（menu指当前控制器，add指页面或控制器方法，可自行修改）
				'cancel': '${pageContext.request.contextPath}/sevenOffice/deleteSevenOffice',                  //数据删除方法接口
			}
			//关闭所有弹框，并重新加载当前页面
			function cloae(){
				layer.closeAll();
				location.reload();
			}
		</script>
	</body>
</html>
