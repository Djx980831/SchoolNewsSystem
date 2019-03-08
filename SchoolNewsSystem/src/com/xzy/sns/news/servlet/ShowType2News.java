package com.xzy.sns.news.servlet;

import java.io.IOException;
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

@WebServlet("/showType2News")
public class ShowType2News extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		NewsDao dao=new NewsDaoImpl();
		NewsService service=new NewsServiceImpl(dao);
		
		//获取请求参数
		char type=request.getParameter("type").charAt(0);
		String flag=request.getParameter("flag");
		
		//初始页数为0
		int pageNum=0;
		//获取请求跳转的页数
		String page=request.getParameter("page");
		
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
		
		List<News> type2newes=service.showNews(pageNum, type);
		
		News news=new News();
	/*	Iterator<News> it=type2newes.iterator();
		while(it.hasNext()) {
			
			news=it.next();
			System.out.println(news);
			
		}	*/
		
		HttpSession session=request.getSession(); 
		session.setAttribute("type2newes", type2newes);
		session.setAttribute("page2", pageNum);
		
		if(flag!=null) {
			
			request.getRequestDispatcher("/newsDetail.jsp").forward(request, response);
			
		}
		
	}


}
