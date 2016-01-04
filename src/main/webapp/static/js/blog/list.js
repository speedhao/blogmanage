var Blog = {};
var nowPage = 1;
/**
 * 获取文章列表
 */
Blog.getBlogList = function(showPage){
	var title = $("#blog_title").val();
	var type = $("#blog_type").val();
	
	$.post("blog/list.do",{
		showPage:showPage,
		title:title,
		type:type
	},function(data){
		$("#list_div").html(data);
		nowPage = showPage;
	});
};

/**
 * 编辑文章
 */
Blog.edit = function(bid){
	location.href="blog/editPage.do?bid="+bid;
};

/**
 * 删除文章
 */
Blog.del = function(bid){
	$.post("blog/doDel.do",{
		bid:bid
	},function(data){
		var obj = eval("("+data+")");
		parent.layer.alert(obj.msg);
		if(obj.state == 1){
			Blog.getBlogList(nowPage);
		}
	});
};

/**
 * 发布文章
 */
Blog.open = function(bid){
	$.post("blog/doOpen.do",{
		bid:bid
	},function(data){
		var obj = eval("("+data+")");
		parent.layer.alert(obj.msg);
		if(obj.state == 1){
			Blog.getBlogList(nowPage);
		}
	});
};

$(function(){
	Blog.getBlogList(1);
	$("#query_button").click(function(){
		Blog.getBlogList(1);
	});
});