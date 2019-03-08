package com.xzy.sns.news.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 确定是那中newsType的请求，然后将请求转发到对应的showNewsType1,2,3,4.servlet
 * @author xuzhiyuan
 *
 */

@WebServlet("/requestType")
public class RequestType extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取请求参数
		int type=Integer.parseInt(request.getParameter("type"));
		
		switch (type) {
		case 1:
			request.getRequestDispatcher("/showType1News").forward(request, response);
			break;
		case 2:
			request.getRequestDispatcher("/showType2News").forward(request, response);
			break;
		case 3:
			request.getRequestDispatcher("/showType3News").forward(request, response);
			break;

		default:
			request.getRequestDispatcher("/showType4News").forward(request, response);
			break;
		}
		
	}

}
