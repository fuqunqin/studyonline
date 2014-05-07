package cn.edu.zust.web.action;

import org.apache.struts.actions.MappingDispatchAction;

import cn.edu.zust.biz.UserMessageBiz;

public class UserMessageAction extends MappingDispatchAction{
	private UserMessageBiz userMessageBiz;

	public UserMessageBiz getUserMessageBiz() {
		return userMessageBiz;
	}

	public void setUserMessageBiz(UserMessageBiz userMessageBiz) {
		this.userMessageBiz = userMessageBiz;
	}
	
}
