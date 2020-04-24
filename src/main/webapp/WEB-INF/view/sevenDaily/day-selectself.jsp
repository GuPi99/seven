<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/plan/adday.css"/>
</head>
<body>
<!-- 页面内容——开始 -->
		<div id="app">
			<!-- 表单——开始 -->
			<form class="layui-form" lay-filter="formTest">
				<div class="btn">
			     	<button lay-filter="formDemo" lay-submit class="layui-btn">返回</button>
			    </div>
				<div class="layui-form-item" style="width: 640px">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>报告日期 : </div>
					</label>
					<div class="layui-input-block rili" style="width: 500px">
						<input type="text" name="dDate" disabled class="layui-input" id="time">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>计划内容 : </div>
					</label>
					<div  class="layui-input-block" class="desc"  id="desc" style="width: 480px;border: 1px solid #ededed;line-height: 30px;padding: 0 10px;height: 150px">
					</div>
				</div>
			</form>
			<!-- 表单——结束 -->
		</div>
		<!-- 页面内容——结束 -->
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			layui.use(['laydate','form','layedit'], function(){
				var layedit = layui.layedit;
				var id=getid('id');
				var form=layui.form;
				var url='${pageContext.request.contextPath}/sevenDaily/getSelectDay?id='+id;
				form.on('submit(formDemo)',function(){
				     $("#open",parent.document).attr('src','${pageContext.request.contextPath}/sevenDaily/selfDay');
				     return false;
				})
				$.ajax({
					url:url,
					dataType:'json',
					success:function(str){
						$('#time').val(str['data']['dDate']);
						$('#desc').html(str['data']['dWork'])
					}
				})
				function getid(name){
					 var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
					 var r = window.location.search.substr(1).match(reg);
					 if(r!=null)return  unescape(r[2]); return null;
				}
			})
		</script>
</body>
</html>