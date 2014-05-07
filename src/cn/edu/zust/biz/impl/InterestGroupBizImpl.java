package cn.edu.zust.biz.impl;

import java.util.Date;
import java.util.List;

import cn.edu.zust.biz.InterestGroupBiz;
import cn.edu.zust.dao.InterestGroupDao;
import cn.edu.zust.dao.UserMessageDao;
import cn.edu.zust.entity.Admin;
import cn.edu.zust.entity.InterestGroup;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;
import cn.edu.zust.util.Page;

public class InterestGroupBizImpl implements InterestGroupBiz {
	private InterestGroupDao interestGroupDao;
	private UserMessageDao userMessageDao;

	public InterestGroupDao getInterestGroupDao() {
		return interestGroupDao;
	}

	public void setInterestGroupDao(InterestGroupDao interestGroupDao) {
		this.interestGroupDao = interestGroupDao;
	}

	public UserMessageDao getUserMessageDao() {
		return userMessageDao;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		this.userMessageDao = userMessageDao;
	}

	public InterestGroup add(InterestGroup interestGroup) {
		interestGroup = interestGroupDao.save(interestGroup);
		return interestGroup;
	}

	public InterestGroup modify(InterestGroup interestGroup) {
		interestGroup = interestGroupDao.update(interestGroup);
		return interestGroup;
	}

	public List<InterestGroup> query(Page page) {
		return interestGroupDao.findAll(page);
	}

	public InterestGroup query(Integer id) {
		return interestGroupDao.findById(id);
	}

	public void remove(List<InterestGroup> interestGroups) {
		// TODO Auto-generated method stub

	}

	public List<InterestGroup> query(User user) {
		return interestGroupDao.findByUser(user);
	}

	public InterestGroup modifyByUser(InterestGroup interestGroup) {
		interestGroup = interestGroupDao.update(interestGroup);
		UserMessage userMessage = new UserMessage();
		for (User user : interestGroup.getUsers()) {
			if (!user.getId().equals(interestGroup.getUser().getId())) {
				userMessage.setMessage("您所在的兴趣小组信息已被小组创建者修改");
			}
		}
		return interestGroup;
	}

	public InterestGroup removeUser(InterestGroup interestGroup, User user,
			Admin admin) {
		interestGroup = interestGroupDao.update(interestGroup);
		UserMessage userMessage = new UserMessage();
		StringBuffer sb = new StringBuffer();
		sb.append("您已经被");
		if (admin != null) {
			sb.append("管理员" + admin.getLoginName());
		} else {
			sb.append("小组成立者" + interestGroup.getUser().getLoginName());
		}
		sb.append("移除兴趣小组" + interestGroup.getGroupName() + "，敬请原谅.");
		userMessage.setMessage(sb.toString());
		userMessage.setPublishDate(new Date());
		userMessage.setReadFlag("-1");
		userMessage.setUser(user);
		userMessageDao.save(userMessage);
		return interestGroup;

	}

	public void removeGroup(InterestGroup interestGroup, Admin admin) {
		interestGroup = interestGroupDao.update(interestGroup);
		UserMessage userMessage = new UserMessage();
		StringBuffer sb = new StringBuffer();
		sb.append("您所在的" + interestGroup.getGroupName() + "兴趣小组已经被");
		if (admin != null) {
			sb.append("管理员" + admin.getLoginName());
		} else {
			sb.append("小组成立者" + interestGroup.getUser().getLoginName());
		}
		sb.append("解散，敬请原谅.");
		userMessage.setMessage(sb.toString());
		userMessage.setPublishDate(new Date());
		userMessage.setReadFlag("-1");
		for (User user : interestGroup.getUsers()) {
			userMessage.setUser(user);
			userMessageDao.save(userMessage);
		}
	}

}
