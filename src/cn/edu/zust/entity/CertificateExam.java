package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class CertificateExam implements java.io.Serializable {

	private Integer id;
	private QualificationType qualificationType;
	private String title;
	private Date examDate;
	private String userBook;
	private Date publishDate;

	public CertificateExam() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public QualificationType getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(QualificationType qualificationType) {
		this.qualificationType = qualificationType;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getExamDate() {
		return examDate;
	}

	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}

	public String getUserBook() {
		return userBook;
	}

	public void setUserBook(String userBook) {
		this.userBook = userBook;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}