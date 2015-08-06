 <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> 
  <%@ page import="po.Class" %>
<%@ page import="po.Sign" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <link rel="stylesheet" href="styles/main.css" type="text/css" />

  </head>
  
  <body>
 
   <div id="login">
		<form action="user_registerConf" method="post">
			<fieldset>
				<legend>用户注册</legend>
			<input type="text" placeholder="用户账号" name="username"><br>
			<input type="password" placeholder="用户密码" name="password"><br>
			<input type="password" placeholder="确认密码" name="upassword"><br>
			<input type="text" placeholder="姓名" name="name"><br>
            <select name="classname">
            <%
             List<Class> classlist=(List<Class>)request.getAttribute("registerclasslist");
            	for(int i=0;i<classlist.size();i++){
            		 	Class classs=new Class();
            		 	classs=classlist.get(i);
            			out.print("<option >"+classs.getClassname()+"</option>");
            		
            	}
             %>
            </select><br/>
			<input type="submit" value="注册"  class="btn">
			<a href="jsp/login.jsp"  class="btn">返回</a>
			</fieldset>
		</form>
	</div>
  </body>
</html>
