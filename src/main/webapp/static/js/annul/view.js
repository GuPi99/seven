//加载列表
layui.use(['form', 'layer', 'table'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		layer = layui.layer;

	$.getUrlParam = function(name) { //获取路径中的参数
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	var id = $.getUrlParam('id'); //获取id
	$(function() {
		var postData = {};
		postData['id'] = id;
		tables(postData);
	});

	//加载列表方法
	function tables(postData) {
		$.ajax({
			type: "get",
			url: SCOPE.table_url,
			data: postData,
			dataType: 'json',
			success: function(result) {
				if (result.status == 0) {
					var datas = result.data;
					var li = [];
					$(datas).each(function(i) {
						li.push(
							'<li class="layui-timeline-item">\
    <i class="layui-icon layui-timeline-axis">&#xe63f;</i>\
    <div class="layui-timeline-content layui-text">\
      <h3 class="layui-timeline-title">' +
							datas[i].time + '</h3>\
      <p>' + datas[i].content + '</p>\
    </div>\
  </li>');
					})
					var lis = li.join("");
					$('.layui-timeline').html(lis);
				} else {
					var msg = result.msg;
					layer.msg(msg);
				}
			},
		});
	}
});
