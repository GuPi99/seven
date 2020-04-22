
//加载列表
layui.use(['form', 'layer', 'table'], function() {
	var form = layui.form,
		$ = layui.jquery,
		table = layui.table,
		layer = layui.layer;

	//加载列表方法
	window.tables = function(postData,boundData,height=''){
		if(height == ''){
			height = 467;
		}
		table.render({
			elem: '#demo',
			height: height,
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
			cols: boundData,
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
	
	//弹框调出方法
	window.popup = function(id, text, url, areas=''){
		if(areas == ''){
			areas = ['1200px', '800px'];
		}
		layer.open({
			type: 2,
			title: text,
			anim: 5,
			content: url+'?id=' + id,
			area: areas,
			maxmin : true,
		});
	}
	
	//公共调用方法返回成功后，操作方法
	window.successfn = function(d){
		if (d.status == 0) {
			var msg = d.msg;
			layer.msg(msg);
			setTimeout(function() {
				location.reload();
			}, 800)
		} else {
			var msg = d.msg;
			layer.msg(msg);
		}
	}
	
	//公共调用方法返回失败后，调用方法
	window.errorfn = function(e){
		layer.msg('系统错误,请联系管理员', {
			icon: 5
		});
	}
	
	//复选框
	window.checkbox = function(e){
		var id = $(e).attr('id');
		var type = $(e).find('input[type=checkbox]').is(':checked');
		if (id != undefined) {
			//全选/全不选
			if (type == true) {
				$(e).find('input[type=checkbox]').removeAttr('checked');
				$(e).removeClass('zyc_checked');
				$(".ownerCost input[type=checkbox]").prop("checked", false);
				$(".ownerCost").removeClass('zyc_checked');
			} else {
				$(e).find('input[type=checkbox]').prop({
					checked: true
				});
				$(e).addClass('zyc_checked');
				$(".ownerCost input[type=checkbox]").prop("checked", true);
				$(".ownerCost").addClass('zyc_checked');
			}
		} else {
			//单选
			if (type == true) {
				$(e).find('input[type=checkbox]').removeAttr('checked');
				$(e).removeClass('zyc_checked');
			} else {
				$(e).find('input[type=checkbox]').prop({
					checked: true
				});
				$(e).addClass('zyc_checked');
			}
			if ($('#zyc_all').length > 0) {
				if ($('tbody input:checked').length == $('tbody input[type=checkbox]').length) {
					$("#zyc_all input[type=checkbox]").prop("checked", true);
					$("#zyc_all").addClass('zyc_checked');
				} else {
					$("#zyc_all input[type=checkbox]").prop("checked", false);
					$("#zyc_all").removeClass('zyc_checked');
				}
			}
		}
	}
	
	//单选框
	window.radio = function(e){
		$(e).parent().find('input[type=radio]').prop("checked", false);
		$(e).parent().find('.zyc_radio').removeClass('zyc_checked');
		$(e).find('input[type=radio]').prop("checked", true);
		$(e).addClass('zyc_checked');
	}
});
