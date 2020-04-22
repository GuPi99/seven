var myDate = new Date(),
	year = myDate.getFullYear();
function successfns(d) {
	if (d.status == 0) {
		var myChart = echarts.init(document.getElementById('main'));
		// 指定图表的配置项和数据
		var option = {
			title: {
				text: year+'年订单出口统计'
			},
			tooltip: {},
			xAxis: {
				data: d.data.title
			},
			yAxis: {},
			series: [{
				name: '订单出口量',
				type: 'bar',
				data: d.data.data
			}]
		};
		
		// 使用刚指定的配置项和数据显示图表。
		myChart.setOption(option);
	} else {
		var msg = d.msg;
		layer.msg(msg);
	}
}
$(function(){
	var postData = {};
	postData['year'] = year;
	$.axspost(SCOPE.datas_url, postData, successfns, errorfn);
})
