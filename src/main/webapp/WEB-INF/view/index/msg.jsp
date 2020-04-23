<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<title></title>
		<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/index/msg.css"/>
</head>
<body id="app">
		<div class="header">
			<div class="headName"> 
				<span>Alice:</span>
				<span class="position" style="color: #0080FF;"></span>
			</div>
		</div>
		<div class="bodyer">
			<div class="useImg left">
				<div class="headImg">
					<img id="headImg" src="${pageContext.request.contextPath}/static/img/empty.png"/>
				</div>
				<div>
					<div>
						<div class="headGrade">
							<span>姓名:</span>
							<span class="useType"></span>
						</div>
					</div>
				</div>
			</div>
			<div class="useMsg left">
				<div class="msgTitle">基本信息</div>
				<ul>
					<li>
						<span class="column">职称:</span>
						<span class="useContent" id="title">***</span>
					</li>
					<li>
						<span class="column">职责描述:</span>
						<span class="useContent" id="duty">***</span>
					</li>
					<li>
						<span class="column">职位:</span>
						<span class="useContent" id="position">***</span>
					</li>
					<li>
						<span class="column">职位描述:</span>
						<span class="useContent" id="desc">***</span>
					</li>
				</ul>
				<div class="msgTitle">销售区域</div>
				<ul>
					<li>
						<span class="column">移动电话:</span>
						<span class="useContent" id="phone">***</span>
					</li>
					<li>
						<span class="column">办公电话:</span>
						<span class="useContent" id="officePhone">***</span>
					</li>
					<li>
						<span class="column">电子邮件:</span>
						<span class="useContent" id="email">***</span>
					</li>
					<li>
						<span class="column">传真:</span>
						<span class="useContent" id="fax">***</span>
					</li>
				</ul>
			</div>
		</div>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
	<script>
		var url='${pageContext.request.contextPath}/sevenStaff/selectPersonal'
		var data=new Object();
		$.ajax({
			url:url,
			type:'get',
			async: true,
			dataType:'json',
			success:(function (res) {
				if(res.status==0){
					$('.useType').text(res.data.sevenStaff.sName);
					$('.position').text(res.data.sevenMessage.mName);
					$('#headImg').attr("src",'${pageContext.request.contextPath}/'+res.data.iUrl);
					$('#desc').text(res.data.sevenMessage.mDesc);
					$('#title').text(res.data.sevenStaff.sTitle);
					$('#duty').text(res.data.sevenStaff.sDuty);
					$('#position').text(res.data.sevenMessage.mName);
					$('#post').text(res.data.sevenMessage.mName);
					$('#phone').text(res.data.sevenStaff.sPhone);
					$('#officePhone').text(res.data.sevenStaff.officePhone);
					$('#email').text(res.data.sevenStaff.sEmail);
					$('#fax').text(res.data.sevenStaff.faxNum);
				}
			})
		})
	</script>
	</body>
</html>