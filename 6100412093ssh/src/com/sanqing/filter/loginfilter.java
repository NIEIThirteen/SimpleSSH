package com.sanqing.filter;
import java.io.IOException;
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
 
public class loginfilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			          FilterChain chain) throws IOException, ServletException {
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		String path = servletRequest.getRequestURI();
		String empId = (String) session.getAttribute("Name");
			 // 登陆页面无需过滤
		if(path.indexOf("/login.jsp") > -1||path.indexOf("/index.jsp") > -1||path.indexOf("/register.jsp")>-1) {
			 chain.doFilter(servletRequest, servletResponse);
			return;
		}
		if (empId == null || "".equals(empId)) {
			servletResponse.sendRedirect("login.jsp");
		} else {
		chain.doFilter(request, response);
		
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
