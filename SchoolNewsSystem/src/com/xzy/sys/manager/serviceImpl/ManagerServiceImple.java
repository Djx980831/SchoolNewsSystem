package com.xzy.sys.manager.serviceImpl;

import java.util.List;

import com.xzy.sys.manager.beans.Manager;
import com.xzy.sys.manager.dao.ManagerDao;
import com.xzy.sys.manager.service.ManagerService;

public class ManagerServiceImple implements ManagerService{

	ManagerDao dao;
	
	public ManagerServiceImple(ManagerDao dao) {
		
		this.dao=dao;
		
	}

	
	public int createAccount(Manager manager) {
		
		return dao.insertManager(manager);
	}


	public int removeAccount(int mid) {
		
		return dao.deleteManager(mid);
	}

	public int modifyAccount(Manager manager) {
	
		return dao.updateManager(manager);
	}

	@Override
	public int queryTotalPageNums() {
		
		int count=dao.selectManagerNums();
		return count%10==0?count/10:count/10+1;
	}


	@Override
	public List<Manager> queryManagers(int pageNum) {
		
		return dao.selectManagers(pageNum);
	}


	@Override
	public Manager checkLogin(Manager manager) {
		
		return dao.selectManager(manager);
	}


	@Override
	public Manager queryManager(int mid) {
		
		return dao.selectManager(mid);
	}	
}
