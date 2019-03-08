package com.xzy.sys.manager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xzy.sys.manager.beans.Manager;
import com.xzy.sys.manager.dao.ManagerDao;
import com.xzy.sys.manager.daoImpl.ManagerDaoImpl;
import com.xzy.sys.manager.service.ManagerService;
import com.xzy.sys.manager.serviceImpl.ManagerServiceImple;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//解决post请求中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//获取请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		Manager manager=new Manager();
		manager.setUsername(username);
		manager.setPassword(password);
		
		ManagerDao dao=new ManagerDaoImpl();
		ManagerService service=new ManagerServiceImple(dao);
		
		Manager manager2=null;
		manager2=service.checkLogin(manager);
		
		
		HttpSession session=request.getSession();
		if(manager2.getPassword()!=null && password.equals(manager2.getPassword())) {//若数据中存在manager则登录成功，跳转到cms.jsp
			
			session.setAttribute("manager", manager2);
			response.sendRedirect(request.getContextPath()+"/cms.jsp");
			
		}else {//不存在manager登录失败，跳转到login.html
			
			response.sendRedirect(request.getContextPath()+"/login.html");
			
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
