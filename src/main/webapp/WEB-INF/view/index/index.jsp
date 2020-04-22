<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico"/>
		<title>天津七所高科技有限公司</title>
		<meta name="renderer" content="webkit">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link rel="stylesheet" href="http://at.alicdn.com/t/font_1242623_n06o9axiodd.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticc/css/common/common.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticc/css/index/index.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticc/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/staticc/js/common/layui/css/layui.css" />
		<style>
			.topSetUse span{
				padding: 0;
			}
		</style>
	</head>
	<body>
		<div class="zyc_head">
			<div class="zyc_header">
				<div class="zyc_head_nav zyc_float">
					<div class="zyc_left zyc_float">
						<div class="zyc_left">
							<img class="zyc_logo" src="${pageContext.request.contextPath}/static/img/7logo.png" style="margin: 10px 0 10px 22px;" />
						</div>
						<div class="zyc_left">
							<span class="topName">天津七所高科技有限公司</span>
						</div>
						<div class="zyc_left">
							<img class="zyc_logo" src="${pageContext.request.contextPath}/static/img/top.png"  style="height: 18px;margin:18px 0;"> 
						</div>
					</div>
					<div class="zyc_right zyc_personal_menu">
						<ul class="zyc_clear zyc_float">
							<li class="zyc_left">
								<a class="zyc_me_menu">
									<i class="iconfont icon-shouye"></i>
								</a>
							</li>
							<li class="zyc_left">
								<a class="zyc_me_menu" id="rili">
									<i class="iconfont icon-rili" style="color:#aab6c1"></i>
								</a>
							</li>
							<li class="zyc_left">
								<a class="zyc_me_menu" id="chu">
									<i class="iconfont icon-tishi" style="color:#4f9dd6"></i>
								</a>
							</li>
							<li class="zyc_left zyc_float" id="zyc_per">
								<div class="zyc_left" id="setBtn">
									<img class="zyc_img topAdminImg" src="${pageContext.request.contextPath}/static/img/head.jpg" />
									<span class="topAdmin username"></span>
									<i class="layui-icon layui-icon-down"></i>
								</div>
								<div class="topSet" id="zyc_personal">
									<div class="topSetUse" onclick="msg(1)">
										<a href="#">
											<span class="username" style="padding: 0;">:</span>
											<span class="userpost" style="padding: 0;" class="topClass">区域经理</span>
										</a>
									</div>
									<div class="topSetBtn">
										<a onclick="btn('head',1)">
											<i class="iconfont icon-shezhi"></i>
											个性化设置
										</a>
									</div>
									<div class="topSetBtn">
										<a onclick="btn('pwd',1)">
											<i class="iconfont icon-mima"></i>
											修改密码
										</a>
									</div>
									<div class="topSetBtn">
										<a href="${pageContext.request.contextPath}/sevenAccount/logout">
											<i class="iconfont icon-tuichu"></i>
											退出
										</a>
									</div>
								</div>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="zyc_menu">
				<div class="zyc_menu_i" title="菜单">
					<i class="iconfont icon-caidan"></i>
				</div>
				<div class="headImgBlock">
					<div class="headImg" style="overflow: hidden;">
						<img id="headImg"  src="${pageContext.request.contextPath}/static/img/head.png">
					</div>
					<div class="headImgName username"></div>
				</div>
				<ul class="zyc_clear menuBlock">
			
				</ul>
			</div>
		</div>
		<div class="zyc_content" id="zyc_main">
			<iframe class="zyc_iframe" name="iframe0" width="100%" height="100%" src="${pageContext.request.contextPath}/sevenMenus/indexShow" frameborder="0" data-id="${pageContext.request.contextPath}/sevenMenus/indexShow" seamless></iframe>
		</div>
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/staticc/js/common/ajax.js"></script>
		<script src="${pageContext.request.contextPath}/staticc/js/menu/index.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/menu/menu.js"></script>
		<script>
			var SCOPE = {
					'menus': '${pageContext.request.contextPath}/sevenMenus/selectAll',//获取菜单列表
					'upload': '${pageContext.request.contextPath}/',//个人信息图片补全信息
			}
			var num = $('.zyc_menu>ul>li');
			for (var i = 1; i <= num.length; i++) {
				if($('.zyc_menu>ul>li:nth-child('+i+') li').length != 0){
					$('.zyc_menu>ul>li:nth-child('+i+')').addClass('zyc_twin');
					$('.zyc_menu>ul>li:nth-child('+i+')>a').removeAttr('href');
				}
			}
			
		</script>
		<script>
		$('#rili').on('click',function(){
			$('#dd').slideToggle(300);
		})
		var laydate = layui.laydate;
		layui.use('laydate', function(){
		  laydate.render({
			  elem: '#dd',
			  position: 'static',
			  showBottom: false
			});
		});
		$.ajax({
		    url:'${pageContext.request.contextPath}/sevenAccount/selectSevenAccount',
		    dataType:'json',
		    success:function(res){
		     if(res.status==0){
		      $('#headImg').attr('src',SCOPE.upload+res.datas);
		      $('.username').text(res.data.aNickname)
		      $('.userpost').text(res.data.userpost)
		     }
		    }
		   })
			function btn(url,id){
				if(url=='pwd'){
					var str='${pageContext.request.contextPath}/sevenAccount/pwd';
				}else if(url=='head'){
					var str='${pageContext.request.contextPath}/sevenAccount/head';
				}
				layui.use('layer', function(){
					var layer = layui.layer;
					layer.open({
						type: 2,
						content:str,
						area : ['800px', '500px'],
						maxmin : true,
						title : '修改信息'
					})
				})
			}
			function msg(id){
				var id=id;
				var str='msg.html?id='+id;
				layui.use('layer', function(){
					var layer = layui.layer;
					layer.open({
						type: 2,
						content:str,
						area : ['1200px', '800px'],
						maxmin : true,
						title : '修改密码'
					})
				})
			}
		</script>
	</body>
</html>
