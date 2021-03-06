<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>客户访问报告</title>
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
				<!-- 页面内容：头部——查询框 开始 -->
				<ul class="zyc_query zyc_clear">
					<form class="layui-form" id="zyc_search" style="display: inline-block;">
						<!-- 页面内容：头部——查询框或下拉框 开始 -->
						<li>
							<div class="layui-form-item">
								<select name="rSid" lay-filter="caidan" lay-search>
									<option value="">全部员工</option>
								</select>
							</div>
						</li>
						<li>
							<div class="layui-form-item">
								<input type="text" name="rDate" placeholder="请选择日期" autocomplete="off" class="layui-input date">
							</div>
						</li>
						<li>
							<div class="layui-form-item">
								<input type="text" name="rTitle" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
							</div>
						</li>
						<!-- 页面内容：头部——查询框或下拉框 结束 -->
					</form>
					<!-- 页面内容：头部——查询按钮 开始 -->
					<li>
						<div class="layui-form-item">
							<button id="zyc_btn_search" class="layui-btn"><i class="iconfont iconchazhao"></i></button>
						</div>
					</li>
					<!-- 页面内容：头部——查询按钮 结束 -->
				</ul>
				<!-- 页面内容：头部——查询框 结束 -->
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
			{{#  if(d.rReply == null){ }}
			<a class="layui-btn layui-btn-xs" title="回复" href="#" lay-event="reply">回复</a>
			{{#  } }}
		</script>
		<!-- 列表：操作按钮绑定——结束 -->
		<!-- jquery文件 -->
		<!-- 列表：操作按钮绑定——结束 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<!-- 页面操作js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/access/load.js"></script>
		<script>
			var SCOPE = {
				'table_url': '${pageContext.request.contextPath}/sevenReport/getSevenReportList', //列表数据查询来源（json文件或接口地址，可自行修改）；模糊搜索查询接口地址（menu指当前控制器，selects指查询方法，可自行修改）
				'selects': '${pageContext.request.contextPath}/sevenStaff/selectAll',                 //模糊搜索下拉框数据方法接口
				'operate': '${pageContext.request.contextPath}/sevenReport/addReply',              //数据操作方法，如需增加多个方法，可在load.js中进行修改
			}
		</script>
	</body>
</html>
