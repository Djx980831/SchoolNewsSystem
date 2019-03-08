package com.xzy.sns.filter;


import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xzy.sys.manager.beans.Manager;

@WebFilter("/*")
public class ManagerFilter  implements Filter {
       
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//获取请求的uri
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse rep=(HttpServletResponse)response;
		String uri=req.getRequestURI();

		
		HttpSession session=req.getSession(false);
		//若请求的uri不是"/SchoolNewsSystem/account.jsp"并且"/SchoolNewsSystem/cms.jsp"的话则放行
		if(!"/SchoolNewsSystem/account.jsp".equals(uri)&&!"/SchoolNewsSystem/cms.jsp".equals(uri)) {
			
			chain.doFilter(req, rep);
			
		}else {//请求uri是"/SchoolNewsSystem/account.jsp"或者"/SchoolNewsSystem/cms.jsp"，则判断是否登录
			
			if(session==null) {//若没登录，跳转到login.html登录页面
				
				rep.sendRedirect(req.getContextPath()+"/login.html");
				
			}else {
				
				Manager manager=(Manager) session.getAttribute("manager");
				
				if(manager!=null) {//若登录则放行
					
					chain.doFilter(req, rep);
					
				}else {//若没登录则跳转到login.html
					
					rep.sendRedirect(req.getContextPath()+"/login.html");
					
				}
				
			}
			
		}
	}


	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
