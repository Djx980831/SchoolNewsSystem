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

/**
 * 展示请求类型news
 * @author xuzhiyuan
 *
 */
@WebServlet("/showTypeNews")
public class ShowTypeNews extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//获取请参数
		String type=request.getParameter("type");
		String flag=request.getParameter("flag");
		
		//新闻的类型
		int newsType=0;
		if(type==null) {
			
			newsType=1;
			
		}else {
			
			newsType=Integer.parseInt(type);
			
		}
		
		//请求type类型的news的页面当前页数
		int page=0;
		List<News> newes=null;
		HttpSession session=request.getSession(false);
		if(session!=null) {
			
			switch (newsType) {
			case 1:
				newes=(List<News>) session.getAttribute("type1newes");
				page=(int) session.getAttribute("page1");
				break;
			case 2:
				newes=(List<News>) session.getAttribute("type2newes");
				page=(int) session.getAttribute("page2");
				break;
			case 3:
				newes=(List<News>) session.getAttribute("type3newes");
				page=(int) session.getAttribute("page3");
				break;
			default:
				newes=(List<News>) session.getAttribute("type4newes");
				page=(int) session.getAttribute("page4");
				break;
			}
			
		}
		
		session.setAttribute("page", page);
		session.setAttribute("newsType", newsType);
		session.setAttribute("typenewes", newes);
		
	}

}
