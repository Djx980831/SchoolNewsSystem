package com.xzy.sns.news.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xzy.sns.news.beans.News;
import com.xzy.sns.news.dao.NewsDao;
import com.xzy.sns.utils.JdbcUtils;

public class NewsDaoImpl implements NewsDao {

	PreparedStatement ps=null;
	ResultSet rs=null;
	Connection connection=null;
	
	
	public List<News> selectNews(int start, char type) {

		String sql;
		
		if(type==0) {
			
			//定义sql语句
			sql="select * from news order by date desc limit "+start*10+",10";
			
		}else {
			
			sql="select * from news where type="+type+" order by date desc limit "+start*10+",10";
			
		}
		
		try {
			
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			//执行sql语句
			rs=ps.executeQuery();
			
			//查询将查询的结果封装成news后添加到newes中
			List<News> newes=new ArrayList<>();
			while(rs.next()) {
				
				News news=new News();
				news.setNid(rs.getInt("nid"));
				news.setTitle(rs.getString("title"));
				news.setType(rs.getString("type").charAt(0));
				news.setSource(rs.getString("source"));
				news.setContent(rs.getString("content"));
				news.setDate(rs.getDate("date"));
				
				newes.add(news);
				
			}
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return newes;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	
	public int updateNews(Object news) {
		
		//定义sql语句
		String sql="update news set title=?,type=?,source=?,content=? where nid=?";
		
		try {
			
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			if(news instanceof News) {
				
				ps.setString(1, ((News) news).getTitle());
				ps.setInt(2, ((News) news).getType());
				ps.setString(3,((News) news).getSource());
				ps.setString(4, ((News) news).getContent());
				ps.setInt(5, ((News) news).getNid());
				
			}
			
			//执行sql语句
			int result=ps.executeUpdate();
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	
	public int deleteNews(int nid) {
		
		//定义sql语句
		String sql="delete from news where nid=?";	
		
		try {
			
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			ps.setInt(1, nid);
			
			//执行sql语句
			int result=ps.executeUpdate();
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int insertNews(Object news) {
		
		//定义sql语句
		String sql="insert into news(title,type,source,date,content) values(?,?,?,?,?)";
		
		try {
			
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			if(news instanceof News) {
				
				ps.setString(1, ((News) news).getTitle());
				ps.setString(2, ((News) news).getType().toString());
				ps.setString(3, ((News) news).getSource());
				ps.setDate(4, ((News) news).getDate());
				ps.setString(5, ((News) news).getContent());
				
			}
			
			//执行sql语句
			int result=ps.executeUpdate();
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return result;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}


	@Override
	public int selectNewsNums(char type) {
		
		//定义sql语句
		String sql="select count(*) from news";
		
		if(type!=0) {
			
			sql=sql+" where type="+type;
			
		}
		
		try {
			
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			//执行sql语句
			rs=ps.executeQuery();
			
			//总记录数
			int totalNums=0;
			if(rs.next()) {
				
				totalNums=rs.getInt(1);
				
			}
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			return totalNums;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}


}
