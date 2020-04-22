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
				var li = ['<option value="">全部类型</option>'];
				$(datas).each(function(i){
					li.push('<option value="'+datas[i].id+'">'+datas[i].c_name+'</option>');
				})
				var lis = li.join("");
				$('select[name=g_cid]').html(lis);
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
					type: 'numbers',
					title: 'id',
					width: 80,
					align:'center'
				}, {
					field: 'r_sid',
					title: '员工级别',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'r_date',
					title: '报告日期',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'r_crew',
					title: '同行人员',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'r_title',
					title: '项目名称',
					cellMinWidth: 150,
					align:'center'
				}, {
					field: 'r_firm',
					title: '拜访公司',
					width: 150,
					align:'center'
				}, {
					field: 'r_user',
					title: '最终用户',
					width: 150,
					align:'center'
				}, {
					field: '',
					title: '操作',
					width: 80,
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
	//添加货品
	$('#zyc_add').click(function() {
		var id = '',
			text = '添加报告',
			url = SCOPE.add_url;
		popup(id, text, url)
	})
	//数据操作方法绑定
	table.on('tool(test)', function(obj) {
		var data = obj.data; 
		var layEvent = obj.event;
		if (layEvent === 'edit') {//编辑
			var id = data.id,
				text = '编辑报告',
				url = SCOPE.add_url;
			popup(id, text, url)
		}
	});
});
