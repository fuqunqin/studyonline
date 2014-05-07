package cn.edu.zust.biz.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import cn.edu.zust.biz.AdminBiz;
import cn.edu.zust.dao.AdminDao;
import cn.edu.zust.dao.CertificateDao;
import cn.edu.zust.dao.MenuDao;
import cn.edu.zust.dao.SecurityDao;
import cn.edu.zust.dao.StatusDao;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.Menu;
import cn.edu.zust.entity.Security;
import cn.edu.zust.entity.Status;
import cn.edu.zust.exception.ApplicationException;
import cn.edu.zust.exception.LoginException;
import cn.edu.zust.util.MD5Secrity;
import cn.edu.zust.util.Page;

public class AdminBizImpl implements AdminBiz {
	private AdminDao adminDao;
	private CertificateDao certificateDao;
	private SecurityDao securityDao;
	private StatusDao statusDao;
	private MenuDao menuDao;

	public AdminDao getAdminDao() {
		return adminDao;
	}

	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	public CertificateDao getCertificateDao() {
		return certificateDao;
	}

	public void setCertificateDao(CertificateDao certificateDao) {
		this.certificateDao = certificateDao;
	}

	public SecurityDao getSecurityDao() {
		return securityDao;
	}

	public void setSecurityDao(SecurityDao securityDao) {
		this.securityDao = securityDao;
	}

	public StatusDao getStatusDao() {
		return statusDao;
	}

	public void setStatusDao(StatusDao statusDao) {
		this.statusDao = statusDao;
	}

	public MenuDao getMenuDao() {
		return menuDao;
	}

	public void setMenuDao(MenuDao menuDao) {
		this.menuDao = menuDao;
	}

	public Admin login(Admin admin) throws ApplicationException {
		Admin a = adminDao.findByLoginName(admin.getLoginName());
		if (a == null
				|| !MD5Secrity.data2secret(admin.getLoginPassword()).equals(
						a.getLoginPassword())) {
			throw new LoginException();
		} else
			return a;
	}

	public Admin modify(Admin admin, Set<Menu> ms) {
		for (Menu m : ms) {
			menuDao.delete(m);
		}
		Certificate certificate = certificateDao.findById(admin
				.getCertificate().getId());
		Security security = securityDao.findById(admin.getSecurity().getId());
		Status status = statusDao.findById(admin.getStatus().getId());
		admin.setCertificate(certificate);
		admin.setSecurity(security);
		admin.setStatus(status);
		Set<Menu> menues = admin.getMenues();
		for (Menu menu : menues) {
			menu = menuDao.findById(menu.getId());
		}
		admin.setMenues(menues);
		admin = adminDao.update(admin);
		return admin;
	}

	public Admin add(Admin admin) {
		Certificate certificate = certificateDao.findById(admin
				.getCertificate().getId());
		Security security = securityDao.findById(admin.getSecurity().getId());
		Status status = statusDao.findById(-1);
		admin.setCertificate(certificate);
		admin.setSecurity(security);
		admin.setStatus(status);
		Set<Menu> menues = admin.getMenues();
		for (Menu menu : menues) {
			menu = menuDao.findById(menu.getId());
		}
		admin.setMenues(menues);
		admin = adminDao.save(admin);
		return admin;
	}

	public List<Admin> query(Page page) {
		return adminDao.findAll(page);
	}

	public Admin query(Integer id) {
		return adminDao.findById(id);
	}

	public void remove(List<Admin> admins) {
		for (Admin admin : admins) {
			adminDao.delete(admin);
		}
	}

	public Admin modify(Admin admin) {
		Certificate certificate = certificateDao.findById(admin
				.getCertificate().getId());
		Security security = securityDao.findById(admin.getSecurity().getId());
		Status status = statusDao.findById(admin.getStatus().getId());
		admin.setCertificate(certificate);
		admin.setSecurity(security);
		admin.setStatus(status);
		Set<Menu> menues = admin.getMenues();
		Set<Menu> ms = new HashSet<Menu>();
		for (Menu menu : menues) {
			menu = menuDao.findById(menu.getId());
			ms.add(menu);
		}
		admin.removeAll();
		for (Menu m : ms) {
			admin.addMenu(m);
		}
		admin = adminDao.update(admin);
		return admin;
	}

	public Admin query(String loginName) {
		return adminDao.findByLoginName(loginName);
	}
}
