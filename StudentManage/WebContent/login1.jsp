<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="style.css">
<link rel="stylesheet" href="fort.css">
<style>
.top-banner {
	background-color: #333;
}
.nav {
	margin-bottom: 30px;
}
.nav li.current a{
	background-color: #009DFF;
	color: #fff;
	padding: 10px;
}
.nav a {
	margin: 5px;	
	color: #333;
	text-decoration: none;
}

.b{background-image:url(images/6.jpg);
style="position:absolute;z-index:-1;width:100%;height:100%;}
</style>
<script src="fort.js"></script>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>学生信息管理系统登录</title>
<script type="text/javascript">
	function resetValue(){
		document.getElementById("userName").value="";
		document.getElementById("password").value="";
	}
</script>
</head>

<body Class="b">
<div class="form-wrapper">
<h1>学生信息管理系统登录</h1>


	<div class="top"><div class="colors"></div></div>
	<div class="nav">
		
	</div>
	<form name="form" action="login">
		<div class="form">
			
			<div class="form-item">
				<input type="text" name="userName" id="userName required="required" placeholder="用户名" autocomplete="off">
			</div>
			<div class="form-item">
				<input type="password" name="password" required="required" placeholder="密码" autocomplete="off">
			</div>
			<div class="button-panel">
				<input type="submit" class="button" title="Login" value="登录">
			</div>
		</div>
	</form>
</div>
<div class="footer-banner" style="width:728px; margin:200px auto 0"></div>
<script>
    solid();
</script>
</body>
</html>