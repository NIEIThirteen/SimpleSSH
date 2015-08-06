 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
  <%@ page import="po.Class" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classupdate.jsp' starting page</title>
    
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
		<a href="jsp/adminHome.jsp">首页</a>
		<a href="jsp/login.jsp">退出</a></div></div>
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
		</div></div>
	<div id="section">
		<div>
        <h3>班级管理</h3>
			<form action="class_add" method="post">
			
				<fieldset>
					<legend>增加班级</legend>
				<input type="text" placeholder="班级编号"
				 name="classid"/><br>
				<input type="text" placeholder="班级名称" name="classname"/><br>
				<input type="submit" value="增加" class="btn">
				</fieldset>
			</form>
		</div>
	</div>
  </body>
</html>
