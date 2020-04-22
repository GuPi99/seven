//加载列表
layui.use(['form', 'layer', 'table'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		layer = layui.layer;

	$(function() {
		//加载模糊搜索下拉框数据
		var postData = {};
		$.ajax({
			type: "get",
			url: SCOPE.selects,
			data: postData,
			dataType: 'json',
			success: function(result) {
				if (result.status == 0) {
					var datas = result.data;
					var li = ['<option value="0">全部企业</option>'];
					$(datas).each(function(i){
						li.push('<option value="'+datas[i].id+'">'+datas[i].fName+'</option>');
					})
					var lis = li.join("");
					$('select[name=tFid]').html(lis);
					form.render('select');
				} else {
					var msg = result.msg;
					layer.msg(msg);
				}
			},
		});
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
					field: 'firmName',
					title: '企业名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'tName',
					title: '平台名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'tUrl',
					title: '平台地址',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'tEmail',
					title: '注册邮箱',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'tPaw',
					title: '平台密码',
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
	//新增企业平台
	$('#zyc_add').click(function() {
		var id = '',
			text = '添加企业平台',
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
		if (layEvent === 'sedit') {//申请编辑
			var text = data.firmName+' 的企业平台 '+data.tName;
			layer.msg('是否申请编辑' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					postData['tState'] = '-1';
					var url = SCOPE.changeState;
					refer(url, postData)
				}
			});
		} else if(layEvent === 'sdelete'){//申请删除
			var text = data.firmName+' 的企业平台 '+data.tName;
			layer.msg('是否申请删除' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					postData['tState'] = '-2';
					var url = SCOPE.changeState;
					refer(url, postData)
				}
			});
		} else if(layEvent === 'upload'){//上传
			var text = data.firmName+' 的企业平台 '+data.tName;
			layer.msg('是上传' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					postData['tState'] = '1';
					var url = SCOPE.changeState;
					refer(url, postData)
				}
			});
		} else if(layEvent === 'delete'){//删除
			var text = data.firmName+' 的企业平台 '+data.tName;
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
		} else if(layEvent === 'edit'){//编辑
		var texts = data.firmName+' 的企业平台 '+data.tName;
			var id = data.id,
				text = texts,
				url = SCOPE.edit_url;
			popup(id, text, url)
		}
	});
});
