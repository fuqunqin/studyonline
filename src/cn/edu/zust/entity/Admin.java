package cn.edu.zust.entity;

import java.util.HashSet;
import java.util.Set;

@SuppressWarnings("serial")
public class Admin implements java.io.Serializable {

	private Integer id;
	private Certificate certificate;
	private Status status;
	private Security security;
	private String loginName;
	private String loginPassword;
	private String certificateNumber;
	private String securityAnswer;
	private String email;
	private String telephone;
	private String address;
	private Set<Menu> menues = new HashSet<Menu>();

	public Admin() {
	}

	public Admin(String loginName, String loginPassword) {
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}

	public void addMenu(Menu menu) {
		if (menu == null)
			return;
		menues.add(menu);
		menu.getAdmins().add(this);
	}

	public void removeMenu(Menu menu) {
		if (menu == null)
			return;
		menu.getAdmins().remove(this);
		menues.remove(menu);
	}

	public void removeAll() {
		for (Menu menu : menues) {
			menu.getAdmins().remove(this);
		}
		menues.clear();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Menu> getMenues() {
		return menues;
	}

	public void setMenues(Set<Menu> menues) {
		this.menues = menues;
	}

}