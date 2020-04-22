//加载列表
layui.use(['form', 'layer', 'table'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		layer = layui.layer;

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
					field: 'fName',
					title: '客户名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'companyName',
					title: '企业归属',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'fPhone',
					title: '电话',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'fEmail',
					title: '邮箱',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'fFax',
					title: '传真',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'fEin',
					title: '税号',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'fSite',
					title: '地址',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: '',
					title: '操作',
					width: 250,
					toolbar: '#zyc_btn',
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
	//新增客户
	$('#zyc_add').click(function() {
		var id = '',
			text = '添加客户',
			url = SCOPE.add_url;
		popup(id, text, url)
	})
	//批量导入
	$('#zyc_into').click(function() {
		layer.open({
			type: 2,
			title: '批量导入',
			anim: 5,
			content: SCOPE.into,
			area: ['600px', '400px'],
		});
	})
	//弹框调出方法
	function popup(id, text, url) {
		layer.open({
			type: 2,
			title: text,
			anim: 5,
			content: url+'?id=' + id,
			area: ['600px', '450px'],
		});
	}
	//数据操作公共调用方法
	function refer(url, postData) {
		$.ajax({
			type: "get",
			url: url,
			data: postData,
			dataType: 'json',
			success: function(result) {
				if (result.status == 0) {
					var msg = result.msg;
					layer.msg(msg);
					setTimeout(function() {
						location.reload();
					}, 800)
				} else {
					var msg = result.msg;
					layer.msg(msg);
				}
			},
		});
	}
	//数据操作方法绑定
	table.on('tool(test)', function(obj) {
		var data = obj.data; 
		var layEvent = obj.event;
		if (layEvent === 'edit') {//编辑
			var id = data.id,
				text = '编辑客户信息',
				url = SCOPE.edit_url;
			popup(id, text, url)
		} else if(layEvent === 'delete'){//删除
			var text = data.fName;
			layer.msg('是否删除' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					var url = SCOPE.cancel;
					refer(url, postData)
				}
			});
		}
	});
});
