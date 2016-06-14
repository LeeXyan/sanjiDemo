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
	 window.location.href = "admin/list/add2/";
 }
 function btn_del(id){
	 $.ajax({
            url: "admin/list/del/"+id,
            data:{},
            type: "post",
            datatype: "json",
            success: function(data) {
            	window.location.href = "admin/list/list3/"
            }
        }) ;
	 
 }
 function btn_modify(id){
	 window.location.href = "admin/list/update1/"+id;
	/*  $.ajax({
         url: "admin/list/update"+id,
         data:{},
         type: "get",
         datatype: "json",
         success: function(data) {alert("修改成功！")}
     }) ; */
 }
 
 function btn_details(){
	 window.location.href = "admin/list/update1/"+id;
 }
 function choose() {
		//alert($("#choose").val());
		//$("#imei").val()=$("#choose").val();
		if ($("#choose").val() == "1") {
			$("#imei").attr('placeholder', "请输入要查询的用户名");

		} else {
			$("#imei").attr('placeholder', "请输入要查询的手机号");
		}

	}
 
 
 
 function goSearch() {
		var imei = $("#imei").val().trim();
		if(($("#choose").val()=="1")){
			if(imei==undefined || imei=="" || imei==null){
				alert("请输入用户名");
			}else{
				 window.location.href = "admin/list/findByusername/"+imei;
			}
		   
		}else{
			if(imei==undefined || imei=="" || imei==null){
				alert("请输入手机号");
			}else{
				window.location.href = "admin/list/findBymobile/"+imei;
			}
				
		}
	}
 
 function goAll() {
		window.location.href = "admin/list/list3";
	}
</script>
<style type="text/css">
 .am{
  margin:0 auto;
 }
</style>
<title>列表</title>
</head>
<body>
   <%@include file="../../../common/afterbar.jsp"%>
   <div>
      <div class="am-inputgroup">
                     <div>
                         <select id="choose" onchange="choose()">
						   <option value="1">用户名</option>
						   <option value="2">手机号</option>
					     </select>
                     </div>
					<div> 
					<input type="text" class="am-form-field" style="width: 300px" id="imei" placeholder="请输入" >
						<button class="am-btn am-btn-default" type="button"
							onclick="goSearch();" style="margin-right: 5px;">搜索</button>
						<button class="am-btn am-btn-default" type="button"
							onclick="goAll();">查询全部</button>
					</div>
		</div>			
   </div>
  <table width="100%" border="1" cellspacing="1" cellpadding="0">
		<thead>
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>手机号</th>
				<th>权限名字</th>
				<th>地址</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${data.content}">
				<tr class="am-active">
				  <%--   <td>${item.content.id}</td> --%>
				    <td>${item.content.User.username}</td>
					<td>${item.content.User.password}</td>
					<td>${item.content.User.mobile}</td>
					<td>${item.content.User.roler}</td>
					<td>${item.content.User.imei}</td>
					<td>${item.content.address}</td>
					<td style="width: 200px;">
					 
					  <button type="button" id="btn_modify" onclick="btn_modify(${item.content.User.id})">修改</button>
					  <button type="button" id="btn_del" style="background: red;" onclick="btn_del(${item.content.User.id})">删除</button>
					  <button type="button" id="btn_details" style="background: red;" onclick="btn_details()">详情</button>
					</td>
				</tr>
			</c:forEach>
			 <button type="button"  id="btn_add" onclick="btn_add()">增加</button>
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
							href="admin/list/list3?sort=createdDate,desc&page=${data.metadata.number-1}"
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
							href="admin/list/list3?sort=createdDate,desc&page=${data.metadata.number+1}"
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