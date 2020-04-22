/**
 * 菜单栏高度
 */
var height = $(window).height() - 101;
$('.zyc_menu').height(height+'px');
/**
 * 页面高度
 */
$('#zyc_main').height(height+'px');
/**
 * 菜单栏收缩
 */
$('.zyc_menu>.zyc_menu_i').click(function(){
	var is = $(this).parent().is('.zyc_menu_open');
	if(is == true){
		$(this).parent().removeClass('zyc_menu_open');
		$('#zyc_main').animate({
			paddingLeft:'0px'
		});
	}else{
		$(this).parent().addClass('zyc_menu_open');
		$('#zyc_main').animate({
			paddingLeft:'160px'
		});
	}
});
/**
 * 个人中心
 */
$('#zyc_per').click(function(){
	$('#zyc_personal').slideToggle(300);
});
/**
 * 关闭操作
 */
$('.zyc_head .zyc_header .zyc_tab_nav .zyc_group button').click(function(){
	$(this).next().slideToggle(300);
});
