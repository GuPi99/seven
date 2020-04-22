//加载列表
layui.use(['form', 'layer', 'table'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		layer = layui.layer;
	
	$.getUrlParam = function(name) {//获取路径中的参数
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	var type = $.getUrlParam('type');//获取type
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
					var li = ['<option value="">全部员工</option>'];
					$(datas).each(function(i) {
						li.push('<option value="' + datas[i].id + '">' + datas[i].sName + '</option>');
					})
					var lis = li.join("");
					$('select[name=aSid]').html(lis);
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
		if(type == null){
			var datas = [
				[{
					field: 'id',
					title: 'ID',
					width: 80,
					align: 'center'
				}, {
					field: 'staffName',
					title: '指派员工',
					cellMinWidth: 150,
					align: 'center'
				}, {
					field: 'aWork',
					title: '工作内容',
					cellMinWidth: 150,
					align: 'center'
				}, {
					field: 'aDatetime',
					title: '指派时间',
					cellMinWidth: 150,
					align: 'center'
				}, {
					field: 'state',
					title: '状态',
					cellMinWidth: 100,
					align: 'center'
				}, {
					field: 'aRemark',
					title: '批语',
					cellMinWidth: 100,
					align: 'center'
				}, {
					field: '',
					title: '操作',
					width: 250,
					toolbar: '#zyc_btn',
					align: 'center'
				}]
			];
		}else{
			var datas = [
				[{
					field: 'id',
					title: 'ID',
					width: 80,
					align: 'center'
				}, {
					field: 'staffName',
					title: '指派员工',
					cellMinWidth: 150,
					align: 'center'
				}, {
					field: 'aWork',
					title: '工作内容',
					cellMinWidth: 150,
					align: 'center'
				}, {
					field: 'aDatetime',
					title: '指派时间',
					cellMinWidth: 150,
					align: 'center'
				}, {
					field: 'state',
					title: '状态',
					cellMinWidth: 100,
					align: 'center'
				}, {
					field: 'aRemark',
					title: '批语',
					cellMinWidth: 100,
					align: 'center'
				}]
			];
		}
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
			cols: datas,
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
	//下派任务
	$('#zyc_add').click(function() {
		var id = '',
			text = '下派任务',
			url = SCOPE.add_url;
		popup(id, text, url)
	})
	//弹框调出方法
	function popup(id, text, url) {
		layer.open({
			type: 2,
			title: text,
			anim: 5,
			content: url + '?id=' + id,
			area: ['600px', '450px'],
		});
	}
	//数据操作公共调用方法
	function refer(url, postData) {
		$.ajax({
			type: "post",
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
		if (layEvent === 'edit') { //编辑
			var id = data.id,
				text = '编辑下派任务',
				url = SCOPE.edit_url;
			popup(id, text, url)
		} else if (layEvent === 'state') { //状态改变
			var text = data.staffName + '的下派任务的完成批语';
			layer.prompt({
				formType: 2,
				value: '',
				title: '请输入' + text,
				area: ['800px', '350px'] //自定义文本域宽高
			}, function(value, index, elem) {
				if (value == '') {
					layer.msg('请输入批语');
					return;
				}
				var postData = {};
				postData['id'] = data.id;
				postData['aRemark'] = value;
				postData['aState'] = 1;
				var url = SCOPE.operate;
				refer(url, postData)
			});
		} else if (layEvent === 'delete') { //删除
			var text = data.staffName + '的下派任务';
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
