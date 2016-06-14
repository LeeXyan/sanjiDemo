<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
	String id=request.getParameter("id");
	String username=request.getParameter("username");
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

 var id='<%=id%>';
 
 function btn_modify(){
		var id = $("#id").val().trim();
		 var username = $("#username").val().trim();
		 var password = $("#password").val().trim();
		 var mobile = $("#mobile").val().trim();
		 var roler = $("#roler").val().trim();
		console.info(",username:"+username+",password:"+password+",mobile:"+mobile+",roler:"+roler);

		/* var data='{\"username\":\""+username+"\",\"password\":\""+password+"\",\"mobile\":\""+mobile+"\",\"roler\":\""+roler+"\"}';//json字符 */
		 var data2={"id":id,"username":username,"password":password,"mobile":mobile,"roler":roler};//json对象 
		 //json 怎么转化成json字符 用JSON.stringify 要是没有json2.js的话要导入
		/// var data1 = JSON.parse(data);
		// var data2=JSON.stringify(data);
		 $.ajax({
			 type: "post",
	         url: "admin/list/update",
	         datatype: "json",
	         contentType:"application/json",
	         data:JSON.stringify(data2),
	         success: function(data) {
	        	 window.location.href = "admin/list/list3/"
	         }
	     }); 
	 }
 /* $(function(){
	   $("#submit").click(function(){
	     alert($("form").serialize());
	   });
 }); */
/*  function btn_modify(){
	  alert("id="+id);
	  var data = $("#userInfo").serialize();
	  alert("data="+data);
	  $.ajax({
         url: "admin/list/update/",
         data: data,
         type: "get",
         datatype: "json",
         success: function(data) {alert("修改成功！")}
     }) ; 
 } */
 
 function history1(){
	 history.go(-1);
 }
</script>


<title>列表</title>

</head>
<body>
   <%@include file="../../../common/afterbar.jsp"%>
   <!-- <div>
     <form  action="admin/list/update" id="userInfo"> -->
      <div><span>用户名:${data.username}</span>
      <%-- <input type="hidden" id="id" name="id" value="${data.id}">
      <input type="text" id="username" name="username" value="${data.username}"> --%>
     </div>
      <div><span>密码:${data.password}</span>
      <%-- <input type="text" id="password" name="password" value="${data.password}"> --%>
     </div>
      <div><span>手机:${data.mobile}</span>
      <%-- <input type="text" id="mobile" name="mobile" value="${data.mobile}"> --%>
     </div>
     <div><span>权限名字:${data.roler}</span>
     <%--  <input type="text" id="roler" name="roler" value="${data.roler}"> --%>
     </div>
     <div>
       <button id="btn_modify" onclick="history1()">返回</button>
      <!-- <input type="submit" id="sub" value="提交"> -->
     </div>
 <!--   </form>
   </div> -->
   
     
   <%--   <input type="submit" onclick="btn_modify(${data.username})"> --%>
     
</body>
</html>