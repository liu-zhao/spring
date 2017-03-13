<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>This is my system!</title>
</head>
<frameset rows="80,*" frameborder="0" border="0" framespacing="0">
  <frame name="topNav" src="<%=path%>/header">
<frameset cols="200,*" frameborder="0" border="0" framespacing="0">
	<frame name="menu" src="<%=path%>/menu" marginheight="0" marginwidth="0" scrolling="auto" noresize>
	<frame name="content" src="<%=path%>/content" marginheight="0" marginwidth="0" scrolling="auto" noresize>
</frameset>
</frameset>
</html>