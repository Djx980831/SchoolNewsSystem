package com.xzy.sys.manager.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzy.sys.manager.dao.ManagerDao;
import com.xzy.sys.manager.daoImpl.ManagerDaoImpl;
import com.xzy.sys.manager.service.ManagerService;
import com.xzy.sys.manager.serviceImpl.ManagerServiceImple;

/**
 * 控制删除指定manager账号
 * @author xuzhiyuan
 *
 */
@WebServlet("/removeManager")
public class RemoveManagerServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		int mid=Integer.parseInt(request.getParameter("mid"));
		
		ManagerDao dao=new ManagerDaoImpl();
		ManagerService service=new ManagerServiceImple(dao);
		
		int result=0;
		result=service.removeAccount(mid);
		
		//若删除成功则跳转到acctount.jsp
		if(result==1) {
			
			response.sendRedirect(request.getContextPath()+"/account.jsp");
			
		}
		
	}

}
