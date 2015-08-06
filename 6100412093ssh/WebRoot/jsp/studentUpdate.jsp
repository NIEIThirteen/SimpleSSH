<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentUpdate.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" href="styles/main.css" type="text/css" />

  </head>
  
  <body>
   <div id="header">
		<div><h1 class="logo">南昌大学学员考勤系统</h1>
		<div class="home"><%="欢迎您"+"	"+session.getAttribute("Name") %>
		<a href="jsp/adminHome.jsp">首页</a><a href="jsp/login.jsp">退出</a></div></div>
	</div>
	<div id="aside">
     <!--管理员菜单-->
		<div class="menu">
<ul>
            <li>班级管理    
              <ul>
                <li><a href="class_showindex">查看班级</a></li>
                <li><a href="jsp/classupdate.jsp">增加班级</a></li>
              </ul>
            </li>
            <li>学员管理    
              <ul>
                <li><a href="user_studentindex">查看学员</a></li>
              </ul>
            </li>
            <li>考勤管理    
              <ul>
                <li><a href="sign_indexshow">查看出勤信息</a></li>
              </ul>
            </li>
			<li>个人中心  
              <ul>
                <li><a href="jsp/studentUpdate.jsp">修改个人信息</a></li>
              </ul>
            </li>
          </ul>
		</div>
	</div>
	<div id="section">
		<div>
        <h3>学员管理</h3>
			<form action="user_update" method="post">
				<fieldset>
					<legend>修改个人信息</legend><br>
			<input type="text" placeholder="用户" name="username"><br>
			<input type="password" placeholder="用户密码" name="password"><br>
            <select name="sex">
          <option>男</option>
          <option>女</option>
          </select><br>
          <textarea placeholder="个性签名" ></textarea><br>
          <input type="file" name="fileField" id="fileField"><br>
          <fieldset>
					<legend>爱好</legend>
          <label>
            <input type="checkbox" name="hobby" value="关我屁事" id="hobby_0">
            复选框</label>
          <br>
          <label>
            <input type="checkbox" name="hobby" value="告诉你哥哥写了这个" id="hobby_1">
            复选框</label>
            </fieldset>
			<br>
				<input type="submit" value="修改" class="btn">
				</fieldset>
			</form>
		</div>
	</div>
	
  </body>
</html>
