<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>客户拜访记录</title>
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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/visit/add.css"/>
	</head>
	<body>
		<!-- 页面内容——开始 -->
		<div id="app">
			<!-- 表单——开始 -->
			<form class="layui-form" lay-filter="formTest">
				<!-- 提交按钮——开始 -->
				<div class="topBtn">
					<div class="addicon">
						<i class="iconfont icon-baifang"></i>
					</div>
					<div class="btn">
						<button lay-filter="formDemo" lay-submit class="layui-btn">提交</button>
					</div>
					<div class="clear"></div>
				</div>
				<!-- 提交按钮——结束 -->
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>拜访日期 : </div>
					</label>
					<div class="layui-input-block rili">
						<div class="riliIcon">
							<i class="iconfont icon-rili"></i>
						</div>
						<input type="text" name="rDate" class="layui-input" id="test1">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>项目名称 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="text" name="rTitle" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>同行人员 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="text" name="rCrew" placeholder="请输入同行人员" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>拜访公司 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="text" name="rFirm" placeholder="请输入拜访公司" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>最终用户 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="text" name="rUser" placeholder="请输入最终用户" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>目的 / 背景 : </div>
					</label>
					<div class="layui-input-block">
						 <textarea name="rGoal" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>结论 / 结果 : </div>
					</label>
					<div class="layui-input-block">
						 <textarea name="rVerdict" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>拜访记录 : </div>
					</label>
					<div class="layui-input-block">
						 <textarea name="rRecord" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>下次活动 : </div>
					</label>
					<div class="layui-input-block">
						 <textarea name="rActivity" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>需协助事项 : </div>
					</label>
					<div class="layui-input-block">
						 <textarea name="rAssist" placeholder="请输入内容" class="layui-textarea"></textarea>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>内部联络 : </div>
					</label>
					<div class="layui-input-block">
						 <textarea name="rContact" placeholder="请输入内容" class="layui-textarea"></textarea>
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
			layui.use(['laydate','form'], function(){
				var laydate = layui.laydate;
				var form    = layui.form;
				laydate.render({
					elem: '#test1' //指定元素
				});
				form.on('submit(formDemo)', function(data){
					var url='${pageContext.request.contextPath}/sevenReport/addSevenReport'
					add(url,data.field)
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
