<%@page import="com.le.ac.project.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
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


<body>

<div class="container">
          
          <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">用户查看</div>

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
    <td><input type="text" id="id" hidden="true" value="${user.uid }"/>
    <input type="checkbox" id ="select" onclick="sendId()">
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
    </tr>
    </c:forEach>
   
  </table>
</div>
</div>
</body>
</html>