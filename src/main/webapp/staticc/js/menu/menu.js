$(function() {
	function t(t) {
		var e = 0;
		return $(t).each(function() {
			e += $(this).outerWidth(!0)
		}), e
	}

	function e(e) {
		var a = t($(e).prevAll()),
			i = t($(e).nextAll()),
			n = t($(".zyc_tab_nav").children().not(".zyc_tab")),
			s = $(".zyc_tab_nav").outerWidth(!0) - n,
			r = 0;
		if ($(".zyc_tab_list").outerWidth() < s) r = 0;
		else if (i <= s - $(e).outerWidth(!0) - $(e).next().outerWidth(!0)) {
			if (s - $(e).next().outerWidth(!0) > i) {
				r = a;
				for (var o = e; r - $(o).outerWidth() > $(".zyc_tab_list").outerWidth() - s;)
					r -= $(o).prev().outerWidth(),
					o = $(o).prev()
			}
		} else a > s - $(e).outerWidth(!0) - $(e).prev().outerWidth(!0) && (r = a - $(e).prev().outerWidth(!0));
		$(".zyc_tab_list").animate({
			marginLeft: 0 - r + "px"
		}, "fast")
	}

	function a() {
		var e = Math.abs(parseInt($(".zyc_tab_list").css("margin-left"))),
			a = t($(".zyc_tab_nav").children().not(".zyc_tab")),
			i = $(".zyc_tab_nav").outerWidth(!0) - a,
			n = 0;
		if ($(".zyc_tab_list").width() < i) return !1;
		for (var s = $(".zyc_menuTab:first"), r = 0; r + $(s).outerWidth(!0) <= e;) r += $(s).outerWidth(!0), s = $(s).next();
		if (r = 0, t($(s).prevAll()) > i) {
			for (; r + $(s).outerWidth(!0) < i && s.length > 0;) r += $(s).outerWidth(!0), s = $(s).prev();
			n = t($(s).prevAll())
		}
		$(".zyc_tab_list").animate({
			marginLeft: 0 - n + "px"
		}, "fast")
	}

	function i() {
		var e = Math.abs(parseInt($(".zyc_tab_list").css("margin-left"))),
			a = t($(".zyc_tab_nav").children().not(".zyc_tab")),
			i = $(".zyc_tab_nav").outerWidth(!0) - a,
			n = 0;
		if ($(".zyc_tab_list").width() < i) return !1;
		for (var s = $(".zyc_menuTab:first"), r = 0; r + $(s).outerWidth(!0) <= e;) r += $(s).outerWidth(!0), s = $(s).next();
		for (r = 0; r + $(s).outerWidth(!0) < i && s.length > 0;) r += $(s).outerWidth(!0), s = $(s).next();
		n = t($(s).prevAll()), n > 0 && $(".zyc_tab_list").animate({
			marginLeft: 0 - n + "px"
		}, "fast")
	}

	function n() {
		var t = $(this).attr("href"),
			a = $(this).data("index"),
			i = $.trim($(this).text()),
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
		if ($(".zyc_menuTab").each(function() {
				return $(this).data("id") == t ? (
					$(this).hasClass("zyc_active") || ($(this).addClass("zyc_active").siblings(".zyc_menuTab").removeClass(
							"zyc_active"), e(this),
						$(".zyc_content .zyc_iframe").each(function() {
							return $(this).data("id") == t ? ($(this).show().siblings(".zyc_iframe").hide(), !1) : void 0
						})),
					n = !1,
					!1) : void 0
			}), n) {
			var s = '<a href="javascript:;" class="zyc_active zyc_menuTab" data-id="' + t + '">' + i +
				' <span class="iconfont iconcha"></span></a>';
			$(".zyc_menuTab").removeClass("zyc_active");
			var r = '<iframe class="zyc_iframe" name="iframe' + a + '" width="100%" height="100%" src="' + SCOPE.menu_url + t +
				'" frameborder="0" data-id="' + t + '" seamless></iframe>';
			$(".zyc_content").find("iframe.zyc_iframe").hide().parents(".zyc_content").append(r);
			var o = layer.load();
			$(".zyc_content iframe:visible").load(function() {
					layer.close(o)
				}),
				$(".zyc_tab .zyc_tab_list").append(s),
				e($(".zyc_menuTab.zyc_active"))
		}
		return !1
	}

	function s() {
		var t = $(this).parents(".zyc_menuTab").data("id"),
			a = $(this).parents(".zyc_menuTab").width();
		if ($(this).parents(".zyc_menuTab").hasClass("zyc_active")) {
			if ($(this).parents(".zyc_menuTab").next(".zyc_menuTab").size()) {
				var i = $(this).parents(".zyc_menuTab").next(".zyc_menuTab:eq(0)").data("id");
				$(this).parents(".zyc_menuTab").next(".zyc_menuTab:eq(0)").addClass("zyc_active"), $(".zyc_content .zyc_iframe").each(
					function() {
						return $(this).data("id") == i ? ($(this).show().siblings(".zyc_iframe").hide(), !1) : void 0
					});
				var n = parseInt($(".zyc_tab").css("margin-left"));
				0 > n && $(".zyc_tab").animate({
					marginLeft: n + a + "px"
				}, "fast"), $(this).parents(".zyc_menuTab").remove(), $(".zyc_content .zyc_iframe").each(function() {
					return $(this).data("id") == t ? ($(this).remove(), !1) : void 0
				})
			}
			if ($(this).parents(".zyc_menuTab").prev(".zyc_menuTab").size()) {
				var i = $(this).parents(".zyc_menuTab").prev(".zyc_menuTab:last").data("id");
				$(this).parents(".zyc_menuTab").prev(".zyc_menuTab:last").addClass("zyc_active"), $(".zyc_content .zyc_iframe").each(
					function() {
						return $(this).data("id") == i ? ($(this).show().siblings(".zyc_iframe").hide(), !1) : void 0
					}), $(this).parents(".zyc_menuTab").remove(), $(".zyc_content .zyc_iframe").each(function() {
					return $(this).data("id") == t ? ($(this).remove(), !1) : void 0
				})
			}
		} else $(this).parents(".zyc_menuTab").remove(), $(".zyc_content .zyc_iframe").each(function() {
			return $(this).data("id") == t ? ($(this).remove(), !1) : void 0
		}), e($(".zyc_menuTab.zyc_active"));
		return !1
	}

	function r() {
		$(".zyc_tab_list").children("[data-id]").not(":first").not(".zyc_active").each(function() {
			$('.zyc_iframe[data-id="' + $(this).data("id") + '"]').remove(), $(this).remove()
		}), $(".zyc_tab_list").css("margin-left", "0")
	}

	function o() {
		e($(".zyc_menuTab.zyc_active"))
	}

	function d() {
		if (!$(this).hasClass("zyc_active")) {
			var t = $(this).data("id");
			$(".zyc_content .zyc_iframe").each(function() {
				return $(this).data("id") == t ? ($(this).show().siblings(".zyc_iframe").hide(), !1) : void 0
			}), $(this).addClass("zyc_active").siblings(".zyc_menuTab").removeClass("zyc_active"), e(this)
		}
	}

	function c() {
		var t = $('.zyc_iframe[data-id="' + $(this).data("id") + '"]'),
			e = t.attr("src"),
			a = layer.load();
		t.attr("src", e).load(function() {
			layer.close(a)
		})
	}
	//获取菜单
	var postData = {};
	$.ajax({
		type: "get",
		url: SCOPE.menus,
		data: postData,
		dataType: 'json',
		success: function(result) {
			if (result.status == 0) {
				var datas = result.data,
					li = [];
				$(datas).each(function(i){
					if(datas[i].mMid == 0 && datas[i].mName == '首页'){
						var lis = '<li ';
						lis += 'class="zyc_this"';
						lis += '><a class="zyc_me_menu" href="'+datas[i].m_url+'"><i class="iconfont '+datas[i].m_symbol+'"></i><span>'+datas[i].m_name+'</span></a></li>';
						li.push(lis);
					}else if(datas[i].m_mid == 0 && datas[i].m_name != '首页'){
						var lis = '<li class="zyc_twin"><a class="zyc_me_menu"><i class="iconfont '+datas[i].m_symbol+'"></i><span>'+datas[i].m_name+'</span></a>';
						lis += '<ul class="zyc_clear zyc_menu_twin">';
						var liss = [];
						$(datas).each(function(k){
							if(datas[i].id == datas[k].m_mid){
								liss.push('<li><a class="zyc_me_menu" href="'+datas[k].m_url+'"><i class="iconfont '+datas[k].m_symbol+'"></i><span>'+datas[k].m_name+'</span></a></li>');
							}else{
								liss.push('');
							}
						})
						lis += liss.join("");
						lis += '</ul></li>';
						li.push(lis);
					}
				})
				var GetData = li.join("");
				$('.zyc_menu>ul').html(GetData);
				$(".zyc_me_menu").each(function(t) {
						$(this).attr("data-index") || $(this).attr("data-index", t)
					}),
					$(".zyc_me_menu").on("click", n),
					$(".zyc_tab").on("click", ".zyc_menuTab span.iconcha", s),
					$(".zyc_tabCloseOther").on("click", r),
					$(".zyc_tabShowActive").on("click", o),
					$(".zyc_tab").on("click", ".zyc_menuTab", d),
					$(".zyc_tab").on("dblclick", ".zyc_menuTab", c),
					$(".zyc_tabLeft").on("click", a),
					$(".zyc_tabRight").on("click", i),
					$(".zyc_tabCloseAll").on("click", function() {
						$(".zyc_tab_list").children("[data-id]").not(":first").each(function() {
								$('.zyc_iframe[data-id="' + $(this).data("id") + '"]').remove(), $(this).remove()
							}),
							$(".zyc_tab_list").children("[data-id]:first").each(function() {
								$('.zyc_iframe[data-id="' + $(this).data("id") + '"]').show(),
									$(this).addClass("zyc_active")
							}),
							$(".zyc_tab_list").css("margin-left", "0")
					})
			} else {
				layer.msg('系统错误，请联系管理员！');
			}
		},
		error: function(e) {
			layer.msg('系统错误', {
				icon: 5
			});
			setTimeout(function() {
				location.href = history.go(-1);
			}.bind(this), 600);
		}
	})
});
