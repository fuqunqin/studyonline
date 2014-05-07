package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Frontier implements java.io.Serializable {

	private Integer id;
	private FrontierType frontierType;
	private Subject subject;
	private Date publishDate;
	private String title;
	private String content;

	public Frontier() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FrontierType getFrontierType() {
		return frontierType;
	}

	public void setFrontierType(FrontierType frontierType) {
		this.frontierType = frontierType;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}