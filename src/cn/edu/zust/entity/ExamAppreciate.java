package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class ExamAppreciate implements java.io.Serializable {

	private Integer id;
	private String title;
	private String content;
	private Date publishDate;

	public ExamAppreciate() {
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