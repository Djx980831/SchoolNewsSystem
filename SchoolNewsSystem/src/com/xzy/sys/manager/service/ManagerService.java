package com.xzy.sys.manager.service;

import java.util.List;

import com.xzy.sys.manager.beans.Manager;

/**
 * 完成新建账号，删除账号，修改账号操作
 * @author xuzhiyuan
 *
 */
public interface ManagerService {
	
	//新建账号
	public int createAccount(Manager manager);
	
	//删除账号
	public int removeAccount(int mid);
	
	//修改账号
	public int modifyAccount(Manager manager);
	
	//查询总页数
	public int queryTotalPageNums();
	
	//查询manager
	public List<Manager> queryManagers(int pageNum);

	//检验是都有该manager
	public Manager checkLogin(Manager manager);

	//根据mid查询manager
	public Manager queryManager(int mid);

}
