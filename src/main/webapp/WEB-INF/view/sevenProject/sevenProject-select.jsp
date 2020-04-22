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
				<div class="layui-col-sm4">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>客户 : </label>
						<div class="layui-input-block">
							<select name="pFid">
							</select>
						</div>
						<div class="zyc_verify" data-name="p_fid"></div>
					</div>
				</div>
				<div class="layui-col-sm4">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>生效条件 : </label>
						<div class="layui-input-block">
							<input type="text" name="pConditions" placeholder="请输入生效条件" class="layui-input">
						</div>
						<div class="zyc_verify" data-name="p_conditions"></div>
					</div>
				</div>
				<div class="layui-col-sm4">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>拟定日期 : </label>
						<div class="layui-input-block">
							<input type="text" name="pDate" placeholder="请选择拟定日期" class="layui-input date">
						</div>
						<div class="zyc_verify" data-name="p_date"></div>
					</div>
				</div>
				<div class="layui-col-sm12">
					<div class="layui-form-item">
						<label class="layui-form-label">备注 : </label>
						<div class="layui-input-block" style="width: 80%;">
							<textarea name="pNote" placeholder="请输入备注" class="layui-textarea"></textarea>
						</div>
						<div class="zyc_verify" data-name="p_note"></div>
					</div>
				</div>
				<div class="layui-col-sm12">
					<div class="layui-tab" lay-filter="demo">
						<ul class="layui-tab-title">
							<li data-url="${pageContext.request.contextPath}/sevenProjectGoods/index" class="layui-this">产品需求</li>
							<li data-url="${pageContext.request.contextPath}/sevenProjectFile/index">项目文件</li>
							<li data-url="${pageContext.request.contextPath}/sevenProjectFundPlan/index">资金计划</li>
							<li id="know" data-url="${pageContext.request.contextPath}/sevenProjectCheck/index">项目审批进度</li>
							<li id="progress" data-url="${pageContext.request.contextPath}/sevenProjectSchedule/index">项目进度</li>
							<li id="ticket" data-url="${pageContext.request.contextPath}/sevenProjectBill/index">开票</li>
							<li id="report" data-url="${pageContext.request.contextPath}/sevenProjectReport/index">报告</li>
						</ul>
						<div class="layui-tab-content" style="height: 600px;">
							<iframe class="zyc_iframe" width="100%" height="100%" src="" frameborder="0" seamless></iframe>
						</div>
					</div>
					<div style="position: absolute;top: 10px;right: 30px;">
						<input type="hidden" name="id" />
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
				'selects': '${pageContext.request.contextPath}/sevenFirm/selectAll', //下拉框数据获取
				'operate': '${pageContext.request.contextPath}/sevenProject/addSevenProject', //数据提交接口
				'value': '${pageContext.request.contextPath}/sevenProject/selectSevenProjectById', //编辑时，获取单一数据接口，用以展示编辑数据
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
					var state = $('input[name=pc_state]').val();
					if(state == 0){
						$('#know').css('display','none');
						$('#progress').css('display','none');
						$('#ticket').css('display','none');
						$('#report').css('display','none');
						$('#zyc_button').css('display','none');
					}
					//数据获取
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
								var li = [];
								$(datas).each(function(i){
									li.push('<option value="'+datas[i].id+'">'+datas[i].fName+'</option>');
								})
								var lis = li.join("");
								$('select[name=pFid]').html(lis);
								form.render('select');
							} else {
								var msg = result.msg;
								layer.msg(msg);
							}
						},
					});
					//编辑赋值
					$.getUrlParam = function(name) { //获取路径中的参数
						var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
						var r = window.location.search.substr(1).match(reg);
						if (r != null) return unescape(r[2]);
						return null;
					}
					var id = $.getUrlParam('id'); //获取id
					var stste = $.getUrlParam('state'); //获取state
					if (stste > 0) {
						$('#zyc_refer').css('display', 'none');
						$('#zyc_reset').css('display', 'none');
						$('#zyc_button').css('display', 'none');
						$('input').attr("disabled", "disabled");
						$('select').attr("disabled", "disabled");
						$('textarea').attr("disabled", "disabled");
						form.render('select');
					}
					$('.zyc_iframe').attr('src', $('.layui-tab-title>.layui-this').data('url') + '?id=' + id + '&state=' + stste);
					element.on('tab(demo)', function(data) {
						$('.zyc_iframe').attr('src', $(this).data('url') + '?id=' + id + '&state=' + stste);
					});
					var postId = {};
					postId['id'] = id;
					$.ajax({
						type: "get",
						url: SCOPE.value,
						data: postId,
						dataType: 'json',
						success: function(result) {
							if (result.status == 0) {
								var datas = result.data;
								form.val("formTest", datas);//表单赋值
								$("select[name=pFid]").val(datas.pFid);//下拉框赋值
								form.render('select'); //下拉框重新渲染
							} else {
								var msg = result.msg;
								layer.msg(msg);
							}
						},
					});
				})
			})
			//关闭所有弹框，并重新加载当前页面
			function cloae(){
				layer.closeAll();
				location.reload();
			}
		</script>
	</body>
</html>
