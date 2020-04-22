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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index/pwd.css" />
</head>
<body>
<div class="header">
			<div class="headTitle">
				<div class="iconBlock left">
					<i class="iconfont icon-xiugai"></i>
				</div>
				<div class="nameBlock left">
					<span>修改密码</span>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="bodyer">
			<form class="layui-form" action="">
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>原密码 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="password" name="paw" placeholder="请输入原密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>新密码 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="password" name="paws" placeholder="请输入新密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>确认密码 : </div>
					</label>
					<div class="layui-input-block">
						 <input type="password" name="pawss" placeholder="请输入新密码" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="addBtn">
					<button lay-filter="formDemo" lay-submit class="layui-btn layui-btn-normal">
						提交
					</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</form>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
	<script>
		layui.use('form', function(){
			var form    = layui.form;
			form.on('submit(formDemo)', function(data){
				data.field
				$.ajax({
					url:'${pageContext.request.contextPath}/sevenAccount/updatePassword',
					data:data.field,
					type:'post',
					async: false,
					dataType:'json',
					success:function(res){
						if(res.status==0){
							var msg = res.msg;//成功提示获取
							layer.msg(msg);//成功提示弹框
							//成功后，300毫秒关闭弹框，重新加载列表页面（对应列表页面cloae方法）
							setTimeout(function() {
								top.location.href="${pageContext.request.contextPath}/sevenAccount/logout"
							}, 300)		
						}else if(res.status==1){
							//获取错误提示
							var msg = res.msg;
							//弹框提示
							layer.msg(msg);
						}
					}
				})
				return false;
			});
		})
	</script>
	</body>
</body>
</html>