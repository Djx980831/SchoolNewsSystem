package com.xzy.sns.news.service;

import java.util.List;

import com.xzy.sns.news.beans.News;

public interface NewsService {
	
	//展示指定页数，指定类型的news
	public List<News> showNews(int start,char type);
	
	//添加新闻
	public int addNews(News news);
	
	//删除新闻
	public int removeNews(int nid);
	
	//修改新闻
	public int editNews(News news);

	//获取总页数
	public int getTotalPageNums(char type);

}
