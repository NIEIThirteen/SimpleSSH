package com.sanqing.Listener;

import java.util.ArrayList;  

import javax.servlet.ServletContext;  
import javax.servlet.http.HttpSessionAttributeListener;  
import javax.servlet.http.HttpSessionBindingEvent;  
import javax.servlet.http.HttpSessionEvent;  
import javax.servlet.http.HttpSessionListener;  

public class onlineListener implements HttpSessionListener,  
HttpSessionAttributeListener {  
// ����  
ServletContext sc;  
ArrayList list = new ArrayList();  

// �½�һ��sessionʱ�����˲���  
public void sessionCreated(HttpSessionEvent se) {  
sc = se.getSession().getServletContext();   
}  

// ����һ��sessionʱ�����˲���  
public void sessionDestroyed(HttpSessionEvent se) {  

if (!list.isEmpty()) {  
    list.remove((String) se.getSession().getAttribute("Name"));  
   
}  
}  

// ��session����Ӷ���ʱ�����˲�������list�����һ������  
public void attributeAdded(HttpSessionBindingEvent sbe) {  
list.add((String) sbe.getValue()); 

 

sc.setAttribute("list", list);  
}  

// �޸ġ�ɾ��session����Ӷ���ʱ�����˲���  
public void attributeRemoved(HttpSessionBindingEvent arg0) {  
  
 
}  

public void attributeReplaced(HttpSessionBindingEvent arg0) {  
 
}  
}  