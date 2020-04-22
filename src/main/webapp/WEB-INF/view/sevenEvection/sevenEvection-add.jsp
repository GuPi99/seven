<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>出差申请</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/travel/index.css"/>
		<style>
			#id{
				height: 500px;
			}
		</style>
	</head>
	<body>
		<div id="app" style="width: 1200px; margin: 0 auto;">
			<form class="layui-form" lay-filter="formTest">
				<!-- 提交按钮——开始 -->
				<div class="topBtn">
					<div class="addicon left">
						<i class="iconfont icon-chucha"></i>
					</div>
					<div class="btn right">
						<button lay-filter="formDemo" lay-submit class="layui-btn">提交</button>
					</div>
					<div class="clear"></div>
				</div>
				<!-- 提交按钮——结束 -->
				<div class="top">
					<div class="layui-form-item left">
						<label class="layui-form-label">
							<div class="titleBg"><span>*</span>项目名称 : </div>
						</label>
						<div class="layui-input-block">
							 <input type="text" name="eGoal" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item left">
						<label class="layui-form-label">
							<div><span>*</span>出差日期 : </div>
						</label>
						<div class="layui-input-block rili">
							<div class="riliIcon">
								<i class="iconfont icon-rili"></i>
							</div>
							<input type="text" name="estimatedDate" class="layui-input test1" id="test1">
						</div>
					</div>
					<div class="clear"></div>
				</div>
				<div class="footer">
					<div class="footTitle">
						<label class="layui-form-label">
							<div class="titleBg">日程 : </div>
						</label>
						<div class="clear"></div>
					</div>
					
					<div id="date">
						<div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div class="titleBg"><span>*</span>开始日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="add1" class="layui-input test1" id="add1">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>结束日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="end1" class="layui-input test1" id="end1">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>拜访客户 : </div>
								</label>
								<div class="layui-input-block">
									 <input type="text" name="name1" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>拜访目的 : </div>
								</label>
								<div class="layui-input-block">
									 <input type="text" name="title1" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div class="titleBg"><span>*</span>开始日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="add2" class="layui-input test1" id="add2">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>结束日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="end2" class="layui-input test1" id="end2">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>拜访客户 : </div>
								</label>
								<div class="layui-input-block">
									 <input type="text" name="name2" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>拜访目的 : </div>
								</label>
								<div class="layui-input-block">
									 <input type="text" name="title2" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div class="titleBg"><span>*</span>开始日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="add3" class="layui-input test1" id="add3">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>结束日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="end3" class="layui-input" id="end3">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>拜访客户 : </div>
								</label>
								<div class="layui-input-block">
									 <input type="text" name="name3" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div><span>*</span>拜访目的 : </div>
								</label>
								<div class="layui-input-block">
									 <input type="text" name="title3" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
						<div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<div class="titleBg"><span>*</span>开始日期 : </div>
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="add4" class="layui-input test1" id="add4">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<span>*</span>结束日期 : 
								</label>
								<div class="layui-input-block rili">
									<div class="riliIcon">
										<i class="iconfont icon-rili"></i>
									</div>
									<input type="text" name="end4" class="layui-input test1" id="end4">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<span>*</span>拜访客户 : 
								</label>
								<div class="layui-input-block">
									 <input type="text" name="name4" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item left">
								<label class="layui-form-label">
									<span>*</span>拜访目的 : 
								</label>
								<div class="layui-input-block">
									 <input type="text" name="title4" placeholder="请输入项目名称" autocomplete="off" class="layui-input">
								</div>
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
	<!-- layui框架js文件 -->
	<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
	<script>
		layui.use(['laydate','form'], function(){
			var laydate = layui.laydate;
			var form    = layui.form;
			var myDate = new Date(); //获取当前时间
			lay('.test1').each(function() {
				laydate.render({
					elem: this,
					trigger: 'click',
					min: myDate.toLocaleString()
				});
			});
			form.on('submit(formDemo)', function(data){
				data.field.eText=$('#date').html();
				var str=new Object();
					str.eGoal=data.field.eGoal;
					str.estimatedDate=data.field.estimatedDate;
					str.eText=data.field.eText; 
				$.ajax({
					url:'${pageContext.request.contextPath}/sevenEvection/addSevenEvection',
					data:str,
					type:'post',
					dataType:'json',
					success:function(res){
						if(res.status==0){
							layer.msg(res.msg)
							setTimeout(function() {
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
								parent.location.reload();//刷新父页面，注意一定要在关闭当前iframe层之前执行刷新
								parent.layer.close(index); //再执行关闭
							}, 300)
						}else{
							layer.msg(res.msg)
						}
					}
				})
				return false
			})
		})
		</script>
	</body>
</html>
