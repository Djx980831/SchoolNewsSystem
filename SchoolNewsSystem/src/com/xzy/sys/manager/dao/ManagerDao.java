package com.xzy.sys.manager.dao;

import java.util.List;

import com.xzy.sys.manager.beans.Manager;

/**
 * 对数据库中manager表进行操作
 * @author xuzhiyuan
 *
 */
public interface ManagerDao {

	//插入manager
	public int insertManager(Manager manager);
	
	//删除指定的manaer
	public int deleteManager(int mid);
	
	//修改manager
	public int updateManager(Manager manager);
	
	//查询manager
	public List<Manager> selectManagers(int pageNum);	
	
	//查询manager记录总数
	public int selectManagerNums();
	
	//查询数据是否有manager
	public Manager selectManager(Manager manager);

	//根据mid查询manager
	public Manager selectManager(int mid);
}
