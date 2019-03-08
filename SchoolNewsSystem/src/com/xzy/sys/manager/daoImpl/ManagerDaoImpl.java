package com.xzy.sys.manager.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.xzy.sns.utils.JdbcUtils;
import com.xzy.sys.manager.beans.Manager;
import com.xzy.sys.manager.dao.ManagerDao;

public class ManagerDaoImpl implements ManagerDao{

	Connection connection;
	PreparedStatement ps;
	ResultSet rs;
	
	@Override
	public int insertManager(Manager manager) {
		
		//定义sql语句
		String sql="insert into manager(username,password,email) values(?,?,?)";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			ps.setString(1, manager.getUsername());
			ps.setString(2, manager.getPassword());
			ps.setString(3, manager.getEmail());
			
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
	public int deleteManager(int mid) {
		
		//定义sql语句
		String sql="delete from manager where mid=?";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			ps.setInt(1, mid);
			
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
	public int updateManager(Manager manager) {
		
		//定义sql语句
		String sql="update manager set password=? where mid=?";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			ps.setString(1, manager.getPassword());
			ps.setInt(2, manager.getMid());
			
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
	public List<Manager> selectManagers(int pageNum) {
		
		//定义sql语句
		String sql="select * from manager limit "+pageNum*10+",10";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			//执行sql语句
			rs=ps.executeQuery();
			
			List<Manager> managers=new ArrayList<>();
			while(rs.next()) {
				
				Manager manager=new Manager();
				
				manager.setUsername(rs.getString("username"));
				manager.setPassword(rs.getString("password"));
				manager.setEmail(rs.getString("email"));
				manager.setMid(rs.getInt("mid"));
				
				managers.add(manager);
			}
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return managers;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int selectManagerNums() {
		
		//定义sql语句
		String sql="select count(*) from manager";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			//执行sql语句
			rs=ps.executeQuery();
			
			int result=0;
			if(rs.next()) {
				
				result=rs.getInt(1);
				
			}
			
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
	public Manager selectManager(Manager manager) {
		//定义sql语句
		String sql="select * from manager where username=? and password=?";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			ps.setString(1, manager.getUsername());
			ps.setString(2,manager.getPassword());
			
			//执行sql语句
			rs=ps.executeQuery();
			
			Manager manager1 = new Manager();
			if(rs.next()) {
				
				manager1.setMid(rs.getInt("mid"));
				manager1.setUsername(rs.getString("username"));
				manager1.setPassword(rs.getString("password"));
				manager1.setEmail(rs.getString("email"));
				
			}
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return manager1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Manager selectManager(int mid) {
		
		//定义sql语句
		String sql="select * from manager where mid=?";
		
		try {
			//获取数据库连接对象
			connection=JdbcUtils.getConnection();
			//准备执行sql语句
			ps=connection.prepareStatement(sql);
			
			ps.setInt(1, mid);
			
			//执行sql语句
			rs=ps.executeQuery();
			
			Manager manager1 = new Manager();
			if(rs.next()) {
				
				manager1.setMid(rs.getInt("mid"));
				manager1.setUsername(rs.getString("username"));
				manager1.setPassword(rs.getString("password"));
				manager1.setEmail(rs.getString("email"));
				
			}
			
			//关闭资源
			JdbcUtils.close(connection, ps, rs);
			
			return manager1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
