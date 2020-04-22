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
			type: 'month',
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
					field: 'sName',
					title: '姓名',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'sex',
					title: '性别',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'sDateBirth',
					title: '出生年月',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'sPhone',
					title: '电话',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'sEmail',
					title: '邮箱',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'state',
					title: '状态',
					cellMinWidth: 100,
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
	//新增员工
	$('#zyc_add').click(function() {
		var id = '',
			text = '添加员工',
			url = SCOPE.add_url;
		popup(id, text, url)
	})
	//弹框调出方法
	function popup(id, text, url) {
		layer.open({
			type: 2,
			title: text,
			anim: 5,
			content: url+'?id=' + id,
			area: ['1200px', '600px'],
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
		if (layEvent === 'check') {//查看
			var id = data.id,
				text = '查看员工信息',
				url = SCOPE.edit_url;
			popup(id, text, url)
		} else if (layEvent === 'state') {//状态改变
			var text = $(this).text() + data.sName;
			layer.msg('是否' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					if(data.sState == 0){
						postData['sState'] = 1;
					}else{
						postData['sState'] = 0;
					}
					var url = SCOPE.operate;
					refer(url, postData)
				}
			});
		}
	});
});
