<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticc/css/index/head.css"/>
</head>
<body>
<div class="header">
			<div class="headTitle">
				<div class="iconBlock left">
					<i class="iconfont icon-shezhi"></i>
				</div>
				<div class="nameBlock left">
					<span>设置头像</span>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="bodyer">
			<form class="layui-form" action="">
				<div class="layui-form-item left">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>头像 : </div>
					</label>
					<div class="layui-input-block">
						<button type="button" class="layui-btn layui-btn-normal" id="test1">
							<i class="layui-icon">&#xe67c;</i>上传图片
						</button>
					</div>
				</div>
				<div class="headImg left">
					<img id="headImg" src="${pageContext.request.contextPath}/static/img/empty.png"/>
				</div>
				<div class="clear"></div>
				<div class="layui-form-item">
					<label class="layui-form-label">
						<div class="titleBg"><span>*</span>昵称 : </div>
					</label>
					<div class="layui-input-block">
						 <input id="name" type="text" name="aNickname" placeholder="请输入昵称" autocomplete="off" class="layui-input">
					</div>
				</div>
				<div class="addBtn">
					<input type="hidden" name="_method" value="put">
					<input type="hidden" id="aPid" name="aPid" value="" />
					<button lay-filter="formDemo" lay-submit class="layui-btn layui-btn-normal">
						提交
					</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</form>
		</div>
		<script src="${pageContext.request.contextPath}/staticc/js/common/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/staticc/js/common/layui/layui.all.js"></script>
	<script>
		layui.use(['upload','form'], function(){
			var form    = layui.form;
			var upload = layui.upload;
			var uploadInst = upload.render
			var uploadInst = upload.render({
				elem: '#test1' //绑定元素
				,url: '${pageContext.request.contextPath}/sevenPrint/addSevenPrint' //上传接口
				,done: function(res){
					if(res.status==0){
						//上传完毕回调
						var str="${pageContext.request.contextPath}/"+res.src; 
						$('#aPid').val(res.data);
						$("#headImg").attr('src',str);
					}
				}
				,error: function(){
				  //请求异常回调
				}
			});
			var url='${pageContext.request.contextPath}/sevenAccount/updateNowSevenAccount'
				form.on('submit(formDemo)', function(data){
				    $.ajax({
				    	type: "post",
				    	url:url,
						data: data.field,
						async:false,
						dataType: 'json',
				     success:function(res){
				      if(res.status==0){
				    	  var msg = res.msg;//成功提示获取
							layer.msg(msg);//成功提示弹框
							//成功后，300毫秒关闭弹框，重新加载列表页面（对应列表页面cloae方法）
							setTimeout(function() {
								var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
						        parent.location.reload();//刷新父页面，注意一定要在关闭当前iframe层之前执行刷新
						        parent.layer.close(index); //再执行关闭
							}, 300)
 				      }else{
 				    	//获取错误提示
							var msg = res.msg;
							//弹框提示
							layer.msg(msg);
 				      }
				     }
				    })
				    return false;
				   })
		})
	</script>
	</body>
</html>