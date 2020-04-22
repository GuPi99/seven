<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" href="../../static/img/favicon.ico" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/js/common/layui/css/layui.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/demand/sj.css"/>
</head>
<body>
<div class="tooler">
			<form class="layui-form" action="">
				<div class="layui-form-item left">
					<div class="layui-input-block">
						<select name="productId" id='name'></select>
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
							,{field: 'saleVolume', title: '销售额', width:'15%'}
							,{field: 'saleNumber', title: '销售量', width:'20%'} 
							,{field: 'censusName', title: '统计人', width: '20%'}
							,{field: 'censusDate', title: '统计时间', width: '20%'}
						]]
				})
			}
		})
	</script>
</body>
</html>