package com.xzy.sys.manager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzy.sys.manager.beans.Manager;
import com.xzy.sys.manager.dao.ManagerDao;
import com.xzy.sys.manager.daoImpl.ManagerDaoImpl;
import com.xzy.sys.manager.service.ManagerService;
import com.xzy.sys.manager.serviceImpl.ManagerServiceImple;

@WebServlet("/addManager")
public class AddManagerSevlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//解决post提交方式中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//获取请求参数
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		
		Manager manager=new Manager(username,password,email);
		
		ManagerDao dao=new ManagerDaoImpl();
		ManagerService service=new ManagerServiceImple(dao);
		
		int result=0;
		result=service.createAccount(manager);
		
		//若创建账户成功则跳转到account.jsp
		if(result==1) {
			
			response.sendRedirect(request.getContextPath()+"/account.jsp");
			
		}		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	

}
