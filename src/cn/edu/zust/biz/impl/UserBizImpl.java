package cn.edu.zust.biz.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.edu.zust.biz.UserBiz;
import cn.edu.zust.dao.CertificateDao;
import cn.edu.zust.dao.SecurityDao;
import cn.edu.zust.dao.StatusDao;
import cn.edu.zust.dao.UserDao;
import cn.edu.zust.dao.UserMessageDao;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Certificate;
import cn.edu.zust.entity.Security;
import cn.edu.zust.entity.Status;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;
import cn.edu.zust.util.Page;

public class UserBizImpl implements UserBiz {
	private UserDao userDao;
	private CertificateDao certificateDao;
	private SecurityDao securityDao;
	private StatusDao statusDao;
	private UserMessageDao userMessageDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
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

	public UserMessageDao getUserMessageDao() {
		return userMessageDao;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		this.userMessageDao = userMessageDao;
	}

	public User add(User user) {
		Certificate certificate = certificateDao.findById(user.getCertificate()
				.getId());
		Security security = securityDao.findById(user.getSecurity().getId());
		Status status = statusDao.findById(-1);
		user.setCertificate(certificate);
		user.setSecurity(security);
		user.setStatus(status);
		user = userDao.save(user);

		UserMessage userMessage = new UserMessage();
		userMessage.setDeleteFlag("-1");
		userMessage.setPublishDate(new Date());
		userMessage.setReadFlag("-1");
		userMessage.setUser(user);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH");
		userMessage.setMessage(user.getLoginName() + "恭喜您于"
				+ sdf.format(new Date()) + "时间注册成功，请注意保管好自己的用户名和密码！谢谢您的支持！");
		userMessageDao.save(userMessage);
		return user;
	}

	public User modify(User user, Admin admin) {
		Certificate certificate = certificateDao.findById(user.getCertificate()
				.getId());
		Security security = securityDao.findById(user.getSecurity().getId());
		Status status = statusDao.findById(user.getStatus().getId());
		user.setCertificate(certificate);
		user.setSecurity(security);
		user.setStatus(status);
		user = userDao.update(user);
		UserMessage userMessage = new UserMessage();
		if (admin != null) {
			userMessage.setUser(user);
			userMessage.setMessage("管理员已经配合您完成个人信息的修改，如有疑问，请与管理员联系！");
			userMessage.setPublishDate(new Date());
			userMessage.setReadFlag("-1");
			userMessage.setDeleteFlag("-1");
			userMessageDao.save(userMessage);
		}
		return user;
	}

	public List<User> query(Page page) {
		return userDao.findAll(page);
	}

	public void updateUserStatus(List<User> users, Integer statusId) {
		for (User user : users) {
			user = userDao.findById(user.getId());
			Status status = statusDao.findById(statusId);
			user.setStatus(status);
			userDao.update(user);
		}
	}

	public User query(Integer id) {
		return userDao.findById(id);
	}

	public List<User> query(User user) {
		StringBuffer sb = new StringBuffer("from User as u ");
		sb.append(" where u.userName like '%").append(
				user.getLoginName().trim().replace(" ", "_")).append("%'");
		sb.append(" and u.email like '%").append(user.getEmail()).append("%'");
		if (user.getStatus().getId() != 0) {
			sb.append(" and u.status=").append(user.getStatus());
		}
		if (user.getCertificate().getId() != 0) {
			sb.append(" and u.certificate=").append(user.getCertificate());
		}
		sb.append(" and u.certificateNumber like '%").append(
				user.getCertificateNumber().trim().replace(" ", "_")).append(
				"%'");
		return userDao.find(sb.toString());
	}

	public User query(String loginName) {
		String hql = "from User as u where u.loginName='" + loginName + "'";
		List<User> users = userDao.find(hql);
		if (users != null && users.size() > 0) {
			return users.get(0);
		}
		return null;
	}

	public User login(User user) {
		String hql = "from User as u where u.loginName='" + user.getLoginName()
				+ "' and u.loginPassword='" + user.getLoginPassword() + "'";
		List<User> users = userDao.find(hql);
		if (users != null && users.size() > 0) {
			return users.get(0);
		} else
			return null;
	}

	public List<User> queryNew(int n) {
		return userDao.findNew(n);
	}
}
