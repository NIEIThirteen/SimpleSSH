 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
  <%@ page import="po.Class" %>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ page import="po.User" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classIndex.jsp' starting page</title>
    
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
            
	      <table width="100%" border="1">
		      <tr class="header">
				<td>班级代号</td>
		        <td>班级名称</td>
		        <td>修改</td>
		        <td>删除</td>
	        </tr>
	        <%
	        List<Class> classlist=(List<Class>)request.getAttribute("classlist");
	        int pageSize=5;
		     	int pageCount=0;
		     	int pageNow=1;
		     	int rowCount=0;
		     	rowCount=classlist.size();
    			
					pageCount=(rowCount+4)/pageSize;
				
				String s_pageNow=request.getParameter("pageNow");
				if(s_pageNow!=null){
				//接收到了pageNow
				pageNow=Integer.parseInt(s_pageNow);
				}
				if(pageNow!=pageCount){
    				for(int i=0;i<pageSize;i++){
    					Class class1=new Class();
    					int j = i+(pageNow-1)*pageSize;
    					class1=classlist.get(j);
    					out.print("<td>"+class1.getClassid()+"</td>");
    					out.print("<td>"+class1.getClassname()+"</td>");
    					out.print("<td><a href=\"classupdate.jsp?classid="+class1.getClassid()+"\">修改</a></td>");
    					out.print("<td><a href=\"class_delete?classid="+class1.getClassid()+"\">删除</a></td> </tr>");
    				}
    			}else{
    				for(int i=0;i<rowCount-(pageNow-1)*pageSize;i++){
    					Class class1=new Class();
    					int j = i+(pageNow-1)*pageSize;
    					class1=classlist.get(j);
    					out.print("<td>"+class1.getClassid()+"</td>");
    					out.print("<td>"+class1.getClassname()+"</td>");
    					out.print("<td><a href=\"classupdate.jsp?classid="+class1.getClassid()+"\">修改</a></td>");
    					out.print("<td><a href=\"class_delete?classid="+class1.getClassid()+"\">删除</a></td> </tr>");
    				}
    			}
	        
	         %>
		   <%
				//上一页
				if(pageNow!=1){
				out.println("<a href=class_showindex?pageNow="+(pageNow-1)+">上一页</a>");
				}
				//显示超链接
				for(int i=1;i<=pageCount;i++){
				out.println("<a href=class_showindex?pageNow="+i+">["+i+"]</a>");
				}
				//下一页
				if(pageNow!=pageCount){
				out.println("<a href=class_showindex?pageNow="+(pageNow+1)+">下一页</a>");
				}
				%>
	      </table>
		</div>
	</div>
	
  </body>
</html>
