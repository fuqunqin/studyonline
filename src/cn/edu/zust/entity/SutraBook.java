package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class SutraBook implements java.io.Serializable {

	private Integer id;
	private Subject subject;
	private String bookName;
	private String publicCompany;
	private String bookUserName;
	private Date publicDate;
	private String bookSynopsis;
	private Date publishDate;

	public SutraBook() {
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

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getPublicCompany() {
		return publicCompany;
	}

	public void setPublicCompany(String publicCompany) {
		this.publicCompany = publicCompany;
	}

	public String getBookUserName() {
		return bookUserName;
	}

	public void setBookUserName(String bookUserName) {
		this.bookUserName = bookUserName;
	}

	public Date getPublicDate() {
		return publicDate;
	}

	public void setPublicDate(Date publicDate) {
		this.publicDate = publicDate;
	}

	public String getBookSynopsis() {
		return bookSynopsis;
	}

	public void setBookSynopsis(String bookSynopsis) {
		this.bookSynopsis = bookSynopsis;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}