//复选框
function checkbox(e) {
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
function radio(e) {
	$(e).parent().find('input[type=radio]').prop("checked", false);
	$(e).parent().find('.zyc_radio').removeClass('zyc_checked');
	$(e).find('input[type=radio]').prop("checked", true);
	$(e).addClass('zyc_checked');
}

