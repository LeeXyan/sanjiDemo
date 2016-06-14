<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<base href="<%=basePath%>" />
<meta charset="UTF-8">
<link rel="stylesheet" href="css/amazeui.min.css" />
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript" src="js/jquery.scroll-follow.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>

<title>列表</title>
</head>
<body>
   <%@include file="../../../common/afterbar.jsp"%>
  <table width="100%" border="1" cellspacing="1" cellpadding="0">
		<thead>
			<tr>
			    <th>序号</th>
				<th>用户名</th>
				<th>密码</th>
				<th>手机</th>
				<th>权限名字</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${data}">
				<tr class="am-active">
				    <td>${item.id}</td>
				    <td>${item.username}</td>
					<td>${item.password}</td>
					<td>${item.mobile}</td>
					<td>${item.roler}</td>
					<td style="width: 200px;">
					  <button type="button" onclick="add()">增加</button>
					  <button type="button" >修改</button>
					  <button type="button" >删除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	
	<%-- <div class="phone_main_07">

		<p id="p"></p>
		<!-- <ul id="phone_list_page_ul"> -->
		<ul data-am-widget="pagination"
			class="am-pagination am-pagination-select">
			<li class="am-pagination-prev "><c:choose>
					<c:when test="${data.metadata.number ==0}">
						<a>上一页</a>
					</c:when>
					<c:otherwise>
						<a
							href="admin/list/list1?sort=createdDate,desc&page=${data.metadata.number-1}"
							class="">上一页</a>
					</c:otherwise>
				</c:choose></li>
			<li class="am-pagination-select">${data.metadata.number+1} /
				${data.metadata.totalPages}</li>
			<li class="am-pagination-next "><c:choose>
					<c:when
						test="${ data.metadata.number+1 == data.metadata.totalPages}">
						<a>下一页</a>
					</c:when>

					<c:otherwise>
						<a
							href="admin/list/list1?sort=createdDate,desc&page=${data.metadata.number+1}"
							class="">下一页</a>
					</c:otherwise>
				</c:choose></li>
		</ul>
		<!-- </ul> -->
	</div> --%>
</body>
</html>