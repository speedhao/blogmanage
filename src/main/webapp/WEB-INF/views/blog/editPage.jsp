<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../tag.jsp" %>
<!DOCTYPE HTML>
<html>
<head>
	<%@include file="../baseurl.jsp" %>
    <title>编辑文章</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8"/>
    <link href="static/css/common.css" rel="stylesheet" type="text/css" />
    <link href="static/css/blog/add.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" charset="utf-8" src="static/ueditor/ueditor.config.js"></script>
    <script type="text/javascript" charset="utf-8" src="static/ueditor/ueditor.all.min.js"> </script>
    <script type="text/javascript" charset="utf-8" src="static/ueditor/lang/zh-cn/zh-cn.js"></script>
    <script src="static/js/jquery-1.8.0.min.js" type="text/javascript"></script>
    <script src="static/layer/layer.js" type="text/javascript"></script>
    <script type="text/javascript" src="static/js/blog/edit.js"></script>
</head>
<body>
	<div class="blog_info_div">
		<input type="hidden" value="${blog.id}" id="blog_id">
		<div style="display:none;" id="blog_content_div">${blog.content}</div>
		<p>
			<lable>标题：</lable>
			<input type="text" id="blog_title" value="${blog.title}">
			<span class="red"></span>
		</p>
		<p>
			<lable>分类：</lable>
			<select id="blog_type" id="blog_type">
				<option value="0" selected="selected">请选择</option>
				<c:forEach items="${typeList}" var="item">
					<option value="${item.param_code}"<c:if test="${item.param_code==blog.type}"> selected="selected"</c:if>>${item.param_value}</option>
				</c:forEach>
			</select>
			<span class="red"></span>
		</p>
		<p>
			<lable>关键字：</lable>
			<input type="text" id="blog_key" value="${blog.keywords}">
			<span class="red"></span>
		</p>
		<p>
			<lable>描述：</lable>
			<input type="text" id="blog_des" value="${blog.description}">
			<a href="javascript:edit.setDes();">获取描述</a>
			<span class="red"></span>
		</p>
	</div>
	<div class="editor_div">
	    <script id="editor" type="text/plain" style="width:100%;height:500px;"></script>
	</div>
	<div class="page_div" style="text-align:center;">
		<a href="javascript:edit.doSave();">保存</a>
		<a href="javascript:history.go(-1);">取消</a>
	</div>
	<script type="text/javascript">
		var ue = UE.getEditor('editor');
	</script>
</body>
</html>