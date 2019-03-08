package com.xzy.sns.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class JdbcUtils {
	
	public static Connection connection;
	
	//加载驱动
	static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	} 
	
	//获取数据库连接对象
	public static Connection getConnection() throws SQLException{
		
		String url="jdbc:mysql://localhost:3306/abc";
		String user="root";
		String password="Djx980831";
		
		if(connection==null||connection.isClosed()) {
			
			connection=DriverManager.getConnection(url,user,password);
			
		}
		
		return connection;
	}
	
	//关闭资源
	public static void close(Connection connection,PreparedStatement ps,ResultSet res) throws SQLException {
		
		if(res!=null&&!res.isClosed()) {
			
			res.close();
			
		}
		
		if(ps!=null&&!ps.isClosed()) {
			
			ps.close();
			
		}
		
		if(connection!=null&&!connection.isClosed()) {
			
			connection.close();
			
		}
		
	}

}
