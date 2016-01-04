$(function() {
	// 栏目选择折叠效果
	$(".tool_list_li").click(function() {
		var isShow = $(this).attr("isShow");
		var data = $(this).attr("data");
		$(".tool_list_li").attr("isShow", "false");
		$(".tool_list_div").hide(300);
		if (isShow == "false") {
			$(".tool_list_" + data).show(300);
			$(this).attr("isShow", "true");
		}
	});

	// 点击speedhao显示或影藏左边栏
	$("#show_hide").click(function() {
		if ($(".left_bar").css("display") == "none") {
			$(".left_bar").show();
			$(".content_box").css("width", "82%");
		} else {
			$(".left_bar").hide();
			$(".content_box").css("width", "100%");
		}
	});
	
	//高度自适应
	$(window).resize(function() {
		setHeight();
	});
	setHeight();
});

// 设置高度
function setHeight() {
	var realHeight = $(window).height();
	$(".middle_box").css("height", realHeight+"px");
}