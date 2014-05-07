package cn.edu.zust.dao;

import java.util.List;

import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;

public interface UserMessageDao {
	public UserMessage save(UserMessage userMessage);

	public List<UserMessage> find(User user);

	public void update(UserMessage userMessage);
}
