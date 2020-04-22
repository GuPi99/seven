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
					$('select[name=rSid]').html(lis);
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
					field: 'staffName',
					title: '员工',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'rDate',
					title: '报告日期',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'rCrew',
					title: '同行人员',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'rTitle',
					title: '项目名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'rFirm',
					title: '拜访公司',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'rUser',
					title: '最终用户',
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
		if (layEvent === 'direction') {//指示
			var text = data.staffName + '的访问报告指示';
			layer.prompt({
				formType: 2,
				title: '请输入' + text,
				area: ['800px', '350px'] //自定义文本域宽高
			}, function(value, index, elem) {
				if (value == '') {
					layer.msg('请输入指示');
					return;
				}
				var postData = {};
				postData['id'] = data.id;
				postData['rIndicate'] = value;
				var url = SCOPE.operate;
				refer(url, postData)
			});
		}else if (layEvent === 'reply') {//回复
			var text = data.staffName + '的访问报告回复';
			layer.prompt({
				formType: 2,
				title: '请输入' + text,
				area: ['800px', '350px'] //自定义文本域宽高
			}, function(value, index, elem) {
				if (value == '') {
					layer.msg('请输入回复');
					return;
				}
				var postData = {};
				postData['id'] = data.id;
				postData['rReply'] = value;
				var url = SCOPE.operate;
				refer(url, postData)
			});
		}
	});
});
