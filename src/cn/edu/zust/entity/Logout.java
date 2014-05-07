package cn.edu.zust.entity;

@SuppressWarnings("serial")
public class Logout implements java.io.Serializable {

	private Integer id;
	private User user;
	private String logoutCause;

	public Logout() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getLogoutCause() {
		return logoutCause;
	}

	public void setLogoutCause(String logoutCause) {
		this.logoutCause = logoutCause;
	}
}