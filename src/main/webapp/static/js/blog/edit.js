var edit = {};

edit.setDes = function(){
	var des = UE.getEditor('editor').getContentTxt().substr(0,100);
	$("#blog_des").val(des);
};

edit.doSave = function(){
	var blog_info = edit.getParam();
	if(blog_info){
		$.post("blog/doUpdate.do",blog_info,
		function(data){
			var obj = eval("("+data+")");
			if(obj.state == 1){
				location.href="blog/listPage.do";
			}
			else{
				parent.layer.alert("编辑失败!");
			}
		});
	}
};

edit.getParam = function(){
	var blog_title = $("#blog_title").val();
	var blog_type = $("#blog_type").val();
	var blog_key = $("#blog_key").val();
	var blog_des = $("#blog_des").val();
	$("#blog_title").parent().find("span").html("");
	$("#blog_type").parent().find("span").html("");
	$("#blog_key").parent().find("span").html("");
	$("#blog_des").parent().find("span").html("");
	if(blog_title == ""){
		$("#blog_title").parent().find("span").html("请输入标题");
		return false;
	}
	if(blog_type == 0){
		$("#blog_type").parent().find("span").html("请选择类型");
		return false;
	}
	if(blog_key == ""){
		$("#blog_key").parent().find("span").html("请输入关键词");
		return false;
	}
	if(blog_des == ""){
		$("#blog_des").parent().find("span").html("请输入描述");
		return false;
	}
	var blog_info = {
			'blog_id'		:	$("#blog_id").val(),
			'blog_title'	:	blog_title,
			'blog_type'		:	blog_type,
			'blog_key'		:	blog_key,
			'blog_des'		:	blog_des,
			'blog_content'	:	UE.getEditor('editor').getContent()
		};
	return blog_info;
};

$(function(){
	UE.getEditor('editor').ready(function(){
		UE.getEditor('editor').setContent($("#blog_content_div").html());    
	});
});