package cn.edu.zust.web.dwr;

import cn.edu.zust.biz.UserBiz;
import cn.edu.zust.entity.User;
import cn.edu.zust.util.MD5Secrity;

public class UserDwr {
	private UserBiz userBiz;

	public UserBiz getUserBiz() {
		return userBiz;
	}

	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}

	public boolean query(String loginName) {
		User user = userBiz.query(loginName);
		if (user == null)
			return false;
		else
			return true;
	}
	public boolean queryUserLoginPassword(String loginName,String loginPassword){
		User user=new User();
		user.setLoginName(loginName);
		user.setLoginPassword(MD5Secrity.data2secret(loginPassword));
		user=userBiz.login(user);
		if(user==null)
		return false;
		else return true;
	}
}
