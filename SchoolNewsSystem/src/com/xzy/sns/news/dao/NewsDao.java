package com.xzy.sns.news.dao;

import java.util.List;

/**
 * 对数据中news表进行增删改查操作
 * @author xuzhiyuan
 * @param <News>
 *
 */
public interface NewsDao<News> {
	
	//对指定类型，和起始页数的news进行查询
	public List<News> selectNews(int start,char type);
	
	//对于指定nid的news进行修改
	public int updateNews(News news);
	
	//删除指定nid的news
	public int deleteNews(int nid);
	
	//增加news
	public int insertNews(News news);

	//查询news条数
	public int selectNewsNums(char type);

}
