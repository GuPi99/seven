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
					<label class="layui-form-label"><span>*</span>日期 : </label>
					<div class="layui-input-block">
						<input type="text" name="rDate" placeholder="请输入日期" class="layui-input date">
					</div>
					<div class="zyc_verify" data-name="r_date"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>同行人员 : </label>
					<div class="layui-input-block">
						<input type="text" name="rCrew" placeholder="请输入同行人员" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="r_crew"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>项目名称 : </label>
					<div class="layui-input-block">
						<input type="text" name="rTitle" placeholder="请输入项目名称" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="r_title"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>拜访公司 : </label>
					<div class="layui-input-block">
						<input type="text" name="rFirm" placeholder="请输入拜访公司" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="r_firm"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>最终用户 : </label>
					<div class="layui-input-block">
						<input type="text" name="rUser" placeholder="请输入最终用户" class="layui-input">
					</div>
					<div class="zyc_verify" data-name="r_user"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>目的/背景 : </label>
					<div class="layui-input-block">
						<textarea name="rGoal" rows="4" placeholder="请输入目的/背景" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_goal"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>结论/结果 : </label>
					<div class="layui-input-block">
						<textarea name="rVerdict" rows="4" placeholder="请输入结论/结果" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_verdict"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>访谈记录 : </label>
					<div class="layui-input-block">
						<textarea name="rRecord" rows="4" placeholder="请输入访谈记录" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_record"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>下次活动 : </label>
					<div class="layui-input-block">
						<textarea name="rActivity" rows="4" placeholder="请输入下次活动" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_activity"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>需协助事项 : </label>
					<div class="layui-input-block">
						<textarea name="rAssist" rows="4" placeholder="请输入需协助事项" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_assist"></div>
				</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>营业部内部联络 : </label>
					<div class="layui-input-block">
						<textarea name="rContact" rows="4" placeholder="请输入营业部内部联络" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_contact"></div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>上级的指示和安排: </label>
					<div class="layui-input-block">
						<textarea name="rIndicate" rows="4" placeholder="上级的指示和安排" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_indicate"></div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label"><span>*</span>关联人员回复 : </label>
					<div class="layui-input-block">
						<textarea name="rReply" rows="4" placeholder="关联人员回复" class="layui-textarea"></textarea>
					</div>
					<div class="zyc_verify" data-name="r_replyact"></div>
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
				'operate': '${pageContext.request.contextPath}/sevenReport/addSevenRepost',//数据提交接口
				'value': '${pageContext.request.contextPath}/sevenReport/selectSevenReport',//编辑时，获取单一数据接口，用以展示编辑数据
			}
			layui.use(['form', 'laydate'], function() {
				var form = layui.form,
					laydate = layui.laydate;
				
				var myDate = new Date();  //获取当前时间
				lay('.date').each(function() {
					laydate.render({
						elem: this,
						trigger: 'click',
						max:myDate.toLocaleString()
					});
				});
				
				$(function() {
					//编辑赋值
					$.getUrlParam = function(name) {//获取路径中的参数
						var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
						var r = window.location.search.substr(1).match(reg);
						if (r != null) return unescape(r[2]);
						return null;
					}
					var id = $.getUrlParam('id');//获取id
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
							} else {
								var msg = result.msg;
								layer.msg(msg);
							}
						},
					});
				})
				
			})
		</script>
	</body>
</html>
