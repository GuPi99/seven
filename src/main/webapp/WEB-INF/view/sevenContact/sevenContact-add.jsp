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
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>所属公司 : </label>
					<div class="layui-input-block">
						<select name="cFid">
							<option value=""></option>
						</select>
					</div>
					<div class="zyc_verify" data-name="c_fid"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>姓名 : </label>
					<div class="layui-input-block">
						<input type="text" name="cName" placeholder="请输入联系人姓名" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="c_name"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>性别 : </label>
					<div class="layui-input-block">
						<select name="cSex">
							<option value="0">男</option>
							<option value="1">女</option>
						</select>
					</div>
					<div class="zyc_verify" data-name="c_sex"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>年龄 : </label>
					<div class="layui-input-block">
						<input type="number" name="cAge" placeholder="请输入联系人年龄" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="c_age"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>电话 : </label>
					<div class="layui-input-block">
						<input type="tel" name="cPhone" placeholder="请输入电话号码" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="c_phone"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>邮箱 : </label>
					<div class="layui-input-block">
						<input type="text" name="cEmail" placeholder="请输入邮箱地址" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="c_email"></div>
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
				'selects': '${pageContext.request.contextPath}/sevenFirm/selectAll',//下拉框数据获取
				'operate': '${pageContext.request.contextPath}/sevenContact/addSevenContact',//数据提交接口
			}
			layui.use(['form', 'laydate'], function() {
				var form = layui.form,
					laydate = layui.laydate;
				
				$(function() {
					//下拉框数据获取
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
								var li = ['<option value="0">无</option>'];
								$(datas).each(function(i){
									li.push('<option value="'+datas[i].id+'">'+datas[i].fName+'</option>');
								})
								var lis = li.join("");
								$('select[name=cFid]').html(lis);
								form.render('select');
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
