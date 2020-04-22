//加载列表
layui.use(['form', 'layer', 'table', 'laydate'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		laydate = layui.laydate,
		layer = layui.layer;
	
	lay('.date').each(function() {
		laydate.render({
			elem: this,
			trigger: 'click'
		});
	});
	
	$(function() {
		//模糊搜索原始数据获取
		var formData = $('#zyc_search').serializeArray();
		var postData = {};
		$(formData).each(function(i) {
			postData[this.name] = this.value;
		});
		tables(postData);
	});
	//加载列表方法
	function tables(postData) {
		table.render({
			elem: '#demo',
			height: 467,
			toolbar: '#toolbarDemo',
			defaultToolbar: ['filter', 'print', {
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
					field: 'staffName',
					title: '操作账户',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'lIp',
					title: '操作IP',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'lType',
					title: '操作类型',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'lContent',
					title: '操作内容',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'lDatetime',
					title: '操作时间',
					cellMinWidth: 150,
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
	//模糊搜索
	$('#zyc_btn_search').click(function() {
		var formData = $('#zyc_search').serializeArray();
		var postData = {};
		$(formData).each(function(i) {
			postData[this.name] = this.value;
		});
		tables(postData);
	});
});
