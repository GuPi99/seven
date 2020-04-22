<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta name="robots" content="noindex, nofollow">
		<meta charset="utf-8">
			<link rel="shortcut icon" href="${pageContext.request.contextPath}/static/img/favicon.ico"/>
		<title>首页</title>
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
		<!-- 表格样式文件 -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/table.css" />
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/home.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/home/index.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/common/swiper.css"/>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/fonts/iconfont.css"/> 
		<style>
			.swiper-slide {
				text-align: center;
				font-size: 18px;
				background: #fff;
				/* Center slide text vertically */
				display: -webkit-box;
				display: -ms-flexbox;
				display: -webkit-flex;
				display: flex;
				-webkit-box-pack: center;
				-ms-flex-pack: center;
				-webkit-justify-content: center;
				justify-content: center;
				-webkit-box-align: center;
				-ms-flex-align: center;
				-webkit-align-items: center;
				align-items: center;
			}
			.swiper-slide{
				border-bottom: 2px solid #DBDBDB;
				width: 532px;
			}
		</style>
	</head>
	<body>
		<!-- 页面内容——开始 -->
		<div id="app">
			<div class="monthSale left">
				<div class="saleBlock">
					<div class="titleBg"></div>
					<div class="homeTitle">
						<div class="titleIcon"><i class="iconfont icon-xiaoshoue-xuanzhong"></i></div>
						<div class="titleName">当月销售额......</div>
					</div>
					<div id="sale" class="main"></div>
				</div>
			</div>
			<div class="monthTotal left">
				<div class="totalBlock">
					<div class="titleBg"></div>
					<div class="homeTitle">
						<div class="titleIcon"><i class="iconfont icon-xiaoshoue-copy"></i></div>
						<div class="titleName">当月回款......</div>
					</div>
					<div id="total" class="main"></div>
				</div>
			</div>
			<div class="assign left">
				<div class="saleBlock">
					<div class="titleBg"></div>
					<div class="homeTitle">
						<div class="titleIcon"><i class="iconfont icon-zhipaigei"></i></div>
						<div class="titleName">指派事务......</div>
						<div class="assingNum"></div>
					</div>
					<div class="main">
						<div class="assignSwiper swiper-container">
							<div class="swiper-wrapper" id="assign"></div>
							<!-- Add Pagination -->
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="depart left">
				<div class="totalBlock">
					<div class="titleBg"></div>
					<div class="homeTitle">
						<div class="titleIcon"><i class="iconfont icon-xuqiu"></i></div>
						<div class="titleName">部门事务......</div>
						<div class="departNum"></div>
					</div>
					<div class="main">
						<div class="topImg">
							<div class="left departImg">
								<img src="${pageContext.request.contextPath}/static/img/left.png"/>
							</div>
							<div class="right departImg">
								<img src="${pageContext.request.contextPath}/static/img/right.png"/>
							</div>
							<div class="center departImg">
								<img src="${pageContext.request.contextPath}/static/img/center.png"/>
							</div>
							<div class="clear"></div>
						</div>
						<div class="departSwiper swiper-container">
							<div class="swiper-wrapper" id="depart"></div>
							<!-- Add Pagination -->
							<div class="swiper-pagination"></div>
						</div>
					</div>
				</div>
			</div>
			<div class="clear"></div>
		</div>
		<!-- 页面内容——结束 -->
		<!-- jquery文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/jquery.min.js"></script>
		<!-- layui框架js文件 -->
		<script src="${pageContext.request.contextPath}/static/js/common/layui/layui.all.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/echarts.min.js"></script>
		<script src="${pageContext.request.contextPath}/static/js/common/swiper.js"></script>
		<script>
			url='${pageContext.request.contextPath}/sevenAssigned/getIndexList';
			$.ajax({
				url:url,
				dataType: 'json',
				success:function(d){
					if(d.status==0){
						var data=d.data;
						var str='';
						$('.assingNum').text(d.total)
						data.forEach((item,data)=>{
							str+='<div class="swiper-slide"><a href="javascript:;"><div class="assignBlock"><div class="assignText">'+item.aWork+'</div><div class="more"></div><div class="clear"></div></div></a></div>'
						})
						$('#assign').html(str);
						var assign = new Swiper('.assignSwiper', {
							pagination: '.swiper-pagination',
							paginationClickable: true,
							direction: 'vertical',
							slidesPerView: 6
						});
					}
				}
			})
		</script>
		<script>
			url='${pageContext.request.contextPath}/sevenBusiness/getIndexList';
			$.ajax({
				url:url,
				dataType: 'json',
				success:function(d){
					if(d.status==0){
						var data=d.data;
						$('.departNum').text(d.total)
						var str='';
						data.forEach((item,data)=>{
							str+='<div class="swiper-slide"><a href="javascript:;" ><div class="departBlock"><div class="departText">'+item.title+'</div></div></div></a></div>'
						})
						$('#depart').html(str);
						var depart = new Swiper('.departSwiper', {
							pagination: '.swiper-pagination',
							paginationClickable: true,
							direction: 'vertical',
							slidesPerView: 4
						});
					}
				}
			})
		</script>
		<script type="text/javascript">
			var url='${pageContext.request.contextPath}/sevenCensus/getCensusNumber';
			$.ajax({
				url:url,
				dataType: 'json',
				success: function(jsonStr) {
					if(jsonStr.status==0){
						var i=0;
					      var total=[];
					      var name=[];
					      jsonStr['data'].forEach(function(e){  
					       total[i]=e['saleVolume'];
					       name[i]=e['productName'];
					       i++;
					      });
						var myChart = echarts.init(document.getElementById('sale'));
						option = {
							tooltip: {
								trigger: 'axis',
								axisPointer: {
									type: 'shadow'
								}
							},
							grid: {
								left: '3%',
								right: '4%',
								bottom: '3%',
								containLabel: true
							},
							xAxis: {
								type: 'value',
								boundaryGap: [0, 0.01]
							},
							yAxis: {
								type: 'category',
								data: name
							},
							series: [
								{
									type: 'bar',
									data: total
								}
							],
						}
						myChart.setOption(option);
					}
				},
				error: function(e) {
					errorfn(e);
				}
			})
		</script>
		<script type="text/javascript">
			var url='${pageContext.request.contextPath}/sevenCensus/getCensusMoney';
			$.ajax({
				url:url,
				dataType: 'json',
				success: function(jsonStr) {
					if(jsonStr.status==0){
						var i=0;
					      var total=[];
					      var name=[];
					      jsonStr['data'].forEach(function(e){  
					       total[i]=e['monthMoney'];
					       name[i]=e['staffName'];
					       i++;
					      });
						var myChart = echarts.init(document.getElementById('total'));
						option = {
							color: ['#3398DB'],
							tooltip: {
								trigger: 'axis',
								axisPointer: {            // 坐标轴指示器，坐标轴触发有效
									type: 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
								}
							},
							grid: {
								left: '3%',
								right: '4%',
								bottom: '3%',
								containLabel: true
							},
							xAxis: [
								{
									type: 'category',
									data: name,
									axisTick: {
										alignWithLabel: true
									}
								}
							],
							yAxis: [
								{
									type: 'value'
								}
							],
							series: [
								{
									name: '直接访问',
									type: 'bar',
									barWidth: '60%',
									data: total
								},
							],
						};
						myChart.setOption(option);
					}
				},
				error: function(e) {
					errorfn(e);
				}
			})
		</script>
	</body>
</html>
