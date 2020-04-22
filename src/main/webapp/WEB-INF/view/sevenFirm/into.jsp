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
			html,
			body {
				background-color: #fff;
			}

			#app {
				padding: 15px;
			}

			.layui-form-item {
				position: relative;
			}

			.layui-form-item .zyc_verify {
				position: absolute;
				top: 0;
				left: 320px;
				font-size: 13px;
				line-height: 30px;
			}

			.layui-form-checkbox i {
				height: 30px !important;
			}
		</style>
	</head>
	<body>
		<div id="app">
			<ul class="layui-timeline">
				<li class="layui-timeline-item">
					<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
					<div class="layui-timeline-content layui-text">
						<h3 class="layui-timeline-title">格式</h3>
						<p>请<a download="客户" href="${pageContext.request.contextPath}/static/excel/firm.xlsx">下载</a>对应格式Excel，进行批量导入</p>
					</div>
				</li>
				<li class="layui-timeline-item">
					<i class="layui-icon layui-timeline-axis">&#xe63f;</i>
					<div class="layui-timeline-content layui-text">
						<h3 class="layui-timeline-title">导入</h3>
						<p><input type="file" id="zyc_into" /></p>
					</div>
				</li>
			</ul>
		</div>
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<!-- excel导入js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/xlsx.core.min.js"></script>
		<script>
			var SCOPE = {
				'operate': '${pageContext.request.contextPath}/sevenFirm/batchFirm',
			}
			layui.use(['form', 'laydate'], function() {
				var form = layui.form,
					laydate = layui.laydate;
			})
			//导入Excel
			$('#zyc_into').change(function(e) {
				var that = $(this);
				var files = e.target.files;
				var fileReader = new FileReader();
				fileReader.onload = function(ev) {
					try {
						var data = ev.target.result
						var workbook = XLSX.read(data, {
							type: 'binary'
						}); // 以二进制流方式读取得到整份excel表格对象
						var rooms = []; // 存储获取到的数据
					} catch (e) {
						layer.msg('文件类型不正确, 请重新选择文件');
						return;
					}
			
					// 表格的表格范围，可用于判断表头是否数量是否正确
					var fromTo = '';
					// 遍历每一张sheet并读取内容
					for (var sheet in workbook.Sheets) {
						if (workbook.Sheets.hasOwnProperty(sheet)) {
							fromTo = workbook.Sheets[sheet]['!ref'];
							if (!fromTo) {
								layer.msg('文件内容为空, 导入失败');
								return;
							}
							rooms = rooms.concat(XLSX.utils.sheet_to_json(workbook.Sheets[sheet]));
							// break; // 如果只取第一张表，就取消注释这行
						}
					}
					var postData = {};
					postData['data'] = rooms;
					$.ajax({
						type: "post",
						url: SCOPE.operate,
						dataType: 'json',
						contentType : "application/json;charset=utf-8",
						 data: JSON.stringify(postData), 
						success: function(result) {
							if (result.status == 0) {
								var msg = result.msg;
								layer.msg(msg);
								setTimeout(function() {
									window.parent.cloae();
								}, 300)
							} else {
								var msg = result.msg;
								layer.msg(msg);
							}
						},
					});
				};
				// 以二进制方式打开文件
				fileReader.readAsBinaryString(files[0]);
			})
		</script>
	</body>
</html>
