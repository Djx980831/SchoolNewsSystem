package com.xzy.sns.news.serviceImple;

import java.util.List;

import com.xzy.sns.news.beans.News;
import com.xzy.sns.news.dao.NewsDao;
import com.xzy.sns.news.service.NewsService;

public class NewsServiceImpl implements NewsService{

	NewsDao dao;

	public NewsServiceImpl(NewsDao newsdao) {

		dao=newsdao;
		
	}

	@Override
	public List<News> showNews(int start, char type) {
		
		return dao.selectNews(start, type);
	}

	@Override
	public int addNews(News news) {
		
		return dao.insertNews(news);
	}

	@Override
	public int removeNews(int nid) {
		
		return dao.deleteNews(nid);
	}

	@Override
	public int editNews(News news) {
		
		return dao.updateNews(news);
	}

	@Override
	public int getTotalPageNums(char type) {
		
		//news总数
		int totalNums=dao.selectNewsNums(type);
		
		return totalNums%10==0?totalNums/10:(totalNums/10+1);
	}

}
