layui.extend({
	tinymce: '../static/js/common/layui_exts/tinymce/tinymce'
}).use(['tinymce', 'util', 'form', 'laydate', 'layedit', 'upload'], function() {
	var form = layui.form,
	laydate = layui.laydate,
	tinymce = layui.tinymce,
	util = layui.util,
  	ayedit = layui.layedit,
  	upload = layui.upload;

	var edit = tinymce.render({
		elem: "#demo",
		height: 500
	});
 
	$.getUrlParam = function(name) {
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
			return null;
		}
		var id = $.getUrlParam('id');
		var state = $.getUrlParam('state'); //获取id
		var type = $.getUrlParam('type'); //获取id

		$(function() {
			if(type == 'null'){
				if(state > 3){
					bound();
				}
			}else{
				bound();
			}
			//编辑赋值
			function bound(){
				var postId = {};
				postId['prPid'] = id;
				$.ajax({
					type: "get",
					url: SCOPE.value,
					data: postId,
					dataType: 'json',
					success: function(result) {
						if (result.status == 0) {
							var datas = result.data;
							var html = '<div>\
								<p>'+datas.prReport+'</p >\
								<div align="right">'+datas.prTime+'</div>\
								</div>';
							if(type != null){
								$('.zyc_content').html(html);
							}else{
								if(datas.prReport != ''){
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
  data.field.prReport = edit.getContent();
  data.field.prPid = id;
  $.ajax({
   type: "post",
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