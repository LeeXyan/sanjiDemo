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
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript">
 
 function history1(){
	 history.go(-1);
 }
</script>
<title>列表</title>

</head>
<body>
   <%@include file="../../../common/afterbar.jsp"%>
    <!--  <form  action="admin/list/unit/update"> -->
     <div><span>用户名:${data.user.username}</span>
     </div>
      <div><span>密码:${data.user.password}</span>
     </div>
      <div><span>手机:${data.user.mobile}</span>
     </div>
     <div><span>权限名字:${data.user.roler}</span>
     </div>
      <div><span>地址:${data.address}</span>
     </div>
     <div>
       <button id="btn_modify" onclick="history1()">返回</button>
     </div>
 <!-- </form> -->
</body>
</html>
