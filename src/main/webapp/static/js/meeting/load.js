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
	var state = $.getUrlParam('state'); //获取id
	var type = $.getUrlParam('type'); //获取id
	$(function() {
		if(type == null){
			if(state > 0){
				$('#zyc_adds').css('display','none');
			}
		}else{
			$('#zyc_adds').css('display','none');
		}
		var postData = {};
		postData['vEid'] = id;
		tables(postData);
	});
	
	//加载列表方法
	function tables(postData) {
		if(type == null){
			if(state < 1){
				var datas = [
					[{
						field: 'id',
						title: 'ID',
						width: 80,
						align:'center'
					}, {
						field: 'firmName',
						title: '客户',
						cellMinWidth: 150,
						align:'center'
					}, {
						field: '',
						title: '操作',
						width: 250,
						toolbar: '#zyc_btn',
						align:'center'
					}]
				];
			}else{
				var datas = [
					[{
						field: 'id',
						title: 'ID',
						width: 80,
						align:'center'
					}, {
						field: 'firmName',
						title: '客户',
						cellMinWidth: 150,
						align:'center'
					}]
				];
			}
		}else{
			var datas = [
				[{
					field: 'id',
					title: 'ID',
					width: 80,
					align:'center'
				}, {
						field: 'firmName',
						title: '客户',
						cellMinWidth: 150,
						align:'center'
					}]
			];
		}
		
		table.render({
			elem: '#demo',
			height: 457,
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
	//新增访问客户
	$('#zyc_add').click(function() {
		if(state > 0){
			return;
		}
		var ids = id,
			text = '添加访问客户',
			url = SCOPE.add_url;
		popup(ids, text, url)
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
		if(layEvent === 'delete'){//删除
			var text = data.firmName;
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
