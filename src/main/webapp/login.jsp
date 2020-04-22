<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico"/>
		<title>七所高科销售管理系统</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="http://at.alicdn.com/t/font_1242623_63pmdw5olfb.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/login.css"/>
		<style>
			#zyc_login{
				background: url(${pageContext.request.contextPath}/static/img/backdrop.png) no-repeat;
				background-size: 100% 100%;
				width: 100%;
				height: 100%;
			}
			.titlebg{
				width: 150px;
				background: url('${pageContext.request.contextPath}/static/img/titlebg.png') no-repeat;
				background-size: 100%;
				background-position: -11px center;
			}
		</style>
		<script language="JavaScript">
			if(window != top)
				top.location.href = location.href;
			function check(){
				var aAccount=$("#aAccount").val();
				var aPassword=$("#aPassword").val();
				var code=$("#captcha").val();
				 $.ajax({
			         type: "POST",
			         data:{"aAccount":aAccount,"aPassword":aPassword,"code":code},
			         url: "${pageContext.request.contextPath}/sevenAccount/loginCheck",
			         async: false,
			         success: function(msg){
			            if(msg.status=="code"){
			            	alert(msg.msg)
			            	changeCpacha() 
			            }else if(msg.status=="pwd"){
			            	alert(msg.msg)
			            	changeCpacha() 
			            }else if(msg.status=="error"){
			            	alert(msg.msg)
			            	changeCpacha() 
			            }else if(msg.status=="200"){
			            	window.location="${pageContext.request.contextPath}/sevenMenus/index";
			            }
			         }
			     });
			}
			function changeCpacha(){
				$("#cpacha").attr("src",'getCpacha?t'+new Date().getTime());
			}
		</script>
	</head>
	<body>
		<div id="zyc_login">
			<div id="zyc_login_form">
				<div class="formBlock">
					<div class="formTop">
						<div class="titlebg">
							<img src="${pageContext.request.contextPath}/static/img/title.png"/>
						</div>
					</div>
					<form class="zyc_form">
						<div class="zyc_float">
							<div class="zyc_left zyc_tag">
								<i class="iconfont iconzhanghu"></i>
							</div>
							<div class="zyc_left">
								<input type="text" id="aAccount" name="aAccount" class="zyc_input zyc_boder_no" placeholder="账户" />
							</div>
						</div>
						<div class="zyc_float">
							<div class="zyc_left zyc_tag">
								<i class="iconfont iconmima"></i>
							</div>
							<div class="zyc_left">
								<input type="password" id="aPassword" name="aPassword" class="zyc_input zyc_boder_no" placeholder="密码" />
							</div>
						</div>
						<div class="zyc_float" id="zyc_verify">
							<div class="zyc_left">
								<input type="text" name="code"   style="vertical-align:bottom" tabindex='3' id="captcha" pattern="[A-z0-9]{4}" title="验证码为4个字符" autocomplete="off" class="zyc_input zyc_boder_no" placeholder="验证码" />
							</div>
							<div class="zyc_left">
								<img title="点击刷新验证码" id="cpacha" onclick="changeCpacha()" src="getCpacha" style="cursor:pointer;vertical-align:bottom" width="100%">
							</div>
						</div>
						<div class="zyc_float">
							<button style="background-color: #1565E2 !important;" type="button" onclick="check()" id="zyc_login_btn" class="zyc_btn zyc_ntn_blue zyc_left">登 录</button>
						</div>
					</form>
				</div>
			</div>
			<footer id="zyc_foot">
				<span>Copyright © 2006-2019 </span><a href="javascript:location.reload()">七所高科 在线办公系统</a>
			</footer>
			<!-- <div id="zyc_logo">
				<img src="${pageContext.request.contextPath}/static/img/logo.png" />
				<span>七所高科 </span>
				<span>在线信息化管理平台</span>
			</div> -->
		</div>
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/layui/lay/modules/layer.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/common.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/login/index.js"></script>
	</body>
</html>