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
		postData['psPid'] = id;
		tables(postData);
	});
	
	//加载列表方法
	function tables(postData) {
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
			cols: [
				[{
					field: 'id',
					title: 'ID',
					width: 80,
					align:'center'
				}, {
					field: 'psContent',
					title: '进度描述',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'psUrl',
					title: '附件',
					cellMinWidth: 150,
					toolbar: '#zyc_btn',
					align:'center'
				}, {
					field: 'psTime',
					title: '记录时间',
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
	//新增项目进度
	$('#zyc_add').click(function() {
		if(state > 0){
			return;
		}
		var ids = id,
			text = '添加项目进度',
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
	//数据操作方法绑定
	table.on('tool(test)', function(obj) {
		var data = obj.data; 
		var layEvent = obj.event;
		if(layEvent === 'view'){//预览
			var text = "http://47.104.106.214:8082/seven/"+data.psUrl;
			layer.open({
				type: 2,
				title: '查看附件',
				anim: 5,
				content: text,
				area: ['1000px', '500px'],
			});
		}
	});
});
