//加载列表
layui.use(['form', 'layer', 'table'], function() {
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
					var li = ['<option value="">全部企业</option>'];
					$(datas).each(function(i){
						li.push('<option value="'+datas[i].id+'">'+datas[i].fName+'</option>');
					})
					var lis = li.join("");
					$('select[name=pFid]').html(lis);
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
					field: 'pConditions',
					title: '生效条件',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'pDate',
					title: '拟定日期',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'pDatetime',
					title: '上传时间',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'nowState',
					title: '项目状态',
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
	//弹框调出方法
	function popup(id, text, url) {
		layer.open({
			type: 2,
			title: text,
			anim: 5,
			content: url+'?id=' + id,
			area: ['1400px', '600px'],
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
		if(layEvent === 'edit'){//查看
			var id = data.id+'&state='+data.pcState,
				text = '查看项目',
				url = SCOPE.select_url;
			popup(id, text, url)
		}
	});
});
