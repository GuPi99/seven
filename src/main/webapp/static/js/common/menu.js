$(function() {
	function t(t) {
		var e = 0;
		return $(t).each(function() {
			e += $(this).outerWidth(!0)
		}), e
	}

	function n() {
		var t = $(this).data("href"),
			a = $(this).data("index"),
			n = !0;
		$(this).parent().parent().find('li').removeClass('zyc_this');
		$(this).parent().addClass('zyc_this');
		if (void 0 == t || 0 == $.trim(t).length) {
			var is = $(this).parent().is('.zyc_twin');
			if (is == true) {
				var open = $(this).parent().find('.zyc_menu_twin').is('.zyc_menu_twin_open');
				if (open == false) {
					$('.zyc_menu_twin').removeClass('zyc_menu_twin_open');
					$(this).parent().find('.zyc_menu_twin').addClass('zyc_menu_twin_open');
				} else {
					$(this).parent().find('.zyc_menu_twin').removeClass('zyc_menu_twin_open');
				}
			}
			return !1;
		}
		$('#zyc_iframe').attr('src',t);
		return !1
	}

	$(".zyc_me_menu").each(function(t) {
			$(this).attr("data-index") || $(this).attr("data-index", t)
		}),
		$(".zyc_me_menu").on("click", n);
});
