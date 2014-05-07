package cn.edu.zust.entity;

@SuppressWarnings("serial")
public class QualificationType implements java.io.Serializable {

	private Integer id;
	private String typeName;

	public QualificationType() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}