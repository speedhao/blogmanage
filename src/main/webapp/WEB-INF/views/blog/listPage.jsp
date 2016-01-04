<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../tag.jsp" %>
<!DOCTYPE html>
<html>
<head>
	<%@include file="../baseurl.jsp" %>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="static/css/common.css" rel="stylesheet" type="text/css" />
	<link href="static/css/blog/list.css" rel="stylesheet" type="text/css" />
	<script src="static/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="static/layer/layer.js" type="text/javascript"></script>
	<script src="static/js/blog/list.js" type="text/javascript"></script>
<title>文章列表</title>
</head>
<body>
	<div class="query_div">
		<p>
			<span><lable>标题：</lable><input type="text" id="blog_title"></span>
			<span>
				<lable>分类：</lable>
				<select id="blog_type">
					<option value="0" selected="selected">请选择</option>
					<c:forEach items="${typeList}" var="item">
						<option value="${item.param_code}">${item.param_value}</option>
					</c:forEach>
				</select>
			</span>
			<span id="query_button">查询</span>
		</p>
	</div>
	<div id="list_div"></div>
</body>
</html>