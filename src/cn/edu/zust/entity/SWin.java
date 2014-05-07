package cn.edu.zust.entity;

import java.util.Date;

/**
 * SWin entity.
 * 
 * @author MyEclipse Persistence Tools
 */

@SuppressWarnings("serial")
public class SWin implements java.io.Serializable {

	// Fields

	private long id;
	private Subject SSubject;
	private String winName;
	private String winUserName;
	private Date winDate;
	private String winDescription;
	private Date publishDate;

	// Constructors

	/** default constructor */
	public SWin() {
	}

	/** minimal constructor */
	public SWin(String winName) {
		this.winName = winName;
	}

	/** full constructor */
	public SWin(Subject SSubject, String winName, String winUserName,
			Date winDate, String winDescription, Date publishDate) {
		this.SSubject = SSubject;
		this.winName = winName;
		this.winUserName = winUserName;
		this.winDate = winDate;
		this.winDescription = winDescription;
		this.publishDate = publishDate;
	}

	// Property accessors

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Subject getSSubject() {
		return this.SSubject;
	}

	public void setSSubject(Subject SSubject) {
		this.SSubject = SSubject;
	}

	public String getWinName() {
		return this.winName;
	}

	public void setWinName(String winName) {
		this.winName = winName;
	}

	public String getWinUserName() {
		return this.winUserName;
	}

	public void setWinUserName(String winUserName) {
		this.winUserName = winUserName;
	}

	public Date getWinDate() {
		return this.winDate;
	}

	public void setWinDate(Date winDate) {
		this.winDate = winDate;
	}

	public String getWinDescription() {
		return this.winDescription;
	}

	public void setWinDescription(String winDescription) {
		this.winDescription = winDescription;
	}

	public Date getPublishDate() {
		return this.publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}

}