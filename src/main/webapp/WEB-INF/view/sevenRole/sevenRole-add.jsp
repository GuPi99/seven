<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>SIMCO订单管理系统</title>
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
		<style>
			html,body{
				background-color: #fff;
			}
			#app{
				padding: 15px;
			}
			.layui-form-item{
				position: relative;
			}
			.layui-form-item .zyc_verify{
				position: absolute;
				top: 0;
				left: 350px;
				font-size: 13px;
				line-height: 30px;
			}
		</style>
	</head>
	<body>
		<!-- 页面内容——开始 -->
		<div id="app">
			<!-- 表单——开始 -->
			<form class="layui-form" lay-filter="formTest">
				<div class="layui-col-sm6">
				
				<!-- 表单XX信息——开始 -->
				<div class="layui-form-item">
					<!-- *表示必填，非必填项可将span标签删除 -->
					<label class="layui-form-label"><span>*</span>角色名称 : </label>
					<!-- 输入框或下拉框 -->
					<div class="layui-input-block">
						<input type="text" name="rName" placeholder="请输入角色名称" class="layui-input">
					</div>
					<!-- 验证信息展示处，data-name对应验证数据 -->
					<div class="zyc_verify" data-name="r_name"></div>
				</div>
				<!-- 表单XX信息——结束 -->
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>角色描述 : </label>
					<div class="layui-input-block">
						<textarea name="rDescribe" placeholder="请输入角色描述" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_describe"></div>
				</div>
				
				<!-- 提交按钮——开始 -->
				<div class="layui-form-item">
					<div class="layui-input-block">
						<input type="hidden" name="id" />
						<button lay-filter="formDemo" lay-submit class="layui-btn">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				<!-- 提交按钮——结束 -->
				</div>
				<div class="layui-col-sm6">
					<div id="test1"></div>
					<div class="zyc_verify" data-name="r_permissions"></div>
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
			var SCOPE = {
				'selects': '${pageContext.request.contextPath}/sevenMenus/selectMenus',//菜单权限数据获取
				'operate': '${pageContext.request.contextPath}/sevenRole/addSevenRole',//数据提交接口
			}
			layui.use(['form', 'laydate', 'upload', 'tree'], function() {
				var form = layui.form,
					laydate = layui.laydate,
					tree = layui.tree,
					upload = layui.upload;

				$(function() {
					//菜单权限数据获取
					var postData = {};
					postData['superior'] = 1;//后端接口同一个方法用以区分是否为表单数据
					$.ajax({
						type: "get",
						url: SCOPE.selects,
						data: postData,
						dataType: 'json',
						success: function(result) {
							if (result.status == 0) {
								var datas = result.data;
								//树状图赋值展示，它有自己的数据结构，请参照layui开发文档(数据结构需在接口中重新分配)
								tree.render({
									elem: '#test1',
									data: datas,
									showCheckbox: true,
									id: 'demoId',
									isJump: true,
								});
								
							} else {
								var msg = result.msg;
								layer.msg(msg);
							}
						},
					});
					//编辑赋值
					$.getUrlParam = function(name) {//获取路径中的参数
						var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
						var r = window.location.search.substr(1).match(reg);
						if (r != null) return unescape(r[2]);
						return null;
					}
					//为便于展示，进行注销；开发时，请解除注销进行开发
					 var id = $.getUrlParam('id');//获取id
					 var postId = {};
					 postId['id'] = id;
					 $.ajax({
					 	type: "post",
					 	url: SCOPE.value,
					 	data: postId,
					 	dataType: 'json',
					 	success: function(result) {
					 		if (result.status == 0) {
					 			var datas = result.data;
					 			form.val("formTest", datas);//表单赋值
					 			tree.reload('demoId', {//树形图赋值
					 				data: datas.datas,
					 			});
					 			form.render();//表单重新渲染
							} else {
								var msg = result.msg;
					 			layer.msg(msg);
					 		}
					 	},
					 });
				})
				//表单提交
				form.on('submit(formDemo)', function(data) {
					//表单提交一次，禁止重复点击
					$(this).addClass('layui-btn-disabled');
					$(this).attr('disabled','disabled');
					//提交数据，data获取的表单数据
					var that = $(this);
					var checkData = tree.getChecked('demoId');
					var permissions = new Array();
					$(checkData).each(function() {
						permissions.push(this.id);
						if (this.children) {
							$(this.children).each(function() {
								permissions.push(this.id);
								$(this.children).each(function() {
									permissions.push(this.id);
								})
							})
						}
					})
					data.field.rPermissions = permissions.join(',');

					$.ajax({
						type: "post",
						url: SCOPE.operate,
						data: data.field,
						dataType: 'json',
						success: function(result) {
							//操作成功，状态（status）返回0
							if (result.status == 0) {
								var msg = result.msg;//成功提示获取
								layer.msg(msg);//成功提示弹框
								//成功后，300毫秒关闭弹框，重新加载列表页面（对应列表页面cloae方法）
								setTimeout(function() {
									window.parent.cloae();
								}, 300)
							} else if (result.status == 2) { //批量验证数据错误
								//解除提交按钮禁止点击
								that.removeClass('layui-btn-disabled');
								that.removeAttr('disabled');
								//获取批量错误提示
								var errors = result.msg;
								//获取表单提示信息展示位置，并进行对应展示
								$('.zyc_verify').each(function() {
									var errorMsg = errors[$(this).data('name')];
									$(this).html(errorMsg != undefined ? '*' + errorMsg : '').css(
										'cssText', 'color: red !important'
									);
								});
							} else { //其它错误，弹框提示
								//解除提交按钮禁止点击
								that.removeClass('layui-btn-disabled');
								that.removeAttr('disabled');
								//获取错误提示
								var msg = result.msg;
								//弹框提示
								layer.msg(msg);
							}
						}

					});
					return false;
				});
			})
		</script>
	</body>
</html>
