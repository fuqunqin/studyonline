package cn.edu.zust.biz;

import java.util.List;

import cn.edu.zust.entity.User;
import cn.edu.zust.entity.UserMessage;

public interface UserMessageBiz {
	// 添加消息
	public UserMessage addUserMessage(UserMessage userMessage);

	// 查询消息
	public List<UserMessage> query(User user);

	// 修改消息
	public void modify(UserMessage userMessage);
}
