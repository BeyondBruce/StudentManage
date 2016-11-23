<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body background="image/1.jpg" >
   
    <form action="login.action" method="post" >

		<div style="width:400px;padding:30px 60px" >

			<div style="margin-bottom:20px" >
				<div>用户名:</div>
				<input style="width:100%;height:40px" name="username" />
			</div>
			<div style="margin-bottom:20px" >
				<div>密 码:</div>
				<input style="width:100%;height:40px" name="password" />
			</div>

			<div>
				<input type="submit" value="登陆" style="width:100%;height:40px"/>

			</div>
		</div>
	</form>

  </body>
</html>
