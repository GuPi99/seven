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
					</div>
				</div>
			</form>
		</div>
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			var SCOPE = {
				'value' :  '${pageContext.request.contextPath}/sevenEvection/selectSevenEvection'
			}
			layui.use(['form', 'laydate', 'element'], function() {
				var form = layui.form,
					element = layui.element,
					laydate = layui.laydate;

				$(function() {
					//编辑赋值
					$.getUrlParam = function(name) { //获取路径中的参数
						var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
						var r = window.location.search.substr(1).match(reg);
						if (r != null) return unescape(r[2]);
						return null;
					}
					var id = $.getUrlParam('id'); //获取id
					if(id == ''){
						$('#know').css('display','none');
						$('.zyc_iframe').attr('src', $('.layui-tab-title>.layui-this').data('url') + '?id=' + id);
						element.on('tab(demo)', function(data) {
							$('.zyc_iframe').attr('src', $(this).data('url') + '?id=' + id);
						});
					}
					
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
								console.log(datas)
								form.val("formTest", datas);//表单赋值
								form.render();
								var state = $('input[name=eState]').val();
								if(state != '' && state > 0){
									$('#zyc_refer').css('display','none');
									$('#zyc_reset').css('display','none');
								}
								if(state != 3){
									$('#know').css('display','none');
								}
								$('.zyc_iframe').attr('src', $('.layui-tab-title>.layui-this').data('url') + '?id=' + id + '&state=' + state);
								element.on('tab(demo)', function(data) {
									$('.zyc_iframe').attr('src', $(this).data('url') + '?id=' + id + '&state=' + state);
								});
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
