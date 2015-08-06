package com.sanqing.Listener;

import java.util.ArrayList;  

import javax.servlet.ServletContext;  
import javax.servlet.http.HttpSessionAttributeListener;  
import javax.servlet.http.HttpSessionBindingEvent;  
import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  

public class onlineListener implements HttpSessionListener,  
HttpSessionAttributeListener {  
// 参数  
ServletContext sc;  
ArrayList list = new ArrayList();  

// 新建一个session时触发此操作  
public void sessionCreated(HttpSessionEvent se) {  
sc = se.getSession().getServletContext();   
}  

// 销毁一个session时触发此操作  
public void sessionDestroyed(HttpSessionEvent se) {  

if (!list.isEmpty()) {  
    list.remove((String) se.getSession().getAttribute("Name"));  
   
}  
}  

// 在session中添加对象时触发此操作，在list中添加一个对象  
public void attributeAdded(HttpSessionBindingEvent sbe) {  
list.add((String) sbe.getValue()); 

 

sc.setAttribute("list", list);  
}  

// 修改、删除session中添加对象时触发此操作  
public void attributeRemoved(HttpSessionBindingEvent arg0) {  
  
 
}  

public void attributeReplaced(HttpSessionBindingEvent arg0) {  
 
}  
}  