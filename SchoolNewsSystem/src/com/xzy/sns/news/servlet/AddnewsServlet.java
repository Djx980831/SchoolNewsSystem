package com.xzy.sns.news.servlet;

import java.io.IOException;
import java.sql.Date;

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
 * 控制添加news操作
 * @author xuzhiyuan
 *
 */
@WebServlet("/addnews")
public class AddnewsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//解决post提交方式中文乱码问题
		request.setCharacterEncoding("UTF-8");
		
		//获取请求参数
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
	/*	System.out.println(type);*/
		
		//获取当前时期
		Date date=new Date(System.currentTimeMillis());
		
		News news=new News(title,type,source,date,content);
		NewsDao newsDao=new NewsDaoImpl();
		NewsService service=new NewsServiceImpl(newsDao);
		
		//添加news
		int result=service.addNews(news);
		
		//若添加成功则跳转到cms.jsp
		if(result==1) {
			
			response.sendRedirect(request.getContextPath()+"/cms.jsp");
			
		}
		
	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
