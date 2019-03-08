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

/**
 * 修改账号密码
 * @author xuzhiyuan
 *
 */
@WebServlet("/modifyAccount")
public class ModifyAccountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		int mid=Integer.parseInt(request.getParameter("mid"));
		String oldPassword=request.getParameter("oldPassword");
		String newPassword=request.getParameter("newPassword");
		
		Manager manager=new Manager();
		manager.setMid(mid);
		manager.setPassword(newPassword);
		
		System.out.println(manager.getMid());
		
		ManagerDao dao=new ManagerDaoImpl();
		ManagerService service=new ManagerServiceImple(dao);
		
		int result=0;
		Manager manager1 =null;
		result=service.modifyAccount(manager);
		HttpSession session=request.getSession(false);
		if(result==1) {//若修改成功,跳转到account.jsp
			
			manager1=service.queryManager(mid);
			session.setAttribute("manager", manager1);
			response.sendRedirect(request.getContextPath()+"/account.jsp");
			
		}else {//若修改成功,跳转到account.jsp
			
			response.sendRedirect(request.getContextPath()+"/account.jsp");
			
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
