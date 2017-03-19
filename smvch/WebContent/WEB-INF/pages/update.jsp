<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<link href="../css/bootstrap.min.css" rel="stylesheet">
<link href="../css/dashboard.css" rel="stylesheet">
  <style>
    body {
      padding-top:50px;
    }
    h1 {
      color: #fff;
    }
    #content{
      width:100%;
      min-height:600px;
      background:#444 url(footer.png);
      padding-top:20px;
      color:#FFF;
    }
    .register{
      padding: 20px;
      font-weight:700;
      border:#FFF solid 1px;
      -moz-border-radius: 10px;      /* Gecko browsers */
      -webkit-border-radius: 10px;   /* Webkit browsers */
      border-radius:10px;            /* W3C syntax */
    }
   </style> 

   <script  type="text/javascript">
  /*  function submit1()
   {
	   alert("lala");
	   var url=document.getElementById("form").action;
	   alert(url);
	   } */
	   //jquery 
		 // $("#username").val(); 
		 //js
		//document.getElementsByName("username")
		var s="12312312312"
		var s2='123123123132'
			
function Check()  // 验证表单数据有效性
{
    if (document.send.username.value=="")
    {
        window.alert('请输入用户名!');
        alert("lalala !");
        return false;
    }
    if (document.send.username.value.length<3)
    {
        window.alert('用户名长度必须大于3!');
        return false;
    }
    if (document.send.password.value=="")
    {
        alert('请输入密码!');
        return false;
    }
    if (document.send.password.value.length<3)
    {
        alert('密码长度必须大于3!');
        return false;
    }
    if (document.send.password.value!= document.send.chkpwd.value)
    {
        alert('确认密码与密码不一致!');
        return false;
    }
    if (document.send.email.value=="")
    {
        alert('请输入Email!');
        return false;
    }
    //js  String 一个字符串是否包含另一个字符
    //str.indexOf("目标字符串")  当返回值为-1时候 表示没有; 其他值表示有
    //123@456 
    //str.indexOf("@")=3
    if(document.send.email.value.indexOf("@")==-1)
    {
        alert('请输入有效的email地址!'); return false;
    }
       if (document.send.authcode.value=="")
    {
        alert('请输入手机号!');
        return false;
    }
    return true;
}
</script>
<body>
<div id="content">
  <div class="container">
    <form  id="form" action="<%=path%>/user/updateUser" method="post" class="form-horizontal" onSubmit="return Check()" name="send">
      <div class="row">
        <h1 class="col-md-6 col-md-offset-3 col-xs-10 col-xs-offset-1 page_title ">修改信息</h1>
      </div>
      <input type="text" id="id" name="uid" style="display: false" value="${user.uid }"/>
      <div class="col-md-6 col-md-offset-3 col-xs-10 col-xs-offset-1 register">
            <div class="form-group">
              <label for="username" class="col-sm-3 control-label">用户名:</label>
              <div class="col-sm-8">
                <div class="input-group">
                <input type="text" class="form-control" name="username" value="${user.username }">
               <div class="input-group-addon">
               <span class="glyphicon glyphicon-user"></span>
               </div>
             </div>
            </div>
            </div>
            <div class="form-group">
              <label for="password" class="col-sm-3 control-label">密码：</label>
              <div class="col-sm-8">
                <div class="input-group">
                <input type="text" class="form-control" name="password" value=${user.password }">
               <div class="input-group-addon">
               <span class="glyphicon glyphicon-lock"></span>
               </div>
             </div>
            </div>
            </div>
           
            <div class="form-group">
              <label for="email" class="col-sm-3 control-label">邮箱：</label>
              <div class="col-sm-8">
                <div class="input-group">
                <input type="text" class="form-control" name="email" value="${user.email }">
               <div class="input-group-addon">
               <span class="glyphicon glyphicon-envelope"></span>
               </div>
             </div>
            </div>
            </div>
            <div class="form-group">
              <label for="authcode" class="col-sm-3 control-label">手机号：</label>
              <div class="col-sm-5">
                <div class="input-group">
                <input type="text" class="form-control" name="authcode" placeholder="请输入手机号">
                </div>
               <div class="input-group-addon">
               <span class="glyphicon glyphicon-ok"></span>
               </div>
            </div>
            </div>
           <%--  <label for="authcode_img" class="control-label col-sm-1" style="padding-top: 0px;">
                <a class="btn btn-default" href="javascript:void(0)" onclick="document.getElementById('captcha_img').src='authcode.php?r'+Math.random()" title="换一个" ><img id="captcha_img" src="authcode.php?r=<?php echo rand();?>" alt="验证码"></a>
            </label> --%>
            </div>
    <div class="row">
        <div class="col-md-3 col-md-offset-3 col-xs-12">
            <button type="reset" class="btn btn-default btn-block"><b>&nbsp&nbsp清空&nbsp&nbsp</b>
              <span class="glyphicon glyphicon-remove"></span></button>
        </div>
        <div class="col-md-3 col-xs-12">
            <button type="submit" class="btn btn-info btn-block" ><b>&nbsp&nbsp提交&nbsp&nbsp</b>
            <span class="glyphicon glyphicon-arrow-right"></span></button>
        </div>
        </div>
    </form>
  </div>
</div>

</body>
</html>