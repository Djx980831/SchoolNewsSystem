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
 * 控制跳转到newsContent.jsp页面
 * @author xuzhiyuan
 *
 */
@WebServlet("/showNewsContent")
public class ShowNewsContent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		int nid=Integer.parseInt(request.getParameter("nid"));
		int type=Integer.parseInt(request.getParameter("type"));
		
		HttpSession session=request.getSession(false);
		List<News> newes=null;
		if(session!=null) {

			switch (type) {
			case 1:
				newes=(List<News>) session.getAttribute("type1newes");
				break;
			case 2:
				newes=(List<News>) session.getAttribute("type2newes");
				break;
			case 3:
				newes=(List<News>) session.getAttribute("type3newes");
				break;
			default:
				newes=(List<News>) session.getAttribute("type4newes");
				break;
			}
			
		}
		
		News news1=null;
		
		for(News news:newes) {
			
			if(news.getNid()==nid) {
				
				news1=news;
				
			}
			
		}
		
		session.setAttribute("news1", news1);
		//跳转到newsContent.jsp页面
		response.sendRedirect(request.getContextPath()+"/newsContent.jsp");
		
	}


}
