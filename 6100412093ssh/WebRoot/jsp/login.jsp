<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    <meta charset="utf-8" />
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="styles/main.css" type="text/css" />
  </head>
  
  <body>
  			<%  
                session = request.getSession(false);  
      
                if (session != null){  
                    session.invalidate();  }
            %>
    <div id="login">
		<form action="dengluu" method="post">
			<fieldset>
				<legend>用户登录</legend>
			<input type="text" placeholder="用户账号" name="username"/><br>
			<input type="password" placeholder="用户密码" name="upassword"/><br>
			<input type="submit" value="登录" class="btn">
			<a href="user_register"  class="btn">注册</a>
			</fieldset>
		</form>
	</div>
  </body>
</html>
