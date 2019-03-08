package com.xzy.sys.manager.beans;

/**
 * manager的实体类
 * @author xuzhiyuan
 *
 */
public class Manager {
	
	private Integer mid;
	private String username;
	private String password;
	private String email;
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Manager(String username, String password,String email) {
		super();
		this.username = username;
		this.password = password;
		this.email= email;
	}

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Manager [mid=" + mid + ", username=" + username + ", password=" + password + "]";
	}
}
