package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Win implements java.io.Serializable {

	private Integer id;
	private Subject subject;
	private String winName;
	private String winUserName;
	private Date winDate;
	private String winDescription;
	private Date publishDate;

	public Win() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public String getWinName() {
		return winName;
	}

	public void setWinName(String winName) {
		this.winName = winName;
	}

	public String getWinUserName() {
		return winUserName;
	}

	public void setWinUserName(String winUserName) {
		this.winUserName = winUserName;
	}

	public Date getWinDate() {
		return winDate;
	}

	public void setWinDate(Date winDate) {
		this.winDate = winDate;
	}

	public String getWinDescription() {
		return winDescription;
	}

	public void setWinDescription(String winDescription) {
		this.winDescription = winDescription;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}