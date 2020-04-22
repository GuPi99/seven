//加载列表
layui.use(['form', 'layer', 'table'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		layer = layui.layer;

	$(function() {
		//加载模糊搜索下拉框数据
		function successfns(d){
			if (d.status == 0) {
				var datas = d.data;
				var li = ['<option value="">全部菜单</option>'];
				$(datas).each(function(i){
					li.push('<option value="'+datas[i].id+'">'+datas[i].m_name+'</option>');
				})
				var lis = li.join("");
				$('select[name=m_mid]').html(lis);
				form.render('select');
			} else {
				var msg = d.msg;
				layer.msg(msg);
			}
		}
		var postData = {};
		$.axspost(SCOPE.selects,postData,successfns,errorfn);
		//模糊搜索原始数据获取
		var formData = $('#zyc_search').serializeArray();
		var postData = {};
		$(formData).each(function(i) {
			postData[this.name] = this.value;
		});
		bound(postData);
	});
	//加载列表方法
	function bound(postData) {
		var boundData = [
				[{
					type: 'id',
					title: 'ID',
					width: 80,
					align:'center'
				}, {
					field: 'mName',
					title: '名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'mUrl',
					title: '地址',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'mSymbol',
					title: '图标',
					cellMinWidth: 150,
					toolbar: '#zyc_i',
					align:'center'
				}, {
					field: 'mMid',
					title: '上级',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'mSort',
					title: '排序',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'mState',
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
			];
		tables(postData,boundData);
	}
	//模糊搜索
	$('#zyc_btn_search').click(function() {
		var formData = $('#zyc_search').serializeArray();
		var postData = {};
		$(formData).each(function(i) {
			postData[this.name] = this.value;
		});
		bound(postData);
	});
	//添加菜单
	$('#zyc_add').click(function() {
		var id = '',
			text = '添加菜单',
			url = SCOPE.add_url;
		popup(id, text, url)
	})
	//数据操作方法绑定
	table.on('tool(test)', function(obj) {
		var data = obj.data; 
		var layEvent = obj.event;
		if (layEvent === 'edit') {//编辑
			var id = data.id,
				text = '编辑菜单',
				url = SCOPE.add_url;
			popup(id, text, url)
		} else if (layEvent === 'state') {//状态改变
			var text = $(this).text() + data.m_name;
			layer.msg('是否' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					if(data.m_state == '启用'){
						postData['m_state'] = -1;
					}else{
						postData['m_state'] = 0;
					}
					$.axspost(SCOPE.operate,postData,successfn,errorfn);
				}
			});
		} else if(layEvent === 'delete'){//删除
			var text = data.m_name;
			layer.msg('是否删除' + text + '？', {
				time: 0,
				btn: ['是', '否'],
				yes: function(index) {
					layer.close(index);
					var postData = {};
					postData['id'] = data.id;
					$.axspost(SCOPE.cancel,postData,successfn,errorfn);
				}
			});
		}
	});
});
