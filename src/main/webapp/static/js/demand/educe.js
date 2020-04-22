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
		table.render({
			elem: '#demo',
			height: 457,
			toolbar: '#toolbarDemo',
			defaultToolbar: ['filter', 'exports', 'print', {
				title: '提示',
				layEvent: 'LAYTABLE_TIPS',
				icon: 'layui-icon-tips'
			}],
			url: SCOPE.table_url,
			method: 'get',
			where: postData,
			page: {
				groups: 10,
			},
			cols: [
					[{
						field: 'id',
						title: 'ID',
						width: 80,
						align:'center'
					}, {
						field: 'cName',
						title: '产品类型',
						cellMinWidth: 150,
						align:'center'
					}, {
						field: 'gName',
						title: '产品系统名称',
						cellMinWidth: 150,
						align:'center'
					}, {
						field: 'gModel',
						title: '产品系统型号',
						cellMinWidth: 100,
						align:'center'
					}, {
						field: 'gDescribe',
						title: '产品描述',
						cellMinWidth: 100,
						align:'center'
					}]
				],
			parseData: function(res) {
				return {
					"code": res.status,
					"msg": res.message,
					"count": res.total,
					"data": res.data
				};
			}
		});
	}
	
});
