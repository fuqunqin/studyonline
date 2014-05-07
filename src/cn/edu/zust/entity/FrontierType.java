package cn.edu.zust.entity;

@SuppressWarnings("serial")
public class FrontierType implements java.io.Serializable {

	private Integer id;
	private String frontierType;

	public FrontierType() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrontierType() {
		return frontierType;
	}

	public void setFrontierType(String frontierType) {
		this.frontierType = frontierType;
	}

}