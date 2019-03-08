package com.xzy.sns.news.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xzy.sns.news.beans.News;
import com.xzy.sns.news.dao.NewsDao;
import com.xzy.sns.news.daoimpl.NewsDaoImpl;
import com.xzy.sns.news.service.NewsService;
import com.xzy.sns.news.serviceImple.NewsServiceImpl;

/**
 * 编辑news
 * @author xuzhiyuan
 *
 */
@WebServlet("/editNews")
public class EditNewsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//解决post提交方式产生中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//获取请求参数
		int nid=Integer.parseInt(request.getParameter("nid"));
		String title=request.getParameter("title");
		String source=request.getParameter("source");
		String newstype=request.getParameter("type");
		String content=request.getParameter("content");
		
		//去掉content中的<p>
		if(content.contains("<p>")) {
			
			content=content.replace("<p>", "");
			
		}
		
		//去掉content中的</p>
		if(content.contains("</p>")) {
			
			content=content.replace("</p>", "");
			
		}
		
		char type=newstype.charAt(0);
		
		News news=new News();
		news.setNid(nid);
		news.setContent(content);
		news.setTitle(title);
		news.setType(type);
		news.setSource(source);
		NewsDao newsDao=new NewsDaoImpl();
		NewsService service=new NewsServiceImpl(newsDao);
		
		//编辑news
		int result=service.editNews(news);
		
		//若编辑成功则跳转到cms.jsp
		if(result==1) {
			
			response.sendRedirect(request.getContextPath()+"/cms.jsp");
			
		}
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
