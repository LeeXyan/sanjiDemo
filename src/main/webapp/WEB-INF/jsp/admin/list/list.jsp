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
	<%-- <%@include file="../../../common/afterbar.jsp"%>
 --%>
	<table
		class="am-table am-table-bordered am-table-striped am-table-hover">
		<thead>
			<tr>
				<th>申请人</th>
				<th>手机</th>
				<th>串号</th>
				<th>订单号</th>
				<th>签收时间</th>
				<th>退款金额</th>
				<th>类型</th>
				<th>备注</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${data.content}">
				<tr class="am-active">
				    <td>${item.content.user.username}</td>
					<td>${item.content.user.password}</td>
					<td>${item.content.user.mobile}</td>
					<td>${item.content.user.region }</td>
					<td>${item.content.user.roler}</td>
					<td>${item.content.user.imei}</td>
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
							href="admin/list?sort=createdDate,desc&imei=${imei}&page=${data.metadata.number-1}"
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
							href="admin/list?sort=createdDate,desc&imei=${imei}&page=${data.metadata.number+1}"
							class="">下一页</a>
					</c:otherwise>
				</c:choose></li>
		</ul>
		<!-- </ul> -->
	</div> --%>
	<script>
	/* 	function choose() {
			//alert($("#choose").val());
			//$("#imei").val()=$("#choose").val();
			if ($("#choose").val() == "1") {
				$("#imei").attr('placeholder', "请输入要查询的串号");

			} else {
				$("#imei").attr('placeholder', "请输入要查询的申请人");
			}

		}
		
		function goSearch() {
			var imei = $("#imei").val().trim();
			if(($("#choose").val()=="1")){
				if(!isNaN(imei)){
					alert("将按照串号查询");
					window.location.href = "admin/list?sort=createdDate,desc&imei="	+ imei;	
				}else{
					alert("请按照串号查询");
				}
			}else{
				if(isNaN(imei)){
					alert("将按照申请人查询");
					window.location.href = "admin/list?sort=createdDate,desc&imei="
						+ imei;	
				}else{
					alert("请按照申请人查询");
				}				
	
			} */
			
			
			/*if (!isNaN(imei)) {
				alert("按照串号查询");
				window.location.href = "admin/refund?sort=createdDate,desc&imei="
						+ imei;
			} else {
				alert("按照申请人查询");
				window.location.href = "admin/refund?sort=createdDate,desc&imei="
						+ imei;
			}*/

			//window.location.href = "admin/refund?sort=createdDate,desc&imei="+imei;
		//}
	</script>

</body>
</html>