<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../tag.jsp" %>

<table class="blog_table" cellpadding="0" cellspacing="0">
	<tr style="background-color: darkgrey;">
		<th width="5%">id</th>
		<th width="20%">标题</th>
		<th width="10%">关键词</th>
		<th width="15%">描述</th>
		<th width="10%">分类</th>
		<th width="10%">创建日期</th>
		<th width="5%">浏览量</th>
		<th width="5%">点赞量</th>
		<th width="20%">操作</th>
	</tr>
	<c:forEach items="${list}" var="item">
		<tr>
			<td>${item.id}</td>
			<td>${item.title}</td>
			<td>${item.keywords}</td>
			<td>${item.description}</td>
			<td>
				<sh:getValue name="blog_type" code="${item.type}"/>
			</td>
			<td>
				<fmt:formatDate value="${item.create_time}" pattern="yyyy-MM-dd HH:mm:ss"/>
			</td>
			<td>${item.view_count}</td>
			<td>${item.up_count}</td>
			<td>
				<span>
					<a href="http://haoyu/blog/index.php?m=Blogs&c=Index&a=view&bid=${item.id}" target="_black">预览</a>
				</span>
				<span onclick="Blog.edit(${item.id});">编辑</span>
				<c:if test="${item.del_flag == '1'}">
					<span class="red" onclick="Blog.open(${item.id});">发布</span>
				</c:if>
				<c:if test="${item.del_flag == '0'}">
					<span onclick="Blog.del(${item.id});">删除</span>
				</c:if>
			</td>
		</tr>
	</c:forEach>
</table>
<!-- 分页容器  -->
<div class="page_div">
	${paging}
</div>
