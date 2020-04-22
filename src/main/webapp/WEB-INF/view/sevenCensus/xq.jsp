<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
<style>
			#app{
				width: 1200px;
				margin: 0 auto;
			}
			.left{
				float: left;
			}
			.right{
				float: right;
			}
			.clear{
				clear: both;
			}
			*{
				padding: 0;
				margin: 0;
			}
			a{
				text-decoration: none;
			}
			li{
				list-style:none
			}
			.header{
				height: 36px;
				line-height: 36px;
				background: #E3E3E3;
				padding: 5px 0;
			}
			.iconBlock{
				padding-left: 20px;
				padding-right: 10px;
			}
			.icon-jihua{
				font-size: 24px;
				color: #0183E6;
			}
			.layui-form-item{
				height: 28px;
				width: 300px;
				clear: initial;
			}
			.layui-input-block{
				min-height: 28px;
				height: 28px;
				margin-left: 30px;
			}
			.tooler input{
				height: 28px;
			}
			.rili{
				position:relative
			}
			#test1{
				padding-left: 30px
			}
			.riliIcon{
				position: absolute;
				top: 7px;
				left: 10px;
				color: #1C9EFE;
			}
			.tooler{
				padding: 30px 0;
			}
			.searchBlock{
				margin-left: 30px;
			}
			.searchBlock .layui-btn{
				height: 28px;
				line-height: 28px;
				display: block;
				border-radius: 8px;
			}
			.addBtn .layui-btn{
				height: 28px;
				line-height: 28px;
				display: block;
				border-radius: 8px;
				margin-right: 100px;
			}
			.icon-chazhao{
				padding-left: 5px;
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
		</style>
</head>
<body>
<div class="tooler">
			<form class="layui-form" action="">
				<div class="layui-form-item left">
					<div class="layui-input-block">
						<input type="text" name="rTitle" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="searchBlock left">
					<button lay-filter="formDemo" lay-submit class="layui-btn layui-btn-normal">
						搜索<i class="iconfont icon-chazhao"></i>
					</button>
				</div>
				<div class="clear"></div>
			</form>
		</div>
		<div class="tabler">
			<table id="demo" lay-filter="test"></table>
		</div>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
	<script>
		layui.use(['laydate','form','table','layer'], function(){
			var laydate = layui.laydate;
			var form    = layui.form;
			var table   = layui.table;
			var layer   = layui.layer;
			laydate.render({
				elem: '#test1' //指定元素
			});
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
			var url='${pageContext.request.contextPath}/sevenBusiness/getSevenBusinessList';
			search(url);
			function search(url){
				table.render({
					elem: '#demo'
					,height: 418
					,url:url
					,page: true
					,cols: [[ //表头
							{field: 'id', title: '资料种类', width:'5%', sort: true}
							,{field: 'title', title: '公文标题', width:'20%'}
							,{field: 'dispathNumber', title: '发文工号', width:'15%'}
							,{field: 'draftName', title: '拟稿人', width:'20%'} 
							,{field: 'draftDate', title: '拟稿日期', width: '20%'}
							,{field: 'readStatus', title: '查看状态', width: '20%'}
						]]
				})
			}
		})
	</script>
</body>
</html>