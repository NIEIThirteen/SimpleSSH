<%@ page import="po.User" %>
<%@ page import="po.Sign" %>
<%@ page import="po.Class" %>
 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
<%@taglib prefix="s" uri="/struts-tags"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'signIndex.jsp' starting page</title>
    
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
		</div>
     </div>
     
	<div id="section">
		<div>
        
				
            
	      <table width="100%" border="1">
		      <tr class="header">
		        <td>序号</td>
		        <td>学员</td>
		        <td>班级</td>
		        <td>考勤日期</td>
		        <td>签到时间</td>
                <td>签退时间</td>
	        </tr>
	        <%
	        List<Sign> signlist=(List<Sign>)request.getAttribute("signlists");
	        List<Class> classlist=(List<Class>)request.getAttribute("classlists");
	        List<User> userlist=(List<User>)request.getAttribute("userlists");
	       	String classname="";
   				for(int i=0;i<signlist.size();i++){
   					for(int j=0;j<userlist.size();j++){
   						if(signlist.get(i).getUsername().equals(userlist.get(j).getUsername())){
   							int s=userlist.get(j).getClassid();
   							for(int k=0;k<classlist.size();k++){
   							if(classlist.get(k).getClassid()==(s)){
   								classname=classlist.get(k).getClassname();
   							}
   						}}
   					}
   					out.print("<tr><td>"+signlist.get(i).getUsername()+"</td>");
   					out.print("<td>"+signlist.get(i).getName()+"</td>");
   					out.print("<td>"+classname+"</td>");
   					out.print("<td>"+signlist.get(i).getDate()+"</td>");
   					out.print("<td>"+signlist.get(i).getTimein()+"</td>");
   					out.print("<td>"+signlist.get(i).getTimeout()+"</td>  </tr>");}
   					
	         %>
		      
	      </table>
		</div>
	</div>
	
  </body>
</html>
