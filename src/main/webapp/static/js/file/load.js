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
		if(id=='null'){
			postData['pfPid'] = 0;
		}else{
			postData['pfPid'] = id;
		}
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
					field: 'pfName',
					title: '名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'pfType',
					title: '类型',
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
	//新增文件
	$('#zyc_add').click(function() {
		if(state > 0){
			return;
		}
		var ids = id,
			text = '添加文件',
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
		if(layEvent === 'preview'){//预览
			var text = "http://47.104.106.214:8082/seven/"+data.pfUrl;
			layer.open({
				type: 2,
				title: '预览'+data.pfName,
				anim: 5,
				content: text,
				area: ['1000px', '500px'],
			});
		}
	});
});
