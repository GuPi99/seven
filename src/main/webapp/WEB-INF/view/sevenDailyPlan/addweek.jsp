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
				height: 333px;
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
		</style>
</head>
<body>
<div class="planBlock">
			<div class="planTitle">计划内容</div>
			<div class="tableBlock">
				<table class="layui-table" lay-data="{url:'${pageContext.request.contextPath}/json/weekMode.json', id:'text'}" lay-filter="text">
					<thead>
						<tr>
							<th lay-data="{field:'id', width:'6%', edit: 'text'}">星期</th>
							<th lay-data="{field:'name', width:'10%', edit: 'text'}">客户名称</th>
							<th lay-data="{field:'title', width:'10%', edit: 'text'}">项目名称</th>
							<th lay-data="{field:'content', width:'34%', edit: 'text'}">项目内容</th>
							<th lay-data="{field:'time', width:'15%', edit: 'text'}">时间安排</th>
							<th lay-data="{field:'user', width:'10%', edit: 'text'}">陪同人</th>
							<th lay-data="{field:'dome', width:'15%', edit: 'text'}">备注</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>
		<div class="btn">
			<button class="layui-btn layui-btn-normal" lay-submit lay-filter="formDemo">立即提交</button>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
		layui.use('table', function(){
			var table = layui.table;
			//监听单元格编辑
			table.on('edit(text)', function(obj){
				var value = obj.value //得到修改后的值
				,data = obj.data //得到所在行所有键值
				,field = obj.field; //得到字段
			});
		});
		</script>
	</body>
</body>
</html>