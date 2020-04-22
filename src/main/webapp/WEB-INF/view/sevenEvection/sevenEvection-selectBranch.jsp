<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<title>出差部门审批</title>
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
				<div class="layui-col-sm12">
					<div class="layui-form-item">
						<label class="layui-form-label"><span>*</span>目的 : </label>
						<div class="layui-input-block" style="width: 80%;">
							<textarea name="eGoal" placeholder="请输入出差目的" class="layui-textarea"></textarea>
						</div>
						<div class="zyc_verify" data-name="e_goal"></div>
					</div>
				</div>
			</form>
			<!-- 表单——结束 -->
			<div class="layui-col-sm12">
				<div class="layui-tab" lay-filter="demo">
					<ul class="layui-tab-title">
						<li data-url="${pageContext.request.contextPath}/sevenVisit/index" class="layui-this">访问客户</li>
							<li data-url="${pageContext.request.contextPath}/sevenPlan/index">行程安排</li>
							<li data-url="${pageContext.request.contextPath}/sevenEvection/toView">审批进度</li>
						<li id="know" data-url="../business/index.html">出差报告</li>
					</ul>
					<div class="layui-tab-content" style="height: 600px;">
						<iframe class="zyc_iframe" width="100%" height="100%" src="" frameborder="0" seamless></iframe>
					</div>
				</div>
				<div style="position: absolute;top: 10px;right: 30px;">
					<button class="layui-btn" id="zyc_refer">审批</button>
				</div>
			</div>
		</div>
		<!-- 页面内容——结束 -->
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script>
			var SCOPE = {
				'value': '${pageContext.request.contextPath}/sevenEvection/selectSevenEvection', //编辑时，获取单一数据接口，用以展示编辑数据
				'know': '${pageContext.request.contextPath}/sevenEvection/branchKnow', 
			}
			layui.use(['form', 'laydate', 'element'], function() {
			    var form = layui.form,
			     element = layui.element,
			     laydate = layui.laydate;
			    
			    $.getUrlParam = function(name) { //获取路径中的参数
			     var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
			     var r = window.location.search.substr(1).match(reg);
			     if (r != null) return unescape(r[2]);
			     return null;
			    }
			    var id = $.getUrlParam('id'); //获取id
			    
			    $(function() {
			     //编辑赋值
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
			        $('textarea').attr('disabled','disabled');
			        if(datas.eState != 0){
			         $('#zyc_refer').css('display','none');
			        }
			        if(datas.eState < 4){
			         $('#know').css('display','none');
			        }
			        $('.zyc_iframe').attr('src', $('.layui-tab-title>.layui-this').data('url') + '?id=' + id + '&type=1');
			        element.on('tab(demo)', function(data) {
			         $('.zyc_iframe').attr('src', $(this).data('url') + '?id=' + id + '&type=1');
			        });
			       } else {
			        var msg = result.msg;
			        layer.msg(msg);
			       }
			      },
			     });
			    })
			    
			    $('#zyc_refer').click(function(){
			     layer.open({
			      type: 2,
			      title: '审批',
			      anim: 5,
			      content: SCOPE.know+'?id=' + id,
			      area: ['600px', '450px'],
			     });
			    })
			   })
			   //关闭所有弹框，并重新加载当前页面
			   function cloae(){
			    layer.closeAll();
			   }
		</script>
	</body>
</html>
