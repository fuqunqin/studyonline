package cn.edu.zust.entity;

@SuppressWarnings("serial")
public class Subject implements java.io.Serializable {

	private Integer id;
	private String subjectName;

	public Subject() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	
}