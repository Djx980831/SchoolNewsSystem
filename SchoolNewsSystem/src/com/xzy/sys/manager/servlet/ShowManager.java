package com.xzy.sys.manager.servlet;

import java.io.IOException;
import java.util.List;

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
 * 控制查询管理员信息
 * @author xuzhiyuan
 *
 */
@WebServlet("/showManager")
public class ShowManager extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
	    String page=request.getParameter("pageNum");
	    
	    //默认请求页数为0
	    int pageNum=0;
	    if(page!=null) {
	    	
	    	pageNum=Integer.parseInt(page);
	    	
	    }
	    
		ManagerDao dao=new ManagerDaoImpl();
		ManagerService service=new ManagerServiceImple(dao);
	    
	    //获取总页数
	    int totalPageNum=service.queryTotalPageNums();
	    
	    if(pageNum<0) {
	    	
	    	pageNum=0;
	 
	    }
	    
	    if(pageNum>=totalPageNum) {
	    	
	    	pageNum=totalPageNum-1;
	    	
	    }
		
		List<Manager> managers=null;
		managers=service.queryManagers(pageNum);
		
		//将查询结果放入session域中
		HttpSession session=request.getSession();
		session.setAttribute("managers",managers);
		session.setAttribute("pageNum2", pageNum);
		
	}


}
