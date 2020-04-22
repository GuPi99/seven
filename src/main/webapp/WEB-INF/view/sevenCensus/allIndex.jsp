<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/need/index.css"/>
</head>
<body>
<div class="header">
			<div class="headTitle">
				<div class="iconBlock left">
					<i class="iconfont icon-jihua"></i>
				</div>
				<div class="nameBlock left">
					<span>部门需求</span>
					<span><i class="iconfont icon-arr"></i></span>
					<span>数据统计</span>
				</div>
				<div class="clear"></div>
			</div>
		</div>
		<div class="tooler">
			<form class="layui-form" action="">
				<div class="layui-form-item left">
					<div class="layui-input-block">
						<select name="productId" id="name"></select>
					</div>
				</div>
				<div class="layui-form-item left">
					<div class="layui-input-block rili">
						<div class="riliIcon">
							<i class="iconfont icon-rili"></i>
						</div>
						<input type="text" name="censusDate" class="layui-input" id="test1">
					</div>
				</div>
				<div class="searchBlock left">
					<button lay-filter="formDemo" lay-submit class="layui-btn layui-btn-normal">
						搜索<i class="iconfont icon-chazhao"></i>
					</button>
				</div>
				<div class="addBtn right">
					<button lay-filter="add" lay-submit class="layui-btn layui-btn-normal">
						添加数据<i class="iconfont icon-tianjia"></i>
					</button>
				</div>
				<div class="clear"></div>
			</form>
		</div>
		<div class="tabler">
			<table id="demo" lay-filter="test"></table>
		</div>
	<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
	<script>
		layui.use(['laydate','form','table','layer'], function(){
			var laydate = layui.laydate;
			var form    = layui.form;
			var table   = layui.table;
			var layer   = layui.layer;
			laydate.render({
				elem: '#test1' //指定元素
			});
			form.on('submit(add)',function(data){
				layer.open({
					type: 2,
					content:'${pageContext.request.contextPath}/sevenCensus/toAdd',
					area : ['1200px', '800px'],
					maxmin : true,
					title : '添加报告'
				})
				return false;
			})
			$.ajax({
			    url:'${pageContext.request.contextPath}/sevenGoods/selectAll',
			    dataType:'json',
			    success:function(res){
			     var str='<option value=""></option>'
			     res.forEach(function(e){
			      str+='<option value="'+e.id+'">'+e.gName+'</option>'
			     })
			     $('#name').html(str);
			     form.render('select')
			    }
			   })
			var data=new Object();
			    data.productId='';
			    data.censusDate='';
			var url='${pageContext.request.contextPath}/sevenCensus/getSevenCensusList';
			form.on('submit(formDemo)',function(data){
				search(url,data.field);
				return false
			})
			search(url,data);
			function search(url,data){
				table.render({
					elem: '#demo'
					,height: 418
					,url:url
					,page: true
					,method: 'get'
					,where: data
					,cols: [[ //表头
							{field: 'id', title: 'ID', width:'5%', sort: true}
							,{field: 'productName', title: '产品名称', width:'20%'}
							,{field: 'censusDate', title: '日期', width:'15%'}
							,{field: 'saleVolume', title: '销售额', width:'20%'} 
							,{field: 'saleNumber', title: '销售数量', width: '20%'}
							,{field: 'monthMoney', title: '本月回款', width: '20%'}
						]]
				})
			}
		})
	</script>
</body>
</html>