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
<script type="text/javascript">

function myrefresh()
{
   window.location.reload();
}
//setTimeout('myrefresh()',2000); //指定1秒刷新一次

 function btn_add(id){
	 window.location.href = "admin/list/add2?id="+id;
 }
 function btn_del(id){
	 $.ajax({
            url: "admin/list/"+id,
            data:{},
            type: "get",
            datatype: "json",
            success: function(data) {alert("dsfdfsdfsd")}
        }) ;
	 
 }
 function btn_modify(id){
 }
 
</script>
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
			<c:forEach var="item" items="${data.content}">
				<tr class="am-active">
				    <td>${item.content.id}</td>
				    <td>${item.content.username}</td>
					<td>${item.content.password}</td>
					<td>${item.content.mobile}</td>
					<td>${item.content.roler}</td>
					<td>${item.content.imei}</td>
					<td style="width: 200px;">
					  <button type="button"  id="btn_add" onclick="btn_add(${item.content.id})">增加</button>
					  <button type="button" id="btn_modify" onclick="btn_modify(${item.content.id})">修改</button>
					  <button type="button" id="btn_del" style="background: red;" onclick="btn_del(${item.content.id})">删除</button>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	
	<div class="phone_main_07">

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
	</div>
	
	
<!-- 	
	弹窗
	<div id="background"></div>
	<div id="content">
		<div class="ultlon_content_body">

			<div>
				<div class="remark_left">备注：</div>
				<div class="remark_right">
					<textarea name="MSG" id="remark" cols=50 rows=6></textarea>
				</div>
			</div>

			<input type="hidden" name="type" value="" id="common_id"> <input
				type="hidden" name="type" value="" id="sa"> <input
				type="hidden" name="type" value="" id="sr">

			<button type="button" class="ultlon_gather ultlon_content_body_btn"
				style="background: red;" id="btn_ok" onclick="btn_ok();">确定</button>
			<button class="ultlon_gather ultlon_content_body_btn" id="cl_cancel">取消</button>
		</div>
	</div> -->
	
	
</body>
</html>