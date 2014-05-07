package cn.edu.zust.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import cn.edu.zust.dao.UserMessageDao;
import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;

public class UserMessageDaoImpl implements UserMessageDao {
	private HibernateTemplate ht;

	public HibernateTemplate getHt() {
		return ht;
	}

	public void setHt(HibernateTemplate ht) {
		this.ht = ht;
	}

	public UserMessage save(UserMessage userMessage) {
		ht.save(userMessage);
		return userMessage;
	}

	@SuppressWarnings("unchecked")
	public List<UserMessage> find(final User user) {
		String hql = "from UserMessage as um where um.user=? and um.readFlag=? order by um.publishDate desc";
		Object[] values = { user, "-1" };
		return ht.find(hql, values);
	}

	public void update(UserMessage userMessage) {
		ht.update(userMessage);
	}

}
