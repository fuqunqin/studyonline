package cn.edu.zust.entity;

import java.util.Date;

@SuppressWarnings("serial")
public class Test implements java.io.Serializable {

	private Integer id;
	private String title;
	private QualificationType qualificationType;
	private Date uploadeDate;
	private String uploadeUrl;

	public Test() {
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

	public QualificationType getQualificationType() {
		return qualificationType;
	}

	public void setQualificationType(QualificationType qualificationType) {
		this.qualificationType = qualificationType;
	}

	public Date getUploadeDate() {
		return uploadeDate;
	}

	public void setUploadeDate(Date uploadeDate) {
		this.uploadeDate = uploadeDate;
	}

	public String getUploadeUrl() {
		return uploadeUrl;
	}

	public void setUploadeUrl(String uploadeUrl) {
		this.uploadeUrl = uploadeUrl;
	}

}