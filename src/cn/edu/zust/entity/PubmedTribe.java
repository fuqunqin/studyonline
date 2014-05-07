package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class PubmedTribe implements java.io.Serializable {
	private Integer id;
	private PubmedType pubmedType;
	private String title;
	private String content;
	private Date publishDate;

	public PubmedTribe() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PubmedType getPubmedType() {
		return pubmedType;
	}

	public void setPubmedType(PubmedType pubmedType) {
		this.pubmedType = pubmedType;
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

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}