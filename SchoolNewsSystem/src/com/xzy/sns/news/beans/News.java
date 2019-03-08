package com.xzy.sns.news.beans;

import java.sql.Date;

/**
 * 数据库中news表对应的实体类
 * @author xuzhiyuan
 *
 */
public class News {
	
	private Integer nid;
	private String title;
	private Character type;
	private String source;
	private Date date;
	private String content;
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public News(String title, Character type, String source, Date date, String content) {
		super();
		this.title = title;
		this.type = type;
		this.source = source;
		this.date = date;
		this.content = content;
	}
	
	public Integer getNid() {
		return nid;
	}
	public void setNid(Integer nid) {
		this.nid = nid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Character getType() {
		return type;
	}
	public void setType(Character type) {
		this.type = type;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "News [nid=" + nid + ", title=" + title + ", type=" + type + ", source=" + source + ", date=" + date
				+ ", content=" + content + "]";
	}
}
