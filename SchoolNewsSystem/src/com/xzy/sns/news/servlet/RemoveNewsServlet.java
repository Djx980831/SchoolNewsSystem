package com.xzy.sns.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzy.sns.news.dao.NewsDao;
import com.xzy.sns.news.daoimpl.NewsDaoImpl;
import com.xzy.sns.news.service.NewsService;
import com.xzy.sns.news.serviceImple.NewsServiceImpl;

/**
 * 控制删除指定nid的news
 * @author xuzhiyuan
 *
 */
@WebServlet("/removeNews")
public class RemoveNewsServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请参数nid
		int nid=Integer.parseInt(request.getParameter("nid"));
		
		NewsDao newsDao=new NewsDaoImpl();
		NewsService service=new NewsServiceImpl(newsDao);
		//执行删除操作
		int result=service.removeNews(nid);
		
		//若成功删除
		if(result==1) {
			
			response.sendRedirect(request.getContextPath()+"/cms.jsp");
			
		}
		
		
	}


}
