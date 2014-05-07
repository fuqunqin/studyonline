package cn.edu.zust.biz.impl;

import java.util.List;

import cn.edu.zust.biz.UserMessageBiz;
import cn.edu.zust.dao.UserMessageDao;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;

public class UserMessageBizImpl implements UserMessageBiz {
	private UserMessageDao userMessageDao;

	public UserMessageDao getUserMessageDao() {
		return userMessageDao;
	}

	public void setUserMessageDao(UserMessageDao userMessageDao) {
		this.userMessageDao = userMessageDao;
	}

	public UserMessage addUserMessage(UserMessage userMessage) {
		return userMessageDao.save(userMessage);
	}

	public List<UserMessage> query(User user) {
		return userMessageDao.find(user);
	}

	public void modify(UserMessage userMessage) {
		userMessageDao.update(userMessage);
	}

}
