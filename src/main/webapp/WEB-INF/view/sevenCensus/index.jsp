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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/demand/index.css"/>
</head>
<body>
<div class="header">
			<div class="headTitle">
				<div class="iconBlock left">
					<i class="iconfont icon-jihua"></i>
				</div>
				<div class="nameBlock left">
					<span>部门需求</span>
					<span><i class="iconfont icon-arr"></i></span>
					<span>数据统计</span>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
			<ul class="layui-tab-title">
				<li id="${pageContext.request.contextPath}/sevenCensus/indexSj" class="layui-this">数据统计</li>
				<li id="${pageContext.request.contextPath}/sevenCensus/indexXq">业务需求</li>
				<li>发布公告</li>
			</ul>
			<div class="layui-tab-content"></div>
		</div>
		<div class="layui-tab-content">
			<div class="layui-tab-item layui-show">
				<iframe class="planIf" name="" width="100%" height="100%" frameborder="0" src="${pageContext.request.contextPath}/sevenCensus/indexSj"></iframe>
			</div>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			layui.use(['form','element'], function(){
				var form    = layui.form;
				var element = layui.element;
				element.on('tab(docDemoTabBrief)', function(data){
					var str=$(this).attr('id')
					var url=str
					$('.planIf').attr('src',url);
				});
				planIf();
				function planIf(){
					$(".planIf").load(function () {
						var mainheight = $(this).contents().find("body").height() + 30;
						$(this).height(mainheight);
					});
				}
			})
		</script>
</body>
</html>