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
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/need/add.css"/>
</head>
<body>
<form class="layui-form" action="">
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
					<div class="addBtn right">
						<button lay-filter="formDemo" lay-submit class="layui-btn layui-btn-normal">
							提交
						</button>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="bodyer">
				<div class="layui-form-item left">
					<div class="layui-input-block">
						<select name="productId" id="name" lay-verify="required"></select>
					</div>
				</div>
				<div class="layui-form-item left">
					<div class="layui-input-block">
						<select name="cSid" id="staff" lay-verify="required"></select>
					</div>
				</div>
				<div class="clear"></div>
				<div class="inputBlock">
					<div class="layui-form-item">
						<label class="layui-form-label">
							<div class="titleBg"><span>*</span>销售额 : </div>
						</label>
						<div class="layui-input-block">
							 <input type="text" name="saleVolume" placeholder="请输入销售额" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">
							<div class="titleBg"><span>*</span>本月回款 : </div>
						</label>
						<div class="layui-input-block">
							 <input type="text" name="monthMoney" placeholder="请输入本月回款" autocomplete="off" class="layui-input">
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label">
							<div class="titleBg"><span>*</span>销售数量 : </div>
						</label>
						<div class="layui-input-block">
							 <input type="text" name="saleNumber" placeholder="请输入销售数量" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
			</div>
		</form>
		
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			layui.use(['laydate','form'], function(){
				var laydate = layui.laydate;
				var form    = layui.form;
				laydate.render({
					elem: '#test1' //指定元素
				});
				form.on('submit(formDemo)',function(data){
					var url="${pageContext.request.contextPath}/sevenCensus/addSevenCensus"
					$(this).addClass('layui-btn-disabled');
					$(this).attr('disabled', 'disabled');
					$.ajax({
						url:url,
						data:data.field,
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
							}
						}
					})
					return false
				})
				$.ajax({
					url:'${pageContext.request.contextPath}/sevenGoods/selectAll',
					dataType:'json',
					success:function(res){
						var str='<option value=""></option>'
						res.forEach(function(e){
							str+='<option value="'+e.id+'">'+e.gName+'</option>'
						})
						$('#name').html(str);
						form.render('select')
					}
				})
				$.ajax({
					url:'${pageContext.request.contextPath}/sevenStaff/selectAll',
					dataType:'json',
					success:function(res){
						var str='<option value=""></option>'
						res['data'].forEach(function(e){
							str+='<option value="'+e.id+'">'+e.sName+'</option>'
						})
						$('#staff').html(str);
						form.render('select')
					}
				})
			})
			
		</script>
	</body>
</body>
</html>