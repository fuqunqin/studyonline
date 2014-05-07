package cn.edu.zust.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class User implements java.io.Serializable {

	private Integer id;
	private Certificate certificate;
	private Status status;
	private Security security;
	private String loginName;
	private String loginPassword;
	private String email;
	private String certificateNumber;
	private String securityAnswer;
	private Date registerDate;
	private Set<InterestGroup> interestGroups = new HashSet<InterestGroup>();

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}

	public Certificate getCertificate() {
		return certificate;
	}

	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Security getSecurity() {
		return security;
	}

	public void setSecurity(Security security) {
		this.security = security;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getSecurityAnswer() {
		return securityAnswer;
	}

	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}

	public Set<InterestGroup> getInterestGroups() {
		return interestGroups;
	}

	public void setInterestGroups(Set<InterestGroup> interestGroups) {
		this.interestGroups = interestGroups;
	}

	public void addInterestGroup(InterestGroup ig) {
		if (ig == null)
			return;
		interestGroups.add(ig);
		ig.getUsers().add(this);
	}

	public void removeInterestGroup(InterestGroup ig) {
		if (ig == null)
			return;
		ig.getUsers().remove(this);
		interestGroups.remove(ig);
	}

	public void clearInterestGroup() {
		for (InterestGroup ig : interestGroups) {
			ig.getUsers().remove(this);
		}
		interestGroups.clear();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}