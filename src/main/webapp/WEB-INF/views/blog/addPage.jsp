<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../tag.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../baseurl.jsp" %>
    <title>添加文章</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="static/css/common.css" rel="stylesheet" type="text/css" />
    <link href="static/css/blog/add.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" charset="utf-8" src="static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="static/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="static/js/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="static/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript" src="static/js/blog/add.js"></script>
</head>
<body>
	<div class="blog_info_div">
		<p>
			<lable>标题：</lable>
			<input type="text" id="blog_title">
			<span class="red"></span>
		</p>
		<p>
			<lable>分类：</lable>
			<select id="blog_type" id="blog_type">
				<option value="0" selected="selected">请选择</option>
				<c:forEach items="${typeList}" var="item">
					<option value="${item.param_code}">${item.param_value}</option>
				</c:forEach>
			</select>
			<span class="red"></span>
		</p>
		<p>
			<lable>关键字：</lable>
			<input type="text" id="blog_key">
			<span class="red"></span>
		</p>
		<p>
			<lable>描述：</lable>
			<input type="text" id="blog_des">
			<a href="javascript:add.setDes();">获取描述</a>
			<span class="red"></span>
		</p>
	</div>
	<div class="editor_div">
	    <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
	</div>
	<div class="page_div" style="text-align:center;">
		<a href="javascript:add.doSave(1);">保存</a>
		<a href="javascript:add.doSave(0);">保存并发布</a>
		<a href="javascript:add.cancle();">取消</a>
	</div>
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>
</body>
</html>