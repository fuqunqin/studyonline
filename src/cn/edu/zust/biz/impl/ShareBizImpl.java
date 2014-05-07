package cn.edu.zust.biz.impl;

import java.util.Date;
import java.util.List;

import cn.edu.zust.biz.ShareBiz;
import cn.edu.zust.dao.ShareDao;
import cn.edu.zust.dao.ShareTypeDao;
import cn.edu.zust.dao.SubjectDao;
import cn.edu.zust.dao.UserDao;
import cn.edu.zust.dao.UserMessageDao;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.Share;
import cn.edu.zust.entity.ShareType;
import cn.edu.zust.entity.Subject;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;
import cn.edu.zust.util.Page;

public class ShareBizImpl implements ShareBiz {
	private ShareDao shareDao;
	private ShareTypeDao shareTypeDao;
	private SubjectDao subjectDao;
	private UserDao userDao;
	private UserMessageDao userMessageDao;

	public ShareDao getShareDao() {
		return shareDao;
	}

	public void setShareDao(ShareDao shareDao) {
		this.shareDao = shareDao;
	}

	public ShareTypeDao getShareTypeDao() {
		return shareTypeDao;
	}

	public void setShareTypeDao(ShareTypeDao shareTypeDao) {
		this.shareTypeDao = shareTypeDao;
	}

	public SubjectDao getSubjectDao() {
		return subjectDao;
	}

	public void setSubjectDao(SubjectDao subjectDao) {
		this.subjectDao = subjectDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserMessageDao getUserMessageDao() {
		return userMessageDao;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		this.userMessageDao = userMessageDao;
	}

	public Share add(Share share) {
		Subject subject = subjectDao.findById(share.getSubject().getId());
		share.setSubject(subject);
		ShareType shareType = shareTypeDao.findById(share.getShareType()
				.getId());
		share.setShareType(shareType);
		return shareDao.save(share);
	}

	public Share modify(Share share, Admin admin) {
		Subject subject = subjectDao.findById(share.getSubject().getId());
		share.setSubject(subject);
		ShareType shareType = shareTypeDao.findById(share.getShareType()
				.getId());
		share.setShareType(shareType);
		User user = null;
		if (share.getUser() != null && admin != null) {
			user = userDao.findById(share.getUser().getId());
			share.setUser(user);
			UserMessage userMessage = new UserMessage();
			userMessage.setUser(user);
			userMessage.setReadFlag("-1");
			userMessage.setDeleteFlag("-1");
			userMessage.setPublishDate(new Date());
			userMessage.setMessage("由于您上传的文件有些问题，现已被管理员"
					+ "修改，如有疑问，请与管理员联系，感谢您提供的共享资料，欢迎您提出宝贵的意见");
			userMessageDao.save(userMessage);
		}
		return shareDao.update(share);
	}

	public List<Share> query(Page page) {
		return shareDao.findAll(page);
	}

	public Share query(Integer id) {
		return shareDao.findById(id);
	}

	public void remove(List<Share> shares, Admin admin) {
		for (Share share : shares) {
			if (share.getUser() != null && admin != null) {
				User user = userDao.findById(share.getUser().getId());
				share.setUser(user);
				UserMessage userMessage = new UserMessage();
				userMessage.setUser(user);
				userMessage.setReadFlag("-1");
				userMessage.setDeleteFlag("-1");
				userMessage.setPublishDate(new Date());
				userMessage.setMessage("由于您上传的文件存在问题，现已被管理员"
						+ "删除，如有疑问，请与管理员联系，感谢您提供的共享资料，欢迎您提出宝贵的意见");
				userMessageDao.save(userMessage);
			}
			shareDao.delete(share);
		}
	}

	public Share query(String shareUrl) {
		return shareDao.findByShareUrl(shareUrl);
	}

	public List<Share> queryByUser(User user) {
		return shareDao.findByUser(user);
	}

}
