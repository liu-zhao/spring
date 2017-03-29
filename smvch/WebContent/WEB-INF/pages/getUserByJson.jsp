<%@page import="com.le.ac.project.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
out.println(path);
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
<script src="../js/jquery-3.1.1.min.js" type="text/javascript"></script>
<script src="../js/bootstrap.min.js" type="text/javascript"></script>
<script>        
	var deleteUser=[];
   function sendId()
   {
	   var rows = document.getElementById("example_table").rows.length;
	}
</script>  


<body onload="getUser()">

<div class="container">
          
          <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">用户查看</div>
	<form action="<%=path%>/user/deleteList" method="post">
	 <script type="text/javascript">
    $(function(){
        //$('table tr:not(:first)').remove();
        var len = $('table tr').length;
        for(var i = 1;i<len;i++){
            $('table tr:eq('+i+') td:first').text(i);
        }
            
});
    </script>
  <!-- Table -->
  <table class="table" id="table">
   <tr>
    <td>#</td>
    <td>用户名</td>
    <td>email</td>
    <td>电话号</td>
    <td>用户角色</td>
    <td>用户状态</td>
    <td>操作</td>
    </tr>
   
    <c:forEach var="user" items="${pageList}">
    <tr>
    
    <td></td>
   
    <td><input type="text" id="id-1" hidden="true" value="${user.uid }"/>
    <input type="checkbox" name="checkbox" id ="select" value="${user.uid }" onclick="sendId()">
    </td>
    <td>${user.username}</td>
    <td>${user.email }</td>
    <td>${user.tel }</td>
    <td>
    <c:if test="${user.role ==0}">
    <p>高级管理员</p>
    </c:if>
    <c:if test="${user.role ==10}">
    <p>普通管理员</p>
    </c:if>
    <c:if test="${user.role ==11}">
    <p>普通用户</p>
    </c:if>
    </td>
    <td>
    <c:if test="${user.status ==0}">
    <p>正常</p></c:if>
   </td>
   <td><a href="<%=path%>/user/update?uid=${user.uid}">修改信息</a></td>
   <td>
   <input type="button" id="delete" class="btn btn-info" value="删除" onclick="deleteajax()"></td>
   
    </tr>
    </c:forEach>
   
  </table>
  <input type="submit" class="btn btn-info" value="批量删除"/>
  </form>
   <script type="text/javascript">
   	function getUser()
   	{
   	   var userlist = ${arr};
   		$.each(userlist,function(i,obj){            
        str="index: "+i+" uid: "+obj.uid+" username: "+obj.username;
        $('#showuser').append('<p>'+str+'</p>');
         });	
   	 }
   </script>
   
   <div class="panel-heading">
   <span id="showuser"></span>
   </div>
</div>
</div>
</body>
</html>