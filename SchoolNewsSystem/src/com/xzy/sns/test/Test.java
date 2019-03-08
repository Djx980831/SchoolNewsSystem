package com.xzy.sns.test;

import java.util.Iterator;
import java.util.List;

import com.xzy.sns.news.beans.News;
import com.xzy.sns.news.dao.NewsDao;
import com.xzy.sns.news.daoimpl.NewsDaoImpl;
import com.xzy.sns.news.service.NewsService;
import com.xzy.sns.news.serviceImple.NewsServiceImpl;

public class Test {
	
	public static void main(String[] args) {
		
		NewsDao newsdao=new NewsDaoImpl();
		NewsService service=new NewsServiceImpl(newsdao);
		
		char type=0;
		List<News> newes=service.showNews(0, type);
		News news=new News();
		Iterator<News> it=newes.iterator();
		while(it.hasNext()) {
			
			news=it.next();
			System.out.println(news);
			
		}	
	}

}
