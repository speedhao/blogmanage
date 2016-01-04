<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="static/css/common.css" rel="stylesheet" type="text/css" />
	<link href="static/css/index/index.css" rel="stylesheet" type="text/css" />
	<script src="static/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<script src="static/layer/layer.js" type="text/javascript"></script>
	<script src="static/js/index/index.js" type="text/javascript"></script>
	<title>SpeedHao后台管理系统</title>
</head>
<body>
	<div class="top_bar">
		<p>
			<span class="logo_span" id="show_hide">SpeedHao</span>
			<span>博客管理系统</span>
			<span class="button_out">
				<a href="doLogout.do" style="color:black;">退出</a>
			</span>
		</p>
	</div>
	<div class="middle_box">
		<div class="left_bar">
			<ul>
				<li>
					<a href="blog/listPage.do" target="content_iframe">文章列表</a>
				</li>
				<li>
					<a href="blog/addPage.do" target="content_iframe">添加文章</a>
				</li>
				<li>
					<a href="blog/addPage.do" target="content_iframe">回复管理</a>
				</li>
				<li>
					<a href="blog/addPage.do" target="content_iframe">意见管理</a>
				</li>
				<li class="tool_list_li" data="user" isShow="false">
					<a>用户管理</a>
				</li>
				<div style="display:none;" class="tool_list_user tool_list_div">
					<li>
						<a href="blog/addPage.do" target="content_iframe">用户列表</a>
					</li>
					<li>
						<a href="blog/addPage.do" target="content_iframe">黑名单管理</a>
					</li>
					<li>
						<a href="blog/addPage.do" target="content_iframe">参数管理</a>
					</li>
				</div>
				<li class="tool_list_li" data="params" isShow="false">
					<a>参数管理</a>
				</li>
				<div style="display:none;" class="tool_list_params tool_list_div">
					<li>
						<a href="blog/addPage.do" target="content_iframe">参数项管理</a>
					</li>
					<li>
						<a href="blog/addPage.do" target="content_iframe">参数值管理</a>
					</li>
				</div>
				<li class="tool_list_li" data="blog" isShow="false">
					<a>网站统计</a>
				</li>
				<div style="display:none;" class="tool_list_blog tool_list_div">
					<li>
						<a href="blog/addPage.do" target="content_iframe">访问统计</a>
					</li>
					<li>
						<a href="blog/addPage.do" target="content_iframe">文章统计</a>
					</li>
					<li>
						<a href="blog/addPage.do" target="content_iframe">参数管理</a>
					</li>
				</div>
			</ul>
		</div>
		<div class="content_box">
			<iframe src="blog/listPage.do" name="content_iframe"></iframe>
		</div>
	</div>
</body>
</html>