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
					<button lay-filter="formDemo" lay-submit class="layui-btn">保存</button>
				</div>
				<div class="layui-form-item" style="width: 640px">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>报告日期 : </div>
					</label>
					<div class="layui-input-block rili" style="width: 500px">
						<div class="riliIcon">
							<i class="iconfont icon-rili"></i>
						</div>
						<input type="text" name="dDate" class="layui-input" id="test1">
					</div>
				</div>
				<div class="layui-form-item">
					<textarea id="content" lay-verify="content" name="dWork" ></textarea>
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
				var laydate = layui.laydate;
				var form    = layui.form;
				var layedit = layui.layedit;
				layedit.set({
					uploadImage: {
						url: 'upload' //接口url
						,type: 'post' //默认post
					}
				});
				var index=layedit.build('content'); //建立编辑器
				laydate.render({
					elem: '#test1' ,//指定元素
				});
				form.on('submit(formDemo)', function(data){
					$(this).addClass('layui-btn-disabled');
					$(this).attr('disabled','disabled');
					var str=new Object();
					str.dWork=layedit.getContent(index);
					str.dType=1;
					str.dDate=data.field.dDate;
					var url='${pageContext.request.contextPath}/sevenDaily/addSevenDaily'
					add(url,str);
					return false;
				})
				function add(url,data){
					var url=url;
					$.ajax({
						url:url,
						data:data,
						type:'post',
						dataType:'json',
						success:function(res){
							if(res.status==0){
								layer.msg('添加成功');
								setTimeout(function() {
									var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
									parent.location.reload();//刷新父页面，注意一定要在关闭当前iframe层之前执行刷新
									parent.layer.close(index); //再执行关闭
								}, 300)
							}else if(res.status==3){
								layer.msg(res.msg)
							}
						}
					})
				}
			})
		</script>
</body>
</html>