layui.extend({
	tinymce: '../static/js/common/layui_exts/tinymce/tinymce'
}).use(['tinymce', 'util', 'form', 'laydate', 'layedit', 'upload'], function() {
	var form = layui.form,
		laydate = layui.laydate,
		tinymce = layui.tinymce,
		util = layui.util,
		layedit = layui.layedit,
		upload = layui.upload;
	
	var myDate = new Date();  //获取当前时间
	lay('.date').each(function() {
		laydate.render({
			elem: this,
			trigger: 'click',
			max:myDate.toLocaleString()
		});
	});
	
	var edit = tinymce.render({
		elem: "#demo",
		height: 500
	});
	
	$.getUrlParam = function(name) { //获取路径中的参数
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	var id = $.getUrlParam('id'); //获取id

	$(function() {
		var type = $.getUrlParam('type'); //获取id
		if (id != '' && type == null) {
			var postId = {};
			postId['trEid'] = id;
			$.ajax({
				type: "get",
				url: SCOPE.value,
				data: postId,
				dataType: 'json',
				success: function(result) {
					if (result.status == 0) {
						var datas = result.data;
						var html = '<div>\
						<p>'+datas.trContent+'</p>\
						<div align="right">'+datas.trDate+'-'+datas.trEnd+'</div>\
						</div>';
						if(type != null){
							$('.zyc_content').html(html);
						}else{
							if(datas.tr_content != ''){
								$('.zyc_content').html(html);
							}
						}
					} else {
						var msg = result.msg;
						layer.msg(msg);
					}
				},
			});
		}
	})
	form.on('submit(formDemo)', function(data) {
		$(this).addClass('layui-btn-disabled');
		$(this).attr('disabled', 'disabled');
		var that = $(this);
		data.field.trContent  = edit.getContent();
		data.field.trEid  = id;
		$.ajax({
			type: "POST",
			url: SCOPE.operate,
			data: data.field,
			dataType: 'json',
			success: function(result) {
				if (result.status == 0) {
					var msg = result.msg;
					layer.msg(msg);
				} else {
					that.removeClass('layui-btn-disabled');
					that.removeAttr('disabled');
					var msg = result.msg;
					layer.msg(msg);
				}
			}
		});
		return false;
	});
})
