<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
 <%@ page import="po.User" %>
<%@ page import="po.Sign" %>
<%@ page import="po.Class" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'studentIndex.jsp' starting page</title>
    
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
		</div></div>
	<div id="section">
		<div>
        <h3>学员管理</h3>
			<form>
				<fieldset>
					<legend>查询学员</legend>
				<input type="text" placeholder="学员名称">
				<input type="submit" value="查询"  class="btn">
				</fieldset>
			</form>
            
	      <table width="100%" border="1">
		      <tr class="header">
		        <td>头像</td>
		        <td>学员名字</td>
		        <td>班级名称</td>

	        <%	
	        	int pageSize=2;
		     	int pageCount=0;
		     	int pageNow=1;
		     	int rowCount=0;
	        	User user=new User();
   				Class class1=new Class();
   				List<Class> classlist=(List<Class>)request.getAttribute("classlist1");
	        	List<User> userlist=(List<User>)request.getAttribute("userlist1");
   				rowCount=userlist.size();
    			pageCount=(rowCount+1)/pageSize;
				String s_pageNow=request.getParameter("pageNow");
				if(s_pageNow!=null){
				//接收到了pageNow
				pageNow=Integer.parseInt(s_pageNow);
				}
				if(pageNow!=pageCount){
   				for(int i=0;i<pageSize;i++){
   					int k=i+(pageNow-1)*pageSize;
   					user=userlist.get(k);
   					String a="" ;
   					for(int j=0;j<classlist.size();j++){
   						class1=classlist.get(j);
   						if(user.getClassid()==class1.getClassid()){
   							a=class1.getClassname();
   						}
   					}
   					out.print("</tr><tr><td><img src=\"images/logo.jpg\" style=\"width:100px;height:100px\"/></td>");
   					out.print("<td><a href=\"user_view?username="+user.getUsername()+"\">"+user.getName()+"</a></td>");
   					out.print("<td>"+a+"</td>");
   				}
   				}else{
   				for(int i=0;i<rowCount-(pageNow-1)*pageSize;i++){
   					int k=i+(pageNow-1)*pageSize;
   					user=userlist.get(k);
   					String a="" ;
   					for(int j=0;j<classlist.size();j++){
   						class1=classlist.get(j);
   						if(user.getClassid()==class1.getClassid()){
   							a=class1.getClassname();
   						}
   					}
   					out.print("</tr><tr><td><img src=\"images/logo.jpg\" style=\"width:100px;height:100px\"/></td>");
   					out.print("<td><a href=\"user_view?username="+user.getUsername()+"\">"+user.getName()+"</a></td>");
   					out.print("<td>"+a+"</td>");
   				}
   				}
	         %>
	          <%
				//上一页
				if(pageNow!=1){
				out.println("<a href=user_studentindex?pageNow="+(pageNow-1)+">上一页</a>");
				}
				//显示超链接
				for(int i=1;i<=pageCount;i++){
				out.println("<a href=user_studentindex?pageNow="+i+">["+i+"]</a>");
				}
				//下一页
				if(pageNow!=pageCount){
				out.println("<a href=user_studentindex?pageNow="+(pageNow+1)+">下一页</a>");
				}
				%>
	      </table>
		</div>
	</div>
  </body>
</html>
