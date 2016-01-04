var add = {};

add.doSave = function(del_falg){
	var blog_info = add.getParam(del_falg);
	if(blog_info){
		blog_info.blog_content = UE.getEditor('editor').getContent();
		$.post("blog/doSave.do",blog_info,
		function(data){
			var obj = eval("("+data+")");
			if(obj.state == 1){
				location.href="blog/listPage.do";
			}
			else{
				parent.layer.alert("添加失败");
			}
		});
	}
};

add.cancle = function(){
	parent.layer.alert("取消");
};

add.getParam = function(del_flag){
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
			'blog_title'	:	blog_title,
			'blog_type'		:	blog_type,
			'blog_key'		:	blog_key,
			'blog_des'		:	blog_des,
			'del_flag'		:	del_flag
		};
	return blog_info;
};

add.setDes = function(){
	var des = UE.getEditor('editor').getContentTxt().substr(0,100);
	$("#blog_des").val(des);
};