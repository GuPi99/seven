layui.use(['form', 'laydate'], function() {
	var form = layui.form,
		laydate = layui.laydate;
		
	//编辑赋值
	$.getUrlParam = function(name) { //获取路径中的参数
		var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		var r = window.location.search.substr(1).match(reg);
		if (r != null) return unescape(r[2]);
		return null;
	}
	//表单提交
	form.on('submit(formDemo)', function(data) {
		//表单提交一次，禁止重复点击
		$(this).addClass('layui-btn-disabled');
		$(this).attr('disabled', 'disabled');
		//提交数据，data获取的表单数据
		var that = $(this);
		console.log(data.field);
		$.ajax({
			type: "post",
			url: SCOPE.operate,
			data: data.field,
			dataType: 'json',
			success: function(result) {
				//操作成功，状态（status）返回0
				if (result.status == 0) {
					var msg = result.msg; //成功提示获取
					layer.msg(msg); //成功提示弹框
					//成功后，300毫秒关闭弹框，重新加载列表页面（对应列表页面cloae方法）
					setTimeout(function() {
						window.parent.cloae();
					}, 300)
				} else if (result.status == 2) { //批量验证数据错误
					//解除提交按钮禁止点击
					that.removeClass('layui-btn-disabled');
					that.removeAttr('disabled');
					//获取批量错误提示
					var errors = result.msg;
					//获取表单提示信息展示位置，并进行对应展示
					$('.zyc_verify').each(function() {
						var errorMsg = errors[$(this).data('name')];
						$(this).html(errorMsg != undefined ? '*' + errorMsg : '').css(
							'cssText', 'color: red !important'
						);
					});
				} else { //其它错误，弹框提示
					//解除提交按钮禁止点击
					that.removeClass('layui-btn-disabled');
					that.removeAttr('disabled');
					//获取错误提示
					var msg = result.msg;
					//弹框提示
					layer.msg(msg);
				}
			}

		});
		return false;
	});
})
