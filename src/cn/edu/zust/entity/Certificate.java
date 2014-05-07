package cn.edu.zust.entity;

@SuppressWarnings("serial")
public class Certificate implements java.io.Serializable {

	private Integer id;
	private String description;

	public Certificate() {
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