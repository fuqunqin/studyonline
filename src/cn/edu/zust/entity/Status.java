package cn.edu.zust.entity;

@SuppressWarnings("serial")
public class Status implements java.io.Serializable {

	private Integer id;
	private String description;

	public Status() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}