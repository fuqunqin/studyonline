package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class OnlineListening implements java.io.Serializable {

	private Integer id;
	private String title;
	private String listenUrl;
	private Date publishDate;

	public OnlineListening() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getListenUrl() {
		return listenUrl;
	}

	public void setListenUrl(String listenUrl) {
		this.listenUrl = listenUrl;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}