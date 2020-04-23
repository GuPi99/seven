<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
				<div class="layui-col-sm4">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>姓名 : </label>
						<div class="layui-input-block">
							<input type="text" name="sName" placeholder="请输入员工姓名" class="layui-input">
						</div>
						<div class="zyc_verify" data-name="s_name"></div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>联系电话 : </label>
						<div class="layui-input-block">
							<input type="tel" name="sPhone" placeholder="请输入员工联系电话" class="layui-input">
						</div>
						<div class="zyc_verify" data-name="s_phone"></div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>办公电话 : </label>
						<div class="layui-input-block">
							<input type="text" name="officePhone" placeholder="请输入办公电话 " class="layui-input">
						</div>
						<div class="zyc_verify" data-name="s_address"></div>
					</div>
				</div>
				<div class="layui-col-sm4">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>性别 : </label>
						<div class="layui-input-block">
							<select name="sSex">
								<option value="0">男</option>
								<option value="1">女</option>
							</select>
						</div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>联系邮箱 : </label>
						<div class="layui-input-block">
							<input type="email" name="sEmail" placeholder="请输入员工联系邮箱" class="layui-input">
						</div>
						<div class="zyc_verify" data-name="s_email"></div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>传真 : </label>
						<div class="layui-input-block">
							<input type="text" name="faxNum" placeholder="请输入传真" class="layui-input">
						</div>
						<div class="zyc_verify" data-name="s_address"></div>
					</div>
				</div>
				<div class="layui-col-sm4">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>出生年月 : </label>
						<div class="layui-input-block">
							<input type="text" name="sDateBirth" placeholder="请选择出生年月" class="layui-input date">
						</div>
						<div class="zyc_verify" data-name="s_date_birth"></div>
					</div>
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>现住址 : </label>
						<div class="layui-input-block">
							<input type="text" name="sAddress" placeholder="请输入员工现住址" class="layui-input">
						</div>
						<div class="zyc_verify" data-name="s_address"></div>
					</div>
				</div>
				<div class="layui-col-sm12">
					<div class="layui-tab" lay-filter="demo">
						<ul class="layui-tab-title">
							<li data-url="${pageContext.request.contextPath}/sevenOffice/index" class="layui-this">职位</li>
							<!--<li data-url="../loca/index.html">定位</li>-->
							<!-- <li data-url="../items/index.html">项目</li> -->
							<li data-url="${pageContext.request.contextPath}/sevenDaily/trend">动向</li>
						</ul>
						<div class="layui-tab-content" style="height: 600px;">
							<iframe class="zyc_iframe" width="100%" height="100%" src="" frameborder="0" seamless></iframe>
						</div>
					</div>
					<div style="position: absolute;top: 10px;right: 30px;">
						<input type="hidden" name="id" />
						<button type="button" class="layui-btn" id="zyc_edit">编辑</button>
						<button lay-filter="formDemo" lay-submit class="layui-btn" id="zyc_refer">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary" id="zyc_reset">重置</button>
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
			var SCOPE = {
				'selects': '../../json/menuselect.json', //上级菜单下拉框数据获取
				'operate': '${pageContext.request.contextPath}/sevenStaff/addSevenStaff', //数据提交接口
			}
			layui.use(['form', 'laydate', 'element'], function() {
				var form = layui.form,
					element = layui.element,
					laydate = layui.laydate;

				lay('.date').each(function() {
					laydate.render({
						elem: this,
						trigger: 'click'
					});
				});

				$(function() {
					//编辑赋值
					$.getUrlParam = function(name) { //获取路径中的参数
						var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
						var r = window.location.search.substr(1).match(reg);
						if (r != null) return unescape(r[2]);
						return null;
					}
					var id = $.getUrlParam('id'); //获取id
					if (id != '') {
						$('#zyc_refer').css('display', 'none');
						$('#zyc_reset').css('display', 'none');
						$('input').attr("disabled", "disabled");
						$('select').attr("disabled", "disabled");
						form.render('select');
						var ids = id;
					} else {
						var ids = $('input[name=id]').val();
						$('#zyc_edit').css('display', 'none');
					}
					$('.zyc_iframe').attr('src', $('.layui-tab-title>.layui-this').data('url') + '?id=' + ids);
					element.on('tab(demo)', function(data) {
						$('.zyc_iframe').attr('src', $(this).data('url') + '?id=' + id);
					});
					$('#zyc_edit').click(function() {
						$('input').removeAttr("disabled");
						$('select').removeAttr("disabled");
						$('#zyc_edit').css('display', 'none');
						$('#zyc_refer').css('display', 'inline-block');
						$('#zyc_reset').css('display', 'inline-block');
						form.render('select');
					})
				})
				//表单提交---提交表单后返回id主键
				form.on('submit(formDemo)', function(data) {
					//表单提交一次，禁止重复点击
					$(this).addClass('layui-btn-disabled');
					$(this).attr('disabled', 'disabled');
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
								$('input[name=id]').val(result.data);
								var msg = result.msg; //成功提示获取
								layer.msg(msg); //成功提示弹框
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
