package com.xzy.sns.news.servlet;

import java.io.IOException;
import java.net.Authenticator.RequestorType;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xzy.sns.news.beans.News;
import com.xzy.sns.news.dao.NewsDao;
import com.xzy.sns.news.daoimpl.NewsDaoImpl;
import com.xzy.sns.news.service.NewsService;
import com.xzy.sns.news.serviceImple.NewsServiceImpl;

/**
 * Servlet implementation class ShowNewServlet
 */
@WebServlet("/showNews")
public class ShowNewsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		NewsDao dao=new NewsDaoImpl();
		NewsService service=new NewsServiceImpl(dao);
		
		//初始页数为0
		int pageNum=0;
		char type=0;
		//获取请求跳转的页数
		String page=request.getParameter("pageNum");
		String newsType=request.getParameter("type");
		
		if(newsType!=null) {
			
			type=newsType.charAt(0);
			
		}
		
		if(page==null) {//如果为空说明初次访问，默认显示首页
			
			pageNum=0;
			
		}else {
			
			pageNum=Integer.parseInt(page);
			
		}
		
		//获取总页数
		int totalPageNum=service.getTotalPageNums(type);
		
		//若请求页数小于0,则当做请求0页
		if(pageNum<0) {
			
			pageNum=0;
			
		}
		
		//若请求页数大于总页数，则跳转到最后一页
		if(pageNum>=totalPageNum) {
			
			pageNum=totalPageNum-1;
			
		}
		
		List<News> newes=service.showNews(pageNum, type);
		
		News news=new News();
/*		Iterator<News> it=newes.iterator();
		while(it.hasNext()) {
			
			news=it.next();
			System.out.println(news);
			
		}	*/
		
		HttpSession session=request.getSession(); 
		session.setAttribute("newes", newes);
		session.setAttribute("pageNum", pageNum);
		
	}
	
}
